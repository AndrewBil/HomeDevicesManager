package com.mycompany.hdm.menu.main;

import com.mycompany.hdm.menu.items.Back;
import com.mycompany.hdm.menu.items.Exit;
import com.mycompany.hdm.menu.submenu.filter.*;

import java.util.EnumMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by andrew on 04.05.2016.
 */
public class SubMenuFilter {
    public SubMenuFilter() {

        menuItems.put(SUBITEMS.UID, new FilterByUID());
        menuItems.put(SUBITEMS.TYPE, new FilterByType());
        menuItems.put(SUBITEMS.POWER, new FilterByPower());
        menuItems.put(SUBITEMS.ON, new FilterByOn());
        menuItems.put(SUBITEMS.BACK,  new Back());
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

        while (!userCommand.equalsIgnoreCase(SUBITEMS.BACK.toString())&&!userCommand.equalsIgnoreCase(SUBITEMS.EXIT.toString()));
    }


    private void showOptions() {
        System.out.println("Type command...");
        System.out.println(menuItems.keySet());
    }


}
