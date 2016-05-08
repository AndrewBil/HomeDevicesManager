package com.mycompany.hdm.criteria; /**
 * Created by andrew on 29.04.2016.
 */

import com.mycompany.hdm.devices.HomeDevices;
import com.mycompany.hdm.exception.DevNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class CriteriaType implements Criteria {


    public List<HomeDevices> meetCriteria(List<HomeDevices> devices) {
        return null;
    }

    public List<HomeDevices> meetCriteria(List<HomeDevices> devices, String type) throws DevNotFoundException {
        List<HomeDevices> tDevices = new ArrayList<HomeDevices>();
        for (HomeDevices device : devices) {

            if (device.getType().equalsIgnoreCase(type)) {
                tDevices.add(device);
            }
        }
        if (tDevices.isEmpty()) {

            throw new DevNotFoundException();

        }


        return tDevices;
    }


    public List<HomeDevices> meetCriteria(List<HomeDevices> persons, Integer s1, Integer s2) {
        return null;
    }

    public List<HomeDevices> meetCriteria(List<HomeDevices> devices, String str, Integer s1, Integer s2) {
        return null;
    }
}