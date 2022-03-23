package ru.bgpu.lk.market.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bgpu.lk.market.models.Group;
import ru.bgpu.lk.market.models.User;
import ru.bgpu.lk.market.repositories.UserRepository;

@Service
@Transactional
public class UserService {

    @Autowired private UserRepository userRepository;
    @Autowired private GroupService groupService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User save(User user) {
        return userRepository.save(user);
    }

    public void initDefaultUsers() {
        User adminUser = new User();
        adminUser.setLogin("admin");
        adminUser.setPassword(encoder.encode("admin"));
        Group adminGroup = groupService.getByName(GroupService.ADMIN_GROUP);
        adminUser.getGroups().add(adminGroup);
        save(adminUser);
    }

    @Transactional(readOnly = true)
    public UserDetails getByLogin(String login) {
        return userRepository.findOneByLogin(login);
    }
}
