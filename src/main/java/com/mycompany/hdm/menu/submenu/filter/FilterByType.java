package com.mycompany.hdm.menu.submenu.filter;

import com.mycompany.hdm.criteria.Criteria;
import com.mycompany.hdm.criteria.CriteriaType;
import com.mycompany.hdm.devices.HomeDevices;
import com.mycompany.hdm.exception.DevNotFoundException;
import com.mycompany.hdm.menu.main.MenuItems;
import org.reflections.Reflections;

import java.io.FileNotFoundException;
import java.util.*;

import static com.mycompany.hdm.devices.HomeDevices.printListDevices;
import static com.mycompany.hdm.main.Main.logger;
import static com.mycompany.hdm.rwdata.ReadWriteData.readFromFile;

/**
 * Created by andrew on 04.05.2016.
 */
public class FilterByType implements MenuItems {
    private Scanner scn = new Scanner(System.in);
    List<HomeDevices> devices = new ArrayList<>();

    @Override
    public void execute() {
        logger.info("Was selected menu item : FILTER BY POWER");
        devices.clear();
        try {
            devices = readFromFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String input = null;
        do {
            showOptions();
            input = scn.nextLine();
            Criteria type = new CriteriaType();
            if ((!input.equalsIgnoreCase(SUBITEMS.EXIT.toString()) && !input.equalsIgnoreCase(SUBITEMS.BACK.toString()))) {

                try {
                    printListDevices(type.meetCriteria(devices, input), input);
                } catch (DevNotFoundException e) {
                    e.printStackTrace();
                }
            }

        }
        while (!input.equalsIgnoreCase(SUBITEMS.BACK.toString()) && !input.equalsIgnoreCase(SUBITEMS.EXIT.toString()));
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
