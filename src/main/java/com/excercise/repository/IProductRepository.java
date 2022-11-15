package com.excercise.repository;

import com.excercise.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    Product findProductById(Long id);
    boolean existsProductById(Long id);



}
