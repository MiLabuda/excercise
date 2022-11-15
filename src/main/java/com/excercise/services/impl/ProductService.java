package com.excercise.services.impl;

import com.excercise.model.Product;
import com.excercise.repository.IProductRepository;
import com.excercise.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductService {

    private final IProductRepository productRepository;

    @Autowired
    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductByProductId(Long id) {
        return productRepository.findProductById(id);
    }

    @Override
    public void save(Product product) {
        product.setId();
        productRepository.save(product);
    }

    @Override
    public boolean existProductById(Long id) {
        return productRepository.existsById(id);
    }

    @Override
    public void delete(Long id) {
        productRepository.delete(getProductByProductId(id));
    }
}
