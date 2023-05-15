package com.DCLink.task.mapper.defaultMapper;

import com.DCLink.task.dto.defaultDTO.ProductTypeDTO;
import com.DCLink.task.model.ProductType;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ProductTypeMapper implements Function<ProductType, ProductTypeDTO> {

    @Override
    public ProductTypeDTO apply(ProductType productType) {
        return new ProductTypeDTO(
                productType.getId(),
                productType.getName()
        );
    }
}
