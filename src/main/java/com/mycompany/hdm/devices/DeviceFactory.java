package com.mycompany.hdm.devices;

/**
 * Created by andrew on 04.05.2016.
 */
public class DeviceFactory {
    public HomeDevices getDevice(String deviceType){
        if(deviceType == null){
            return null;
        }
        if(deviceType.equalsIgnoreCase("TVset")){
            return new TVset();

        } else if(deviceType.equalsIgnoreCase("Fridge")){
            return new Fridge();

        } else if(deviceType.equalsIgnoreCase("WashMashine")){
            return new WashMashine();
        }

        return null;
    }
}

