package com.mycompany.hdm.criteria;

import com.mycompany.hdm.devices.HomeDevices;
import com.mycompany.hdm.exception.DevNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrew on 04.05.2016.
 */
public class CriteriaUID implements Criteria {
    public List<HomeDevices> meetCriteria(List<HomeDevices> devices) {
        return null;
    }

    public List<HomeDevices> meetCriteria(List<HomeDevices> devices, String uid) throws DevNotFoundException {
        List<HomeDevices> uidDevice = new ArrayList<>();
        for (HomeDevices device : devices) {

           if (device.getUid().equalsIgnoreCase(uid)) {
                uidDevice.add(device);
            }
        }

        if (uidDevice.isEmpty()) {
            throw new DevNotFoundException();
        }
        return uidDevice;
    }

    @Override
    public List<HomeDevices> meetCriteria(List<HomeDevices> devices, Integer s1, Integer s2) {
        return null;
    }


    public List<HomeDevices> meetCriteria(List<HomeDevices> devices, String str, Integer s1, Integer s2) {
        return null;
    }
}

