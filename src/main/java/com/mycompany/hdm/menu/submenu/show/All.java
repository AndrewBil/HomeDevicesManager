package com.mycompany.hdm.menu.submenu.show;

import com.mycompany.hdm.devices.HomeDevices;
import com.mycompany.hdm.menu.main.MenuItems;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static com.mycompany.hdm.devices.HomeDevices.printListDevices;
import static com.mycompany.hdm.main.Main.logger;
import static com.mycompany.hdm.rwdata.ReadWriteData.readFromFile;

/**
 * Created by andrew on 04.05.2016.
 */
public class All implements MenuItems {
    @Override
    public void execute() {
        logger.info("Was selected menu item : ALL");
        List<HomeDevices> devices = new ArrayList<>();
        try {
            devices.clear();
            devices = readFromFile();
            printListDevices(devices, "All Devices");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
