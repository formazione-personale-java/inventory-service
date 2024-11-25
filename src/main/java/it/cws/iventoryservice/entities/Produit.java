package it.cws.iventoryservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Produit {
    @Id
    private String id;
    private String name;
    private  double price;
    private int quantity;
}
