package ru.bgpu.lk.market.initials;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ru.bgpu.lk.market.services.GroupService;

@Component
@Profile("prod")
public class ProductionInit implements CommandLineRunner {

    @Autowired private GroupService groupService;

    @Override
    public void run(String... args) throws Exception {
        if(!groupService.existsGroups()) {
            groupService.initDefaultGroups();
        }
    }
}
