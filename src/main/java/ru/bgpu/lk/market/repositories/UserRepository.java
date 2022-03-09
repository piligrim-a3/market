package ru.bgpu.lk.market.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.bgpu.lk.market.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
