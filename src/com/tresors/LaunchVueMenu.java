package com.tresors;

import com.tresors.controller.ControllerPrincipal;

import javax.swing.*;

/**
 * Created by Paul on 25/11/2014.
 * Projet java ${PROJECT}
 */
public class LaunchVueMenu {

    public static void main(String[] args) {

        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e){}

        ControllerPrincipal application = new ControllerPrincipal();
        application.showViewMenu();
    }
}
