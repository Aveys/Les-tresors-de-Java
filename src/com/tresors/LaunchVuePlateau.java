package com.tresors;

import com.tresors.vue.VuePlateau;

import javax.swing.*;

/**
 * Created by Nicolas Sagon on 25/11/2014.
 */
public class LaunchVuePlateau {
    public static void main(String[] args) {
        try
        {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        }
        catch(Exception e){
        }
        VuePlateau test = new VuePlateau();
    }
}