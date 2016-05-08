package com.mycompany.hdm.main;

import com.mycompany.hdm.menu.main.MainMenu;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.io.IOException;

/**
 * Created by andrew on 01.05.2016.
 */
public class Main {
    public static final Logger logger = (Logger) LogManager.getRootLogger();
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Home Device Manager.");
        System.out.println("");
        logger.info("Logger: Start");
        MainMenu menu = new MainMenu();
        menu.startMenu();
    }

}
