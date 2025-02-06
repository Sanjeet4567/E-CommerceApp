package com.sanjeet.e_commerce.controller;

import com.razorpay.Payment;
import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.sanjeet.e_commerce.exception.OrderException;
import com.sanjeet.e_commerce.model.Order;
import com.sanjeet.e_commerce.repository.OrderRepository;
import com.sanjeet.e_commerce.response.ApiResponse;
import com.sanjeet.e_commerce.response.PaymentLinkResponse;
import com.sanjeet.e_commerce.service.OrderService;
import com.sanjeet.e_commerce.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@NoArgsConstructor
public class PaymentController {

    @Value("${razorpay.api.key}")
    String apiKey;

    @Value("${razorpay.api.secret}")
    String apiSecret;

    @Value("${successfulPaymentURL}")
    String successfulPaymentURL;

    private OrderService orderService;
    private UserService userService;
    private OrderRepository orderRepository;

    @PostMapping("/payments/{orderId}")
    public ResponseEntity<PaymentLinkResponse> createPaymentLink(@PathVariable Long orderId,
                                                                 @RequestHeader("Authorization")String jwt)throws OrderException,RazorpayException {
        Order order=orderService.findOrderById(orderId);
        try{
            RazorpayClient razorpayClient=new RazorpayClient(apiKey,apiSecret);

            JSONObject paymentLinkRequest=new JSONObject();
            paymentLinkRequest.put("amount",order.getTotalPrice()*100);
            paymentLinkRequest.put("currency","INR");

            JSONObject customer=new JSONObject();
            customer.put("name",order.getUser().getFirstName());
            customer.put("email",order.getUser().getEmail());
            paymentLinkRequest.put("customer",customer);

            JSONObject notify=new JSONObject();
            notify.put("sms",true);
            notify.put("email",true);
            paymentLinkRequest.put("notify",notify);

            paymentLinkRequest.put("callback_url",successfulPaymentURL+orderId);
            paymentLinkRequest.put("callback_method","get");

            PaymentLink paymentLink=razorpayClient.paymentLink.create(paymentLinkRequest);

            String paymentLinkId=paymentLink.get("id");
            String paymentLinkURL=paymentLink.get("short_url");

            PaymentLinkResponse res=new PaymentLinkResponse();
            res.setPayment_link_id(paymentLinkId);
            res.setPayment_link_url(paymentLinkURL);

            return new ResponseEntity<>(res, HttpStatus.CREATED);


        }catch(Exception e){
            throw new RazorpayException(e.getMessage());
        }
    }

    @GetMapping("/payments")
    public ResponseEntity<ApiResponse> redirect(@RequestParam(name="payment_id")String paymentId,
                                                @RequestParam(name="order_id")Long orderId)throws OrderException,RazorpayException{
        Order order=orderService.findOrderById(orderId);
        RazorpayClient razorpayClient=new RazorpayClient(apiKey,apiSecret);
        try{
            Payment payment=razorpayClient.payments.fetch(paymentId);

            if(payment.get("status").equals("captured")){
                order.getPaymentDetails().setPaymentId(paymentId);
                order.getPaymentDetails().setStatus("COMPLETED");
                order.setOrderStatus("PLACED");
                orderRepository.save(order);
            }
            ApiResponse response=new ApiResponse();
            response.setMessage("Your order got placed");
            response.setStatus(true);
            return new ResponseEntity<>(response,HttpStatus.CREATED);
        }catch (Exception e){
            throw new RazorpayException(e.getMessage());
        }

    }
}
