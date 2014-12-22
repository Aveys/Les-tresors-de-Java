package com.tresors;

import com.tresors.controller.ControllerPrincipal;

import javax.swing.*;

/**
 * Created by Nicolas Sagon on 25/11/2014.
 */
public class LaunchVuePlateau {
    public static void main(String[] args) {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e){
        }
        ControllerPrincipal application = new ControllerPrincipal();
        application.showViewPlateau();
    }
}