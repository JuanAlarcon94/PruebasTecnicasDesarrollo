package com.product.adapter.application;

import com.product.adapter.application.model.ProductDTO;
import java.util.List;

public interface ProductUseCase {
    List<ProductDTO> getSimilarProducts(Long id);
}
