package ru.bgpu.lk.market.initials;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ru.bgpu.lk.market.models.Item;
import ru.bgpu.lk.market.models.ItemType;
import ru.bgpu.lk.market.services.GroupService;
import ru.bgpu.lk.market.services.ItemService;
import ru.bgpu.lk.market.services.ItemTypeService;
import ru.bgpu.lk.market.services.UserService;

import java.util.Arrays;

@Component
@Profile("dev")
public class DevelopmentInit implements CommandLineRunner {

    @Autowired private GroupService groupService;
    @Autowired private UserService userService;
    @Autowired private ItemService itemService;
    @Autowired private ItemTypeService itemTypeService;

    private static final Logger logger = LoggerFactory.getLogger(DevelopmentInit.class);

    @Override
    public void run(String... args) throws Exception {
        logger.info("Start create development scope");
        groupService.initDefaultGroups();
        userService.initDefaultUsers();

        // init default items
        ItemType clothes = itemTypeService.save(new ItemType("Одежда"));
        Arrays.stream(new String[] {
                "Куртка", "Рубашка","Джинсы","Трусы","Носки"
        }).forEach(name -> {
            Item item = new Item();
            item.setName(name);
            item.setItemType(clothes);
            itemService.save(item);
        });

    }
}
