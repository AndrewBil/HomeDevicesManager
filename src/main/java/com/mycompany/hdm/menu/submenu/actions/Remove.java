package com.mycompany.hdm.menu.submenu.actions;

import com.mycompany.hdm.criteria.Criteria;
import com.mycompany.hdm.criteria.CriteriaUID;
import com.mycompany.hdm.devices.HomeDevices;
import com.mycompany.hdm.exception.DevNotFoundException;
import com.mycompany.hdm.menu.main.MenuItems;
import com.mycompany.hdm.storage.Storage;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import static com.mycompany.hdm.devices.HomeDevices.printListDevices;
import static com.mycompany.hdm.main.Main.logger;
import static com.mycompany.hdm.rwdata.ReadWriteData.readFromFile;
import static com.mycompany.hdm.rwdata.ReadWriteData.writeToFile;

/**
 * Created by andrew on 04.05.2016.
 */
public class Remove implements MenuItems {

    private Scanner scn = new Scanner(System.in);
    List<HomeDevices> devices = new ArrayList<HomeDevices>();
    Storage storage = Storage.getStorage();

    @Override
    public void execute() {
        logger.info("Was selected menu item : REMOVE");
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
                    (uid.meetCriteria(devices, "homeDev" + input).get(0)).remove();
                    System.out.println("Done!");
                    writeToFile(devices);
                } catch (DevNotFoundException e) {
                    e.printStackTrace();
                }
            }

        }
        while (!input.equalsIgnoreCase(SUBITEMS.BACK.toString()) && !input.equalsIgnoreCase(SUBITEMS.EXIT.toString()));
    }




    private void showOptions() {
        System.out.println("Type UID Devices (only number  forexample: 2) or BACK, EXIT");
        printListDevices(devices, "All Devices");
        System.out.println("");
    }
}
