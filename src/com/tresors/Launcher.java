package com.tresors;

import com.tresors.controller.ControllerJeu;
import com.tresors.vue.VueMenu;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Paul on 25/11/2014.
 * Projet java ${PROJECT}
 */
public class Launcher {

    public static void main(String[] args) {

        ControllerJeu controllerJeu = new ControllerJeu();

        JFrame test = new JFrame();

        VueMenu vueMenu =  new VueMenu();
        test.add(vueMenu);
        Toolkit tk = Toolkit.getDefaultToolkit();
        test.setSize((int) tk.getScreenSize().getWidth(), (int) tk.getScreenSize().getHeight());
        test.setVisible(true);


    }

}
