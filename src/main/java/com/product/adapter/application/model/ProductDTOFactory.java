package com.product.adapter.application.model;

import com.product.domain.model.ProductVO;

public interface ProductDTOFactory {
    ProductDTO toDTO(ProductVO vo);
}
