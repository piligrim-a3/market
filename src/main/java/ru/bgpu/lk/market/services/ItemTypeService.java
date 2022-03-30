package ru.bgpu.lk.market.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bgpu.lk.market.models.ItemType;
import ru.bgpu.lk.market.repositories.ItemTypeRepository;

import java.util.Arrays;

@Service
public class ItemTypeService {

    @Autowired private ItemTypeRepository itemTypeRepository;

    public ItemType save(ItemType itemType) {
         return itemTypeRepository.save(itemType);
    }

    public void initDefaultItemType() {

    }
}
