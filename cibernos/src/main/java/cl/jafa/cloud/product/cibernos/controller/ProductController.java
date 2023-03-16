package cl.jafa.cloud.product.cibernos.controller;

import cl.jafa.cloud.product.cibernos.model.ProductDetail;
import cl.jafa.cloud.product.cibernos.service.ProductService;
import feign.FeignException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product/{productId}/similar")
    public ResponseEntity<?> getUserById(@PathVariable String productId) {
        if(!productId.chars().allMatch( Character::isDigit )) {
            log.debug("The value: " + productId + " isn't numeric");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Collections.singletonMap("message", "Error Numeric"));
        }
        try {
            List<ProductDetail> productDetails = productService.getProductDetail(productId);
            if(!productDetails.isEmpty()) {
                return ResponseEntity.status(HttpStatus.OK).body(productDetails);
            }
        } catch (FeignException e) {
            log.debug("Message from Client: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("message", "Error interno"));
        }

        return ResponseEntity.notFound().build();
    }

}
