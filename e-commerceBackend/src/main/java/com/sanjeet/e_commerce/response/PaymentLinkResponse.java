package com.sanjeet.e_commerce.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class PaymentLinkResponse {
    private String payment_link_url;
    private String  payment_link_id;
}
