package com.product.adapter.application.model.impl;

import com.product.adapter.application.model.ProductDTO;
import com.product.adapter.application.model.ProductDTOFactory;
import com.product.domain.model.ProductVO;
import org.springframework.stereotype.Component;

@Component
public class ProductDTOFactoryImpl implements ProductDTOFactory {

    public ProductDTOFactoryImpl() {
        // Default constructor
    }

    @Override
    public ProductDTO toDTO(ProductVO vo) {
        if (vo == null) {
            return null;
        }
        return new ProductDTO(
                vo.getId(),
                vo.getName(),
                vo.getPrice(),
                vo.isAvailability()
        );
    }
}
