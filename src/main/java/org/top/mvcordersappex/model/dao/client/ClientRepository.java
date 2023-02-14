package org.top.mvcordersappex.model.dao.client;

import org.top.mvcordersappex.model.entity.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client,Integer> {

    Optional<Client> findById(Integer id);
}
