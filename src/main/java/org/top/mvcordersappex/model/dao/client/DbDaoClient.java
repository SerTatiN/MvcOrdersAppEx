package org.top.mvcordersappex.model.dao.client;

import org.top.mvcordersappex.model.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbDaoClient implements IDaoClient{

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> listAll() {
        return (List<Client>) clientRepository.findAll();
    }


    @Override
    public Optional<Client> getById(Integer id) {
        return clientRepository.findById(id);
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client update(Client client) {
        if (clientRepository.findById(client.getId()).isPresent()) {
            return clientRepository.save(client);
        }
       return null;
    }

//    @Override
//    public Client delete(Integer id) {
//        if (clientRepository.findById(id).isPresent()) {
//            Client client = clientRepository.findById(id).get();
//            clientRepository.deleteById(id);
//            return client;
//        }
//        return null;
//    }
    @Override
    public void delete(Integer id) {
        if (clientRepository.findById(id).isPresent()) {
            Client client = clientRepository.findById(id).get();
            clientRepository.deleteById(id);
            System.out.println("delete " + client.getClientName());
        }

    }

}
