package com.mycompany.hdm.menu.submenu.filter;

import com.mycompany.hdm.criteria.Criteria;
import com.mycompany.hdm.criteria.CriteriaOn;
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
 * Created by andrew on 01.05.2016.
 */
public class FilterByOn implements MenuItems {
    private Scanner scn = new Scanner(System.in);
    List<HomeDevices> devices = new ArrayList<>();

    @Override
    public void execute() {
        logger.info("Was selected menu item : FILTER BY ON");
        devices.clear();
        try {
            devices = readFromFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Criteria on = new CriteriaOn();
        try {
            printListDevices(on.meetCriteria(devices), "Devices on");
        } catch (DevNotFoundException e) {
            e.printStackTrace();
        }
    }
}



