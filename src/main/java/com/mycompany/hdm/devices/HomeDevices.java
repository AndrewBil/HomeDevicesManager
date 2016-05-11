package com.mycompany.hdm.devices;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.google.common.collect.ComparisonChain;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.mycompany.hdm.rwdata.ReadWriteData.readFromFile;
import static com.mycompany.hdm.rwdata.ReadWriteData.writeToFile;

/**
 * Created by andrew on 29.04.2016.
 */

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
@JsonSubTypes({@JsonSubTypes.Type(value = TVset.class, name = "TVset"), @JsonSubTypes.Type(value = WashMashine.class, name = "WashMashine")})
public abstract class HomeDevices extends Devices implements Switchable {

    private static Integer mUID = 0;

    public String getUid() {
        return uid;
    }

    @JsonProperty("uid")
    private String uid;
    @JsonProperty("name")
    private String name;
    private String model;
    private Status status = Status.OFF;
    private String serialNumber;

    private String type;
    private String manufacturer;
    private Integer powerConsumption;


    public static String getmUID() throws IOException {


        FileInputStream fis = new FileInputStream("tempID.dat");
        ObjectInputStream oin = new ObjectInputStream(fis);
        try {
            mUID = (Integer) oin.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            fis.close();
            oin.close();
        }

        try {
            FileOutputStream fos = new FileOutputStream("tempID.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            System.out.println("mhjh=" + mUID);
            mUID++;
            oos.writeObject(mUID);
            oos.flush();
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        return "homeDev" + mUID++;


    }

    public HomeDevices() {
    }

    ;


    public String getName() {
        return name;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public String getModel() {
        return model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getType() {
        return type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Integer getPowerConsumption() {
        return powerConsumption;
    }


    public static enum Status {

        ON,
        OFF;
    }

    public static List<HomeDevices> sortDevicesByPowerCons(List<HomeDevices> devices) {
        Collections.sort(devices, new Comparator<HomeDevices>() {
            public int compare(HomeDevices device1, HomeDevices device2) {
                return ComparisonChain.start()
                        .compare(device1.getPowerConsumption(), device2.getPowerConsumption())
                        .compare(device1.getName(), device2.getName())
                        .result();
            }
        });
        return devices;
    }

    public static void printListDevices(List<HomeDevices> devices, String mesage) {
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println(mesage);
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.printf("%-15s %-25s %-20s %-10s %-10s%n", "UID", "Model", "Type", "Status", "Power Consumption");
        System.out.println("--------------------------------------------------------------------------------------------");
        for (HomeDevices device : devices) {
            System.out.printf("%-15s %-25s %-20s %-10s %-10s%n", device.getUid(), device.getModel(), device.getType(), device.getStatus(), device.getPowerConsumption());
        }
        System.out.println("--------------------------------------------------------------------------------------------");
    }

    public static Integer calcPowerConsumption(List<HomeDevices> devices) {
        Integer power = 0;
        for (HomeDevices device : devices) {
            if (device.getStatus().equals(Status.ON)) {
                power += device.getPowerConsumption();
            }
        }
        return power;
    }

    public void switchON() {
        if (this.getStatus() == Status.OFF) {
            this.setStatus(Status.ON);
        } else {
            System.out.println("Device alredy ON");
        }
    }


    public void switchOFF() {
        if (this.getStatus() == Status.ON) {
            this.setStatus(Status.OFF);
        } else {
            System.out.println("Device alredy OFF");
        }
    }

    public void remove() {
        List<HomeDevices> devices = new ArrayList<>();
        devices.clear();
        try {
            devices = readFromFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (HomeDevices dev : devices) {
            if (this.getUid().equalsIgnoreCase(dev.getUid())) {
                devices.remove(dev);
            }
        }
        writeToFile(devices);
    }
}