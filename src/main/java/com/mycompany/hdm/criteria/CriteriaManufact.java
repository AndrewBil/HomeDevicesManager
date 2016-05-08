package com.mycompany.hdm.criteria; /**
 * Created by andrew on 29.04.2016.
 */

import com.mycompany.hdm.devices.HomeDevices;

import java.util.ArrayList;
import java.util.List;

public class CriteriaManufact implements Criteria {


    public List<HomeDevices> meetCriteria(List<HomeDevices> devices) {
        return null;
    }

    public List<HomeDevices> meetCriteria(List<HomeDevices> devices, String manufact) {
        List<HomeDevices> nameDevices = new ArrayList<HomeDevices>();
        for (HomeDevices device : devices) {

        //    if (device.getManufacturer().equalsIgnoreCase(manufact)) {
         //       nameDevices.add(device);
       //     }
        }


        return nameDevices;
    }


    public List<HomeDevices> meetCriteria(List<HomeDevices> persons, Integer s1, Integer s2) {
        return null;
    }

    public List<HomeDevices> meetCriteria(List<HomeDevices> devices, String str, Integer s1, Integer s2) {
        return null;
    }
}