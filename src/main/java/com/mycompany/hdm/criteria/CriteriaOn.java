package com.mycompany.hdm.criteria;

/**
 * Created by andrew on 29.04.2016.
 */

import com.mycompany.hdm.devices.HomeDevices;
import com.mycompany.hdm.devices.HomeDevices.Status;
import com.mycompany.hdm.exception.DevNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class CriteriaOn implements Criteria {


    public List<HomeDevices> meetCriteria(List<HomeDevices> devices) throws DevNotFoundException {
        ArrayList<HomeDevices> onDevices = new ArrayList<HomeDevices>();

        for (HomeDevices device : devices) {
           if (device.getStatus() == Status.ON) {
              onDevices.add(device);
            }
        }

        if (onDevices.isEmpty()) {
            throw new DevNotFoundException();
        }
        return onDevices;
    }

    @Override
    public List<HomeDevices> meetCriteria(List<HomeDevices> devices, Integer s1, Integer s2) {
        return null;
    }

    @Override
    public List<HomeDevices> meetCriteria(List<HomeDevices> devices, String str, Integer s1, Integer s2) {
        return null;
    }

    public List<HomeDevices> meetCriteria(List devices, String str) {
        return null;
    }


}