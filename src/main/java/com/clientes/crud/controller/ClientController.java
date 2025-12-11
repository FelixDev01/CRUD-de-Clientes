package com.clientes.crud.controller;

import com.clientes.crud.dto.ClientRequestDTO;
import com.clientes.crud.dto.ClientResponseDTO;
import com.clientes.crud.service.ClientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("clientes")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ClientResponseDTO> clienteCriado(@RequestBody ClientRequestDTO dto){
        ClientResponseDTO client = service.novoCliente(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(client.getId()).toUri();
        return ResponseEntity.created(uri).body(client);
    }

    @GetMapping
    public ResponseEntity<Page<ClientResponseDTO>> todosOsClientes(Pageable pageable){
        Page<ClientResponseDTO> clientes = service.findAll(pageable);
        return ResponseEntity.ok(clientes);
    }
}

