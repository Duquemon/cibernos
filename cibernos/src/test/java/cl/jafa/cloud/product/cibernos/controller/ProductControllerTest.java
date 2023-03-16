package cl.jafa.cloud.product.cibernos.controller;

import cl.jafa.cloud.product.cibernos.model.ProductDetail;
import cl.jafa.cloud.product.cibernos.service.ProductService;
import cl.jafa.cloud.product.cibernos.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ProductService service;

    ProductServiceImpl productServiceImpl;

    @BeforeEach
    void setUp() {
        productServiceImpl = new ProductServiceImpl();
    }

    @Test
    void getUserById() throws Exception {
        ProductDetail detail = ProductDetail.builder()
                .id("1")
                .name("prueba")
                .build();
        List<ProductDetail> details = new ArrayList<>();
        details.add(detail);
        given(service.getProductDetail("1")).willReturn(details);

        mockMvc.perform(get("/product/{productId}/similar", detail.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()", is(1)));
    }

}