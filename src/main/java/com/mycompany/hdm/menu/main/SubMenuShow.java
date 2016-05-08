package com.mycompany.hdm.menu.main;
import com.mycompany.hdm.menu.items.Back;
import com.mycompany.hdm.menu.items.Exit;
import com.mycompany.hdm.menu.submenu.show.*;

import java.util.EnumMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by andrew on 04.05.2016.
 */
public class SubMenuShow {
    public SubMenuShow() {

        menuItems.put(SUBITEMS.ALL, new All());
        menuItems.put(SUBITEMS.FILTER, new Filter());
        menuItems.put(SUBITEMS.BACK, new Back());
        menuItems.put(SUBITEMS.EXIT, new Exit());
    }

    private Map<SUBITEMS, MenuItems> menuItems = new EnumMap<>(SUBITEMS.class);
    private Scanner scn = new Scanner(System.in);

    public void startMenu() {
        String userCommand = null;
        do {
            showOptions();
            userCommand = scn.nextLine();
            try {
                menuItems.get(SUBITEMS.valueOf(userCommand.toUpperCase())).execute();


            } catch (NullPointerException | IllegalArgumentException e) {
                System.err.println("Wrong command! Type again!");
            }
        }

        while (!userCommand.equalsIgnoreCase(SUBITEMS.EXIT.toString())&&!userCommand.equalsIgnoreCase(SUBITEMS.BACK.toString()));
    }


    private void showOptions() {
        System.out.println("Type command...");
        System.out.println(menuItems.keySet());
    }


}
