package com.mycompany.hdm.menu.items;

import com.mycompany.hdm.menu.main.MenuItems;
import com.mycompany.hdm.menu.main.SubMenuAct;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import static com.mycompany.hdm.main.Main.logger;

/**
 * Created by andrew on 04.05.2016.
 */
public class Acts implements MenuItems {
      @Override
    public void execute() {
       logger.info("Was selected menu item : ACTS ");
        SubMenuAct subMenu=new SubMenuAct();
        subMenu.startMenu();

    }

}