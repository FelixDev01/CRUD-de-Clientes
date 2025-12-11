package com.clientes.crud.repository;

import com.clientes.crud.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
