package com.product.adapter.application.impl;

import com.product.adapter.application.ProductUseCase;
import com.product.adapter.application.model.ProductDTO;
import com.product.adapter.application.model.ProductDTOFactory;
import com.product.domain.port.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductUseCaseImpl implements ProductUseCase {

    private final ProductRepository productRepository;
    private final ProductDTOFactory productDTOFactory;

    public ProductUseCaseImpl(ProductRepository productRepository,
                              ProductDTOFactory productDTOFactory) {
        this.productRepository = productRepository;
        this.productDTOFactory = productDTOFactory;
    }

    public List<ProductDTO> getSimilarProducts(Long id) {
        List<String> similarProductIds = productRepository.getSimilarProductIds(id);
        return similarProductIds.stream().
               map(productId -> productDTOFactory.toDTO(productRepository.getProductById(Long.valueOf(productId)))).
               collect(Collectors.toList());
    }

}
