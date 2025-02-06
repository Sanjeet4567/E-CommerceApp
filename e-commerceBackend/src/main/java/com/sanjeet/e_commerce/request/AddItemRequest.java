package com.sanjeet.e_commerce.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AddItemRequest {
    private Long productId;
    private String size;
    private int quantity;
    private Integer price;

}
