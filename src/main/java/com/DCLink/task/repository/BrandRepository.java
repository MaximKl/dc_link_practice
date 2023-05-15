package com.DCLink.task.repository;

import com.DCLink.task.model.Brand;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BrandRepository extends CrudRepository<Brand, Long> {

    List<Brand> findAllBy();

}
