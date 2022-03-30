package ru.bgpu.lk.market.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.bgpu.lk.market.models.ItemType;

public interface ItemTypeRepository extends CrudRepository<ItemType, Long> {
}
