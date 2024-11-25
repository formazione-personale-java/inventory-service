package it.cws.iventoryservice;

import it.cws.iventoryservice.dao.ProductRepository;
import it.cws.iventoryservice.entities.Produit;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class IventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(IventoryServiceApplication.class, args);
    }
@Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository){
        return args -> {
            productRepository.save(Produit.builder().quantity(5).price(502.2).name("Computer").id(UUID.randomUUID().toString()).build());
            productRepository.save(Produit.builder().quantity(5).price(502.2).name("printer").id(UUID.randomUUID().toString()).build());
            productRepository.save(Produit.builder().quantity(5).price(502.2).name("smartphone").id(UUID.randomUUID().toString()).build());
            productRepository.save(Produit.builder().quantity(5).price(502.2).name("USB KEY").id(UUID.randomUUID().toString()).build());
            productRepository.save(Produit.builder().quantity(5).price(502.2).name("KEYBOARD").id(UUID.randomUUID().toString()).build());




        };

}
}
