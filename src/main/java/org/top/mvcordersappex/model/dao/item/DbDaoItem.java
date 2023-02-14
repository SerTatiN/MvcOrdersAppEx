package org.top.mvcordersappex.model.dao.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.top.mvcordersappex.model.entity.Item;
import org.top.mvcordersappex.model.entity.Order;

import java.util.List;
import java.util.Optional;

@Service
public class DbDaoItem implements IDaoItem{
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> listAll() {
        return (List<Item>) itemRepository.findAll();
    }

    @Override
    public Optional<Item> getById(Integer id) {
        return itemRepository.findById(id);
    }

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item update(Item item) {
        if (itemRepository.findById(item.getId()).isPresent()) {
            return itemRepository.save(item);
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        if (itemRepository.findById(id).isPresent()) {
            Item item = itemRepository.findById(id).get();
            itemRepository.deleteById(id);
        }
    }
}
