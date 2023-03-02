package io.danilobzerra.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.danilobzerra.crud.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
