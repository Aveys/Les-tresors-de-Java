package com.tresors;

import com.tresors.controller.Controller;
import com.tresors.controller.ControllerMenu;
import com.tresors.controller.ControllerPrincipal;
import com.tresors.model.Plateau;
import com.tresors.vue.VueMenu;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Paul on 25/11/2014.
 * Projet java ${PROJECT}
 */
public class LaunchVueMenu {

    public static void main(String[] args) {

        try{UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");}
        catch(Exception e){}

        /*Plateau plateau = new Plateau();
        ControllerMenu controllerMenu = new ControllerMenu(plateau);
        JFrame test = new JFrame();

        VueMenu vueMenu =  new VueMenu(controllerMenu);
        test.add(vueMenu);
        Toolkit tk = Toolkit.getDefaultToolkit();
        test.setSize((int) tk.getScreenSize().getWidth(), (int) tk.getScreenSize().getHeight());
        test.setVisible(true);*/

        ControllerPrincipal test = new ControllerPrincipal();
        test.loadViewMenu();


    }

}
