package com.clientes.crud.service;

import com.clientes.crud.Entity.Client;
import com.clientes.crud.dto.ClientRequestDTO;
import com.clientes.crud.dto.ClientResponseDTO;
import com.clientes.crud.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public ClientResponseDTO criandoCliente (ClientRequestDTO dto){
        Client cliente = new Client();
        copyDtoToEntity(dto, cliente);
        cliente = repository.save(cliente);
        return new ClientResponseDTO(cliente);
    }

    private void copyDtoToEntity(ClientRequestDTO dto, Client cliente) {
        cliente.setName(dto.getName());
        cliente.setCpf(dto.getCpf());
        cliente.setIncome(dto.getIncome());
        cliente.setBirthDate(dto.getBirthDate());
        cliente.setChildren(dto.getChildren());
    }
}
