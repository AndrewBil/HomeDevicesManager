package com.mycompany.hdm.menu.submenu.filter;


import com.mycompany.hdm.criteria.Criteria;
import com.mycompany.hdm.criteria.CriteriaUID;
import com.mycompany.hdm.devices.HomeDevices;
import com.mycompany.hdm.exception.DevNotFoundException;
import com.mycompany.hdm.menu.main.MenuItems;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.mycompany.hdm.devices.HomeDevices.printListDevices;
import static com.mycompany.hdm.main.Main.logger;
import static com.mycompany.hdm.rwdata.ReadWriteData.readFromFile;

/**
 * Created by andrew on 04.05.2016.
 */
public class FilterByUID implements MenuItems {
    private Scanner scn = new Scanner(System.in);
    List<HomeDevices> devices = new ArrayList<>();

    @Override
    public void execute() {
        logger.info("Was selected menu item : FILTER BY UID");
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
            Criteria uid = new CriteriaUID();
            if ((!input.equalsIgnoreCase(SUBITEMS.EXIT.toString()) && !input.equalsIgnoreCase(SUBITEMS.BACK.toString()))) {

                try {
                    printListDevices(uid.meetCriteria(devices, "homeDev" + input), "homeDev" + input);
                } catch (DevNotFoundException e) {
                    e.printStackTrace();
                }
            }

        }
        while (!input.equalsIgnoreCase(SUBITEMS.BACK.toString()) && !input.equalsIgnoreCase(SUBITEMS.EXIT.toString()));
    }


    private void showOptions() {
        System.out.println("Type UID Devices (only number  forexample: 2) or BACK, EXIT");
        for (HomeDevices dev : devices) {
            System.out.print(dev.getUid() + " | ");
        }
        System.out.println("");
    }
}

