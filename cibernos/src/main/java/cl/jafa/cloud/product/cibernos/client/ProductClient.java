package cl.jafa.cloud.product.cibernos.client;

import cl.jafa.cloud.product.cibernos.model.ProductDetail;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "product-mock", url = "localhost:3001")
public interface ProductClient {

    @GetMapping("product/{id}")
    ProductDetail getProductDetail(@PathVariable String id);

    @GetMapping("product/{id}/similarids")
    List<String> getListProductSimilars(@PathVariable String id);
}
