package com.mycompany.hdm.devices;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.IOException;

/**
 * Created by andrew on 01.05.2016.
 */
public class Fridge extends HomeDevices {

    @JsonProperty
    private String uid;
    private String name;
    private String model;
    private Status status = Status.OFF;
    private String serialNumber;
    private String type;
    private String manufacturer;
    private Integer powerConsumption;


    public String getUid() {
        return uid;
    }


    public String getName() {
        return name;
    }


    public String getModel() {
        return model;
    }


    public String getSerialNumber() {
        return serialNumber;
    }


    public Status getStatus() {
        return status;
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



    public Fridge() {
    }

    public Fridge(String name, String model, String serialNumber, String manufacturer, Integer powerConsumption) throws IOException {
        this.uid = HomeDevices.getmUID();
        this.model = model;
        this.serialNumber = serialNumber;
        this.type = this.getClass().getSimpleName();
        this.manufacturer = manufacturer;
        this.powerConsumption = powerConsumption;
        this.name = name;

    }


    @Override
    public void setStatus(Status status) {
        this.status = status;
    }


}

