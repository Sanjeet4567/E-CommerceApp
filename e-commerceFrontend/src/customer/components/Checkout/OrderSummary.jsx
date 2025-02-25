import React, { useEffect } from "react";
import AddressCard from "../AddressCard/AddressCard";
import { Button } from "@mui/material";
import CartCard from "../Cart/CartCard";
import { useDispatch, useSelector } from "react-redux";
import { getOrderById } from "../../../State/Order/Action";
import { useLocation } from "react-router-dom";
import { createPayment } from "../../../State/Payment/Action";
const OrderSummary = () => {
  const dispatch = useDispatch();
  const location = useLocation();
  const { order } = useSelector((store) => store);
  const searchParams = new URLSearchParams(location.search);
  const orderId = searchParams.get("order_id");
  useEffect(() => {
    dispatch(getOrderById(orderId));
    console.log(order);
  }, [orderId]);

  const handleCheckout=()=>{
    dispatch(createPayment(orderId))
  }
  return (
    <div>
      <div className="p-5 shadow-lg rounded-s-md border">
        <AddressCard address={order?.order?.shippingAddress} />
      </div>
      <div>
        <div className="lg:grid grid-cols-3 lg:px-16 relative">
          <div className="mt-4 col-span-2 space-y-3">
            {order?.order?.orderItems?.map((item) => (
              <CartCard item={item} />
            ))}
          </div>
          <div className="px-5 sticky top-0 h-[100vh] mt-5 lg:mt-0">
            <div className="border">
              <p className="uppercase font-bold opacity-60 pb-4">
                Price Details
              </p>
              <hr />
              <div className="space-y-3 font-semibold mb-10 p-2">
                <div className="flex justify-between pt-3 text-black">
                  <span>Price</span>
                  <span>₹{order.order?.totalPrice}</span>
                </div>
                <div className="flex justify-between pt-3 text-black">
                  <span>Discount</span>
                  <span className="text-green-600 font-bold">
                    -₹{order.order?.discount}
                  </span>
                </div>
                <div className="flex justify-between pt-3 text-black">
                  <span>Delivery Charges</span>
                  <span className="text-green-600 font-bold">Free</span>
                </div>
                <div className="flex justify-between pt-3 text-black">
                  <span>Toatal Amount</span>
                  <span className="text-green-600 font-bold">
                    ₹{order.order?.totalDiscountedPrice}
                  </span>
                </div>
              </div>
              <Button
                variant="contained"
                className="w-full"
                sx={{ px: "2.5rem", py: "0.7rem", bgcolor: "#9155fd" }}
                onClick={handleCheckout}
              >
                Pay Now
              </Button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default OrderSummary;
