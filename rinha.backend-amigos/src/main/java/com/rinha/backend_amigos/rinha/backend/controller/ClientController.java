package com.rinha.backend_amigos.rinha.backend.controller;

import com.rinha.backend_amigos.rinha.backend.dto.ClientDTO;
import com.rinha.backend_amigos.rinha.backend.model.Client;
import com.rinha.backend_amigos.rinha.backend.model.Clothes;
import com.rinha.backend_amigos.rinha.backend.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> getAllClients(@RequestParam(required = false) String termo) {
        if (termo != null) {
            return clientService.seachClientsByTerm(termo);
        }
        return clientService.getAllClients();
    }

    @PostMapping("/clientes")
    public ResponseEntity<String> createClient(@RequestBody ClientDTO clientDTO) {
        try {
            Client createdClient = clientService.createClient(clientDTO);
            return ResponseEntity.ok("Cliente criado com sucesso!" + createdClient.getId());
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<Client> getClient(@PathVariable("id") String clientId) {
        try {
            Client client = clientService.getClientById(clientId)
                    .orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));
            return ResponseEntity.ok(client);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }

    }

}
