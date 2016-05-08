package com.mycompany.hdm.menu.submenu.actions;

import com.mycompany.hdm.devices.HomeDevices;
import com.mycompany.hdm.menu.main.MenuItems;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

//import static com.mycompany.hdm.devices.HomeDevices.printDevices;
import static com.mycompany.hdm.main.Main.logger;
import static com.mycompany.hdm.rwdata.ReadWriteData.readFromFile;

/**
 * Created by andrew on 01.05.2016.
 */
public class Calc implements MenuItems{
    @Override
    public void execute() {
        logger.info("Was selected menu item : CALC");
        Integer power=0;
        List<HomeDevices> devices = new ArrayList<>();
        try {
            devices=readFromFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        power=HomeDevices.calcPowerConsumption(devices);
        System.out.println("Power Consumption : "+power+"W");
    }
}
