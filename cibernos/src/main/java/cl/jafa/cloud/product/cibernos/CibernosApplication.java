package cl.jafa.cloud.product.cibernos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CibernosApplication {

    public static void main(String[] args) {
        SpringApplication.run(CibernosApplication.class, args);
    }

}
