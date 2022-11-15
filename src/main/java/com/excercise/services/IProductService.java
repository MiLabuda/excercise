package com.excercise.services;

import com.excercise.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();
    Product getProductByProductId(Long id);
    void save(Product product);
    boolean existProductById(Long id);
    void delete(Long id);
}
