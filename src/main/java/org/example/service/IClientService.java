package org.example.service;
import org.example.model.Client;
import java.util.ArrayList;

public interface IClientService {

    void add(Client client);
    void deleteById(Long id);
    ArrayList findAll();
    Client findByDni(String dni);
    void update(Client client);

}
