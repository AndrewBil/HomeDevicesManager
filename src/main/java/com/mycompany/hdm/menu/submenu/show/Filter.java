package com.mycompany.hdm.menu.submenu.show;

import com.mycompany.hdm.menu.main.MenuItems;
import com.mycompany.hdm.menu.main.SubMenuFilter;

import static com.mycompany.hdm.main.Main.logger;

/**
 * Created by andrew on 04.05.2016.
 */
public class Filter implements MenuItems {
    @Override
    public void execute() {
        logger.info("Was selected menu item : FILTER");
        SubMenuFilter subMenu = new SubMenuFilter();
        subMenu.startMenu();
    }
}
