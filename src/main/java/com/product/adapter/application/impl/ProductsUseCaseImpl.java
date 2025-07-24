package com.product.adapter.application.impl;

import com.product.adapter.application.ProductsUseCase;
import com.product.adapter.application.model.ProductDTO;
import com.product.adapter.application.model.ProductDTOFactory;
import com.product.domain.model.ProductVO;
import com.product.domain.port.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductsUseCaseImpl implements ProductsUseCase {

    private final ProductRepository productRepository;
    private final ProductDTOFactory productDTOFactory;

    public ProductsUseCaseImpl(ProductRepository productRepository,
                               ProductDTOFactory productDTOFactory) {
        this.productRepository = productRepository;
        this.productDTOFactory = productDTOFactory;
    }

    public List<ProductDTO> getSimilarProducts(Long id) {
        List<String> similarProductIds = productRepository.getSimilarProductIds(id);
        List<ProductDTO> result = new ArrayList<>();
        for (String productId : similarProductIds) {
            Optional<ProductVO> productVO = productRepository.getProductById(Long.valueOf(productId));
            productVO.ifPresent(vo -> result.add(productDTOFactory.toDTO(vo)));
        }
        return result;
    }

}
