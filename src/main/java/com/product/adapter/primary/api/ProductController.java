package com.product.adapter.primary.api;

import com.product.adapter.application.ProductUseCase;
import com.product.adapter.primary.api.model.ResponseEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductUseCase productUseCase;
    private final ResponseEntityFactory responseEntityFactory;

    public ProductController(ProductUseCase productUseCase,
                             ResponseEntityFactory responseEntityFactory) {
        this.productUseCase = productUseCase;
        this.responseEntityFactory = responseEntityFactory;
    }

    /**
     * Obtiene una lista de productos similares basados en el ID del producto proporcionado.
     *
     * @param id Identificador del producto
     * @return Lista de productos similares o un mensaje de error
     */

    @Operation(summary = "Obtener productos similares",
               description = "Obtiene una lista de productos similares basados en el ID del producto proporcionado.")
    @ApiResponse(description = "Producto obtenido", responseCode = "200")
    @ApiResponse(description = "Error interno", responseCode = "500")
    @GetMapping(value="/{id}/similar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getSimilarProducts(@Parameter(description = "Identificador del producto")
                                             @PathVariable Long id) {
        try {
            return responseEntityFactory.toResponseEntity(productUseCase.getSimilarProducts(id), null);
        } catch (Exception e) {
            return responseEntityFactory.toResponseEntity(null, e.getMessage());
        }
    }
}
