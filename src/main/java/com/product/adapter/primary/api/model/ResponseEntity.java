package com.product.adapter.primary.api.model;

import com.product.adapter.application.model.ProductDTO;

import java.util.List;

public class ResponseEntity {

    private List<ProductDTO> similarProducts;
    private String errorMensage;

    public ResponseEntity(List<ProductDTO> similarProducts, String errorMensage) {
        this.similarProducts = similarProducts;
        this.errorMensage = errorMensage;
    }

    public List<ProductDTO> getSimilarProducts() {
        return similarProducts;
    }

    public void setSimilarProducts(List<ProductDTO> similarProducts) {
        this.similarProducts = similarProducts;
    }

    public String getErrorMensage() {
        return errorMensage;
    }

    public void setErrorMensage(String errorMensage) {
        this.errorMensage = errorMensage;
    }
}
