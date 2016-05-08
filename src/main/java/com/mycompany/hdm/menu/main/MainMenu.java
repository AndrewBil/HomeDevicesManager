package com.mycompany.hdm.menu.main;

import com.mycompany.hdm.menu.items.Acts;
import com.mycompany.hdm.menu.items.Exit;
import com.mycompany.hdm.menu.items.ITEMS;


import java.util.EnumMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by andrew on 04.05.2016.
 */
public class MainMenu {

    public MainMenu() {

        menuItems.put(ITEMS.ACTS, new Acts());
        menuItems.put(ITEMS.EXIT, new Exit());
    }
    private Map<ITEMS, MenuItems> menuItems = new EnumMap<ITEMS, MenuItems>(ITEMS.class);
    private Scanner scn = new Scanner(System.in);

    public void startMenu() {
        while (true) {
            showOptions();
            String userCommand = scn.nextLine();
            try {
                menuItems.get(ITEMS.valueOf(userCommand.toUpperCase())).execute();
            } catch (NullPointerException | IllegalArgumentException e) {
                System.err.println("Wrong command! Type again!");
            }
        }
    }

    private void showOptions() {
        System.out.println("Type command...");
        System.out.println(menuItems.keySet());
    }

}
