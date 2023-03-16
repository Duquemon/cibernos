package cl.jafa.cloud.product.cibernos.service;

import cl.jafa.cloud.product.cibernos.model.ProductDetail;

import java.util.List;

public interface ProductService {

    List<ProductDetail> getProductDetail(String id);
}
