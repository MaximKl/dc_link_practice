package com.DCLink.task.repository;

import com.DCLink.task.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAllBy();
}
