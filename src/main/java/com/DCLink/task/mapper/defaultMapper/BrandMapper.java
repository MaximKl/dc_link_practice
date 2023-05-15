package com.DCLink.task.mapper.defaultMapper;

import com.DCLink.task.dto.defaultDTO.BrandDTO;
import com.DCLink.task.model.Brand;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class BrandMapper implements Function<Brand, BrandDTO> {
    @Override
    public BrandDTO apply(Brand brand) {
        return new BrandDTO(
                brand.getId(),
                brand.getName()
        );
    }
}
