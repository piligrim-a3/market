package ru.bgpu.lk.market.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bgpu.lk.market.models.User;
import ru.bgpu.lk.market.repositories.UserRepository;

@Service
public class UserService {

    @Autowired private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }
}
