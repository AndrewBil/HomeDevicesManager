package com.mycompany.hdm.criteria;

import com.mycompany.hdm.devices.HomeDevices;
import com.mycompany.hdm.exception.DevNotFoundException;

import java.util.List;

/**
 * Created by andrew on 29.04.2016.
 */

public class AndCriteria implements Criteria {

    private Criteria criteria;
    private Criteria otherCriteria;

    public AndCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }


    @Override
    public List<HomeDevices> meetCriteria(List devices, String str) throws DevNotFoundException{
        List<HomeDevices> firstCriteria = criteria.meetCriteria(devices);
        return otherCriteria.meetCriteria(firstCriteria);
    }


    @Override
    public List<HomeDevices> meetCriteria(List<HomeDevices> devices) {
        return null;
    }

    @Override
    public List<HomeDevices> meetCriteria(List<HomeDevices> devices, Integer s1, Integer s2) throws DevNotFoundException {
        List<HomeDevices> firstCriteria = criteria.meetCriteria(devices);
        return otherCriteria.meetCriteria(firstCriteria);
    }

    @Override
    public List<HomeDevices> meetCriteria(List<HomeDevices> devices, String str, Integer s1, Integer s2) throws DevNotFoundException {
        List<HomeDevices> firstCriteria = null;
        firstCriteria = criteria.meetCriteria(devices, str);
        return otherCriteria.meetCriteria(firstCriteria, s1, s2);
    }


}
