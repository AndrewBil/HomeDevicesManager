package com.mycompany.hdm.menu.submenu.actions;

import com.mycompany.hdm.devices.DeviceFactory;
import com.mycompany.hdm.devices.HomeDevices;
import com.mycompany.hdm.menu.main.MenuItems;
import org.reflections.Reflections;

import java.util.Iterator;
import java.util.Set;

import static com.mycompany.hdm.main.Main.logger;

/**
 * Created by andrew on 04.05.2016.
 */
public class Add implements MenuItems {
    @Override
    public void execute() {
        logger.info("Was selected menu item : ADD");
          DeviceFactory deviceFactory = new DeviceFactory();

        //HomeDevices device = deviceFactory.getDevice("TVset");
        showOptions();
    }

    private void showOptions() {
        System.out.println("Type type of Devices or BACK, EXIT");


        Reflections reflections = new Reflections("com.mycompany");
        Set<Class<? extends HomeDevices>> classes = reflections.getSubTypesOf(HomeDevices.class);
        Iterator iterator = classes.iterator();

        while (iterator.hasNext()) {
            String str = iterator.next().toString();
            System.out.print((str.substring(str.lastIndexOf(".") + 1).trim()) + "| ");
        }
        System.out.println();
    }
}