package org.top.mvcordersappex.model.dao.client;


import org.top.mvcordersappex.model.entity.Client;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.top.mvcordersappex.model.entity.Order;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DbDaoClientTest {

    @Autowired
    private DbDaoClient dbDaoClient;

    @Test
    void listAll() {
        List<Client> clients = dbDaoClient.listAll();
        for (Client client : clients)
            System.out.println(client.getClientName());
    }

    @Test
    void getById() {
        Integer id = 1;

        List<Client> clients = dbDaoClient.listAll();
        System.out.println("id=: " +id + " : "+ clients.get(id-1).getClientName());

        Optional<Client> clientId = dbDaoClient.getById(id);
        if (clientId.isPresent()) {
            System.out.println("id: =" +id + " : "+ clientId.get().getClientName()+" / "+ clients.get(id-1).getClientName());

           assertEquals(clientId.get().getId(),id, "not");
        }

        id = clients.size() +1;
        clientId = dbDaoClient.getById(id);

        assertEquals(clientId, Optional.empty(), "not null");
        assertNull(clientId);

   }

    @Test
    void save() {
        String name = "Синицын";

        Client clientNew = new Client(name);
        Client clientSave = dbDaoClient.save(clientNew);

        assertEquals(clientSave.getClientName(), name);
    }

    @Test
    void update() {
        int id = 6;
        String name = "Абдулов";

        Client clientFoUp = new Client(id,name);
        Client clientUp = dbDaoClient.update(clientFoUp);
        System.out.println(clientUp.getClientName());
        assertEquals(clientUp.getClientName(), name);
    }

    @Test
    void delete() {
        int id = 6;
        Optional<Client> client = dbDaoClient.getById(id);
        System.out.println(client);
        dbDaoClient.delete(id);
       // listAll();

        Optional<Client> clientDel = dbDaoClient.getById(id);
        assertNull(clientDel.get());

    }
}