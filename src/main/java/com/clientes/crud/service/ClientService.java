package com.clientes.crud.service;

import com.clientes.crud.Entity.Client;
import com.clientes.crud.dto.ClientRequestDTO;
import com.clientes.crud.dto.ClientResponseDTO;
import com.clientes.crud.repository.ClientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Transactional(readOnly = true)
    public Page<ClientResponseDTO> findAll(Pageable pageable){
        Page<Client> clientes = repository.findAll(pageable);
        return clientes.map(x -> new ClientResponseDTO(x));
    }

    @Transactional
    public ClientResponseDTO findById (Long id){
        Client client = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("(CUSTOMIZAR O ERRO AINDA)"));
        return new ClientResponseDTO(client);
    }

    private void copyDtoToEntity(ClientRequestDTO dto, Client cliente) {
        cliente.setName(dto.getName());
        cliente.setCpf(dto.getCpf());
        cliente.setIncome(dto.getIncome());
        cliente.setBirthDate(dto.getBirthDate());
        cliente.setChildren(dto.getChildren());
    }
}
