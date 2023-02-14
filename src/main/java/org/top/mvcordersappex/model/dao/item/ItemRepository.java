package org.top.mvcordersappex.model.dao.item;

import org.springframework.data.repository.CrudRepository;
import org.top.mvcordersappex.model.entity.Item;

import java.util.Optional;

public interface ItemRepository extends CrudRepository<Item,Integer> {

    Optional<Item> findById(Integer integer);
}
