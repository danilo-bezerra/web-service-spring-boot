package io.danilobzerra.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.danilobzerra.crud.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
