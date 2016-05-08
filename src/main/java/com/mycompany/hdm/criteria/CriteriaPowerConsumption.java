package com.mycompany.hdm.criteria;
/**
 * Created by andrew on 29.04.2016.
 */

import com.mycompany.hdm.devices.HomeDevices;
import com.mycompany.hdm.exception.DevNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class CriteriaPowerConsumption implements Criteria {


    @Override
    public List<HomeDevices> meetCriteria(List<HomeDevices> devices) {
        return null;
    }

    @Override
    public List<HomeDevices> meetCriteria(List<HomeDevices> devices, String str) {
        return null;
    }

    @Override
    public List<HomeDevices> meetCriteria(List<HomeDevices> devices, Integer s1, Integer s2) throws DevNotFoundException {
        List<HomeDevices> powerConsDevices = new ArrayList<HomeDevices>();

        for (HomeDevices device : devices) {
           if ((device.getPowerConsumption() >= s1) && (device.getPowerConsumption() <= s2)) {
                powerConsDevices.add(device);
           }
        }
        if (powerConsDevices.isEmpty()) {
            throw new DevNotFoundException();
        }
        return powerConsDevices;
    }

    public List<HomeDevices> meetCriteria(List<HomeDevices> devices, String str, Integer s1, Integer s2) {
        return null;

    }
}