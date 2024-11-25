package it.cws.iventoryservice.web;

import it.cws.iventoryservice.dao.ProductRepository;
import it.cws.iventoryservice.entities.Produit;
import it.cws.iventoryservice.model.Post;
import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController

public class ProductController {
    private ProductRepository productRepository;
    private RestClient restClient;

    public ProductController(ProductRepository productRepository, RestClient restClient) {
        this.productRepository = productRepository;
        this.restClient = restClient;
    }

    @GetMapping("/api/products")
    public List<Produit> produits(){
        return productRepository.findAll();
    }
    @GetMapping("/posts")
    public List<Post> allPosts(){
    return this.restClient.get().uri("posts").retrieve().body(new ParameterizedTypeReference<List<Post>>() {});
    }
}

