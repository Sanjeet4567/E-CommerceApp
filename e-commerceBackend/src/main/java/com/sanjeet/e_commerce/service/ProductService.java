package com.sanjeet.e_commerce.service;

import com.sanjeet.e_commerce.exception.ProductException;
import com.sanjeet.e_commerce.model.Product;
import com.sanjeet.e_commerce.request.CreateProductRequest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    public Product createProduct(CreateProductRequest req);

    public String deleteProduct(Long productId) throws ProductException;
    public Product updateProduct(Long productId,Product req)throws ProductException;
    public Product findProductById(Long id)throws ProductException;
    public List<Product> findProductByCategory(String category);
    public Page<Product> getAllProduct(String category, List<String>colors, List<String> sizes , Integer minPrice , Integer maxPrice, Integer minDiscount, String sort, String stock, Integer pageNumber, Integer pageSize);

    List<Product> findAllProduct();
}
