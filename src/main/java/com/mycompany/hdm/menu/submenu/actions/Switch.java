package com.mycompany.hdm.menu.submenu.actions;


import com.mycompany.hdm.menu.main.MenuItems;
import com.mycompany.hdm.menu.main.SubMenuSwitch;

import static com.mycompany.hdm.main.Main.logger;


/**
 * Created by andrew on 05.05.2016.
 */
public class Switch implements MenuItems {
    @Override
    public void execute() {
        logger.info("Was selected menu item : SWITCH");
        SubMenuSwitch subMenu=new SubMenuSwitch();
        subMenu.startMenu();
    }
}
