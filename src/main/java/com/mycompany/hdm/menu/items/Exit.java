package com.mycompany.hdm.menu.items;

import com.mycompany.hdm.menu.main.MenuItems;

import static com.mycompany.hdm.main.Main.logger;

/**
 * Created by andrew on 04.05.2016.
 */
public class Exit implements MenuItems {

    @Override
    public void execute() {
        logger.info("Was selected menu item : EXIT");
        System.exit(0);
    }

}
