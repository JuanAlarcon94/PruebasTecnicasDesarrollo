package com.product.adapter.primary.api;

import com.product.adapter.application.model.ProductDTO;
import com.product.adapter.primary.api.model.ResponseEntity;

import java.util.List;

public interface ResponseEntityFactory {
    ResponseEntity toResponseEntity(List<ProductDTO> products, String errorMessage);
}
