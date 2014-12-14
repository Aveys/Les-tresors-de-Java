package com.tresors.controller;

import com.tresors.model.Plateau;
import com.tresors.vue.FramePrincipal;
import com.tresors.vue.HexMech;

import javax.swing.*;

/**
 * Controller Principal qui appelle les autres controllers et est étendus par les autres controllers
 * Created by Paul on 13/12/2014.
 */
public class ControllerPrincipal {
    private Controller activeController;
    private FramePrincipal frame;
    private ControllerMenu controllerMenu;
    private ControllerHexGame controllerHexGame;
    private Plateau p;

    public ControllerPrincipal(){

        frame = new FramePrincipal();
    }

    public void loadViewMenu(){

        this.p = new Plateau();
        controllerMenu = new ControllerMenu(p, frame, this);
    }

    public void notifyCommencerPartie(){

        controllerHexGame = new ControllerHexGame(this.p, this.frame, this);

    }
}