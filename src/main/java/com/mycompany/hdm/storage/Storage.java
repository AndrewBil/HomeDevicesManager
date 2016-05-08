package com.mycompany.hdm.storage;

import com.mycompany.hdm.devices.HomeDevices;

import java.util.List;

/**
 * Created by andrew on 06.05.2016.
 */
public class Storage {
    public List<HomeDevices> devices;

    private static Storage storage;

    private Storage() {

    }

    public static Storage getStorage() {
        if (storage == null) {
            storage = new Storage();
        }

        return storage;
    }

    public void setHomeDevices(List<HomeDevices> devices) {
        this.devices = devices;
    }
}