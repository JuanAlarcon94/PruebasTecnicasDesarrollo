package com.product.domain.port;

import com.product.domain.model.ProductVO;

import java.util.List;
import java.util.Optional;

public interface ProductRepository
{
    Optional<ProductVO> getProductById(Long id);
    List<String> getSimilarProductIds(Long id);

}
