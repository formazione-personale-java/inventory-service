package it.cws.iventoryservice.dao;

import it.cws.iventoryservice.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Produit,String> {
}
