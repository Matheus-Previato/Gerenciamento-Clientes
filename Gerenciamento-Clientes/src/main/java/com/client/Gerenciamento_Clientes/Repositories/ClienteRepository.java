package com.client.Gerenciamento_Clientes.Repositories;

import com.client.Gerenciamento_Clientes.Models.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
}