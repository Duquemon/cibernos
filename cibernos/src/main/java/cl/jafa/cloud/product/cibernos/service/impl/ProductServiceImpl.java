package cl.jafa.cloud.product.cibernos.service.impl;

import cl.jafa.cloud.product.cibernos.client.ProductClient;
import cl.jafa.cloud.product.cibernos.model.ProductDetail;
import cl.jafa.cloud.product.cibernos.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductClient client;

    @Override
    public List<ProductDetail> getProductDetail(String id) {
        List<String> ids = client.getListProductSimilars(id);
        List<ProductDetail> productDetails = new ArrayList<>();
        ids.forEach(i -> {
            ProductDetail productDetail = client.getProductDetail(i);
            productDetails.add(productDetail);
        });
        return productDetails;
    }
}
