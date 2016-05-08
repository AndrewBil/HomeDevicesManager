package com.mycompany.hdm.menu.items;

import com.mycompany.hdm.main.Main;
import com.mycompany.hdm.menu.main.MenuItems;

/**
 * Created by andrew on 04.05.2016.
 */
public class Back implements MenuItems {
    @Override
    public void execute() {
        Main.logger.info("Was selected menu item : BACK ");
    }
}
