package io.danilobzerra.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.danilobzerra.crud.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
