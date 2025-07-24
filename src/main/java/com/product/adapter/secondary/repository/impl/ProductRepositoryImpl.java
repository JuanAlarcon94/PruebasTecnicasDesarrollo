package com.product.adapter.secondary.repository.impl;

import com.product.domain.model.ProductVO;
import com.product.domain.port.ProductRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final RestTemplate restTemplate;

    @Value("${product.similarProductIdsUrl}")
    private String similarProductIdsUrl;

    @Value("${product.productDetailUrl}")
    private String productDetailUrl;

    public ProductRepositoryImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<String> getSimilarProductIds(Long id) {
        String url = String.format(similarProductIdsUrl, id);
        return Arrays.asList(Objects.requireNonNull(restTemplate.getForObject(url, String[].class)));
    }

    @Override
    public Optional<ProductVO> getProductById(Long id) {
        try {
            String url = String.format(productDetailUrl, id);
            ProductVO product = restTemplate.getForObject(url, ProductVO.class);
            return Optional.ofNullable(product);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
