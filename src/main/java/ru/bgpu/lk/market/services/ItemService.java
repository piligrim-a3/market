package ru.bgpu.lk.market.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bgpu.lk.market.models.Item;
import ru.bgpu.lk.market.repositories.ItemRepository;

import java.util.List;

@Service
public class ItemService {

    @Autowired private ItemRepository itemRepository;

    public Item save(Item item) {
        return itemRepository.save(item);
    }

    public Iterable<Item> list() {
        return itemRepository.findAll();
    }
}
