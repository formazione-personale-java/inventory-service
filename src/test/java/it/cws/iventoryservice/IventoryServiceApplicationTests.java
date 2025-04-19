package it.cws.iventoryservice;

import it.cws.iventoryservice.dao.ProductRepository;
import it.cws.iventoryservice.entities.Produit;
import it.cws.iventoryservice.web.ProductController;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class IventoryServiceApplicationTests {
 @Autowired
    private MockMvc mvc;
 @MockBean
 ProductRepository productRepository;
    @Test
    void contextLoads() {
    }
    @Test
    void produitsShouldReturnAllProudcts()throws Exception{
        Mockito.when(this.productRepository.findAll()).thenReturn(getAllProduits());
        mvc.perform(get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(null));
        ;
    }
void getProductByIdShouldReturnTheRequestedProduct() throws Exception {
        Mockito.when(this.productRepository.getReferenceById("2")).thenReturn(getAllProduits().get(2));
        mvc.perform(get("/product/2")).andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.author").value(""))
                .andExpect(jsonPath("$.isbn").value(""));

}

    public List<Produit> getAllProduits(){
        return List.of(null);
    }
    /**
     * cd books/; mvn -Dtest=BookControllerTest#findAllShouldReturnAllBooks test
     *  private List<Book> getBooks() {
     *         Book one = new Book(1,
     *                 "97 Things Every Java Programmer Should Know",
     *                 "Kevlin Henney, Trisha Gee",
     *                 "OReilly Media, Inc.",
     *                 "May 2020",
     *                 "9781491952696",
     *                 "Java");
     *         Book two = new Book(2,
     *                 "Spring Boot: Up and Running",
     *                 "Mark Heckler",
     *                 "OReilly Media, Inc.",
     *                 "February 2021",
     *                 "9781492076919",
     *                 "Spring");
     *         return List.of(one, two);
     *     }
     * */
}
