package com.DCLink.task.repository;

import com.DCLink.task.model.ProductType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TypeRepository extends CrudRepository<ProductType, Integer> {

    List<ProductType> findAllBy();

}
