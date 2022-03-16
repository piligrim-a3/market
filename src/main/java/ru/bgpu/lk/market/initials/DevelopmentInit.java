package ru.bgpu.lk.market.initials;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ru.bgpu.lk.market.services.GroupService;
import ru.bgpu.lk.market.services.UserService;

@Component
@Profile("dev")
public class DevelopmentInit implements CommandLineRunner {

    @Autowired private GroupService groupService;
    @Autowired private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(DevelopmentInit.class);

    @Override
    public void run(String... args) throws Exception {
        logger.info("Start create development scope");
        groupService.initDefaultGroups();
        userService.initDefaultUsers();
    }
}
