package com.mycompany.hdm.menu.submenu.filter;

import com.mycompany.hdm.criteria.Criteria;
import com.mycompany.hdm.criteria.CriteriaPowerConsumption;
import com.mycompany.hdm.devices.HomeDevices;
import com.mycompany.hdm.exception.DevNotFoundException;
import com.mycompany.hdm.menu.main.MenuItems;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//import static com.mycompany.hdm.devices.HomeDevices.printDevices;
//import static com.mycompany.hdm.devices.HomeDevices.sortDevicesByPowerCons;
import static com.mycompany.hdm.devices.HomeDevices.printListDevices;
import static com.mycompany.hdm.devices.HomeDevices.sortDevicesByPowerCons;
import static com.mycompany.hdm.main.Main.logger;
import static com.mycompany.hdm.rwdata.ReadWriteData.readFromFile;

/**
 * Created by andrew on 01.05.2016.
 */
public class FilterByPower implements MenuItems {
    private Scanner scn = new Scanner(System.in);
    List<HomeDevices> devices = new ArrayList<>();
    Integer minPower, maxPower = 0;

    @Override
    public void execute() {
        logger.info("Was selected menu item : FILTER BY POWER");
        devices.clear();
        try {
            devices=readFromFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String input = null;
        do {
            showOptions();

            try {
            input = scn.nextLine();

            if (!input.equalsIgnoreCase(SUBITEMS.BACK.toString())&&!input.equalsIgnoreCase(SUBITEMS.EXIT.toString())) {

                String[] strArray = input.split(",");
                minPower = Integer.parseInt(strArray[0]);
                maxPower = Integer.parseInt(strArray[1]);
                Criteria powerConsumption = new CriteriaPowerConsumption();

                try {
                    printListDevices(sortDevicesByPowerCons(powerConsumption.meetCriteria(devices, minPower, maxPower)),"Devices with power from "+minPower+" to "+maxPower);
                } catch (DevNotFoundException e) {
                    e.printStackTrace();
                }
            }}

       catch (NumberFormatException e){
         //  e.printStackTrace();
           System.out.println("Your data is incorect, (min,max) ");

                }

        }

        while (!input.equalsIgnoreCase(SUBITEMS.BACK.toString())&&!input.equalsIgnoreCase(SUBITEMS.EXIT.toString()));
    }


    private void showOptions() {
        System.out.println("Type min and max power of Devices or BACK, EXIT");
                }
}
