package com.mycompany.hdm.exception;

/**
 * Created by andrew on 05.05.2016.
 */
public class DevNotFoundException extends Exception {


    public DevNotFoundException() {
    }

    @Override
    public void printStackTrace() {
        System.out.println("Device not found!");
    }
}

