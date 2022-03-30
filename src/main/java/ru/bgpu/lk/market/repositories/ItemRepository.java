package ru.bgpu.lk.market.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.bgpu.lk.market.models.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {
}
