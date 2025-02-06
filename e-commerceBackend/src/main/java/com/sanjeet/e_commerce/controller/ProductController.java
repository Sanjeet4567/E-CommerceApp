package com.sanjeet.e_commerce.controller;

import com.sanjeet.e_commerce.exception.ProductException;
import com.sanjeet.e_commerce.model.Product;
import com.sanjeet.e_commerce.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;
    @GetMapping("/products")
    public ResponseEntity<Page<Product>> findProductByCategoryHandler(@RequestParam String category,
                                                                      @RequestParam List<String> color,@RequestParam List<String> size,@RequestParam Integer minPrice,
                                                                      @RequestParam Integer maxPrice,@RequestParam Integer minDiscount,@RequestParam String sort,
                                                                      @RequestParam String stock,@RequestParam Integer pageNumber, @RequestParam Integer pageSize){
        Page<Product> res=productService.getAllProduct(category,color,size,minPrice,maxPrice,minDiscount,sort,stock,pageNumber,pageSize);
        return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
    }
    @GetMapping("/products/id/{productId}")
    public ResponseEntity<Product> findProductByIdHandler(@PathVariable Long productId)throws ProductException{
        Product product=productService.findProductById(productId);
        return new ResponseEntity<Product>(product,HttpStatus.ACCEPTED);
    }
//    @GetMapping("/products/search")
//    public ResponseEntity<List<Product>> searchProductHandler(@RequestParam String q){
//        List<Product> products=productService.searchProduct(q);
//        return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
//    }
}
