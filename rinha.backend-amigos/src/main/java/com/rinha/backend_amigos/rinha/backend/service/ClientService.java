package com.rinha.backend_amigos.rinha.backend.service;

import com.rinha.backend_amigos.rinha.backend.dto.ClientDTO;
import com.rinha.backend_amigos.rinha.backend.model.Client;
import com.rinha.backend_amigos.rinha.backend.model.Clothes;
import com.rinha.backend_amigos.rinha.backend.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClientById(String clientId) {
        return clientRepository.findById(clientId);
    }

    public Client createClient(ClientDTO clientDTO) {

        Client client = new Client();
        client.setName(clientDTO.getName());
        client.setLastname(clientDTO.getLastName());

        clientDTO.getClothes().forEach(clothesName -> {
            Clothes clothes = new Clothes();
            clothes.setName(clothesName);
            client.addClothes(clothes);
        });

        return clientRepository.save(client);
    }

    public List<Client> seachClientsByTerm(String termo) {
        return clientRepository.findByNameContaining(termo);
    }

    public List<Clothes> getClothesToTry(String clientId) {
        return clientRepository.findById(clientId)
                .map(Client::getClothesToTry)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado."));
    }
}
