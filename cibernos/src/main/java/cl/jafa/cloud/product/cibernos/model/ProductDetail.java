package cl.jafa.cloud.product.cibernos.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDetail {
    private String id;
    private String name;
    private BigDecimal price;
    private Boolean availability;
}
