package com.mycompany.hdm.criteria; /**
 * Created by andrew on 29.04.2016.
 */

import com.mycompany.hdm.devices.HomeDevices;
import com.mycompany.hdm.exception.DevNotFoundException;

import java.util.List;

public interface Criteria {
    public List<HomeDevices> meetCriteria(List<HomeDevices> devices) throws DevNotFoundException;
    public List<HomeDevices> meetCriteria(List<HomeDevices> devices, String str) throws DevNotFoundException;
    public List<HomeDevices> meetCriteria(List<HomeDevices> devices, Integer s1, Integer s2) throws DevNotFoundException;
    public List<HomeDevices> meetCriteria(List<HomeDevices> devices, String str, Integer s1, Integer s2) throws DevNotFoundException;

}