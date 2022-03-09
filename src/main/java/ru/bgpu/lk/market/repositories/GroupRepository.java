package ru.bgpu.lk.market.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.bgpu.lk.market.models.Group;

public interface GroupRepository extends CrudRepository<Group, Long> {

}
