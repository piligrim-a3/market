package ru.bgpu.lk.market.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bgpu.lk.market.exceptopns.ResourceNotFoundException;
import ru.bgpu.lk.market.models.Group;
import ru.bgpu.lk.market.repositories.GroupRepository;

@Service
public class GroupService {

    public static final String ADMIN_GROUP = "ADMIN";
    public static final String USER_GROUP = "USER";

    @Autowired private GroupRepository groupRepository;

    public Group save(Group group) {
        return groupRepository.save(group);
    }

    public Group getByName(String name) {
        return groupRepository.findOneByName(name).orElseThrow(
                () -> new ResourceNotFoundException(
                        "Group with name: "+name+" not found"
                )
        );
    }

    public void initDefaultGroups() {
        save(new Group(ADMIN_GROUP, "Администратор системы"));
        save(new Group(USER_GROUP, "Пользователь системы"));
    }

    public boolean existsGroups() {
        return groupRepository.count() > 0;
    }
}
