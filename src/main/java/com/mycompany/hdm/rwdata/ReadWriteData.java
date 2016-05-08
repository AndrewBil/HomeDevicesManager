package com.mycompany.hdm.rwdata;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.hdm.devices.HomeDevices;
import com.mycompany.hdm.storage.Storage;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrew on 01.05.2016.
 */
public class ReadWriteData {

    private static final String filePath = ("devices.json");

    public static List<HomeDevices> readFromFile() throws FileNotFoundException {
        List<HomeDevices> devices = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        Storage storage;
        try {
            storage = mapper.readValue(FileUtils.readFileToByteArray(new File(filePath)), Storage.class);
            devices.addAll(storage.devices);

        } catch (IOException e) {
            e.printStackTrace();
        }
        //   System.out.println("Reading OK");*/


        return devices;
    }
    public static void writeToFile(List<HomeDevices> devices) {

        ObjectMapper mapper = new ObjectMapper();
        Storage storage = Storage.getStorage();
        storage.setHomeDevices(devices);
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new FileWriter(new File(filePath)), storage);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}


