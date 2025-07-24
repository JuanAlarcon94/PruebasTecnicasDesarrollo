package com.product.adapter.primary.api;

import com.product.adapter.application.ProductsUseCase;
import com.product.adapter.application.model.ProductDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductsController {

    private final ProductsUseCase productsUseCase;

    public ProductsController(ProductsUseCase productsUseCase) {
        this.productsUseCase = productsUseCase;
    }

    @Operation(summary = "Obtener productos similares",
               description = "Obtiene una lista de productos similares basados en el ID del producto proporcionado.")
    @ApiResponse(description = "Producto obtenido", responseCode = "200")
    @ApiResponse(description = "Error interno", responseCode = "500")
    @GetMapping(value="/{id}/similar", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductDTO> getSimilarProducts(@Parameter(description = "Identificador del producto")
                                               @PathVariable Long id) {
        return productsUseCase.getSimilarProducts(id);
    }
}
