package com.product.adapter.primary.api.model.impl;

import com.product.adapter.application.model.ProductDTO;
import com.product.adapter.application.model.ProductDTOFactory;
import com.product.adapter.primary.api.ResponseEntityFactory;
import com.product.adapter.primary.api.model.ResponseEntity;
import com.product.domain.model.ProductVO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResponseEntityFactoryImpl implements ResponseEntityFactory {

    @Override
    public ResponseEntity toResponseEntity(List<ProductDTO> products, String errorMessage) {
        return new ResponseEntity(products, errorMessage);
    }
}
