package io.danilobzerra.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.danilobzerra.crud.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
