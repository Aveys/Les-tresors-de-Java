package com.tresors.controller;

import com.tresors.model.Plateau;
import com.tresors.vue.FramePrincipal;

/**
 * Controller Principal qui appelle les autres controllers et est étendus par les autres controllers
 * Created by Paul on 13/12/2014.
 */
public class ControllerPrincipal {
    private Controller activeController;
    private FramePrincipal frame;
    private Plateau model;

    public ControllerPrincipal(){
        frame = new FramePrincipal();
    }

    public void loadViewMenu(){
        this.model = new Plateau();
        this.activeController = new ControllerMenu(model, frame, this);
    }

    public void loadViewPlateau(){
        this.model = new Plateau();
        this.activeController = new ControllerPlateau(model, frame, this);
    }

    public void notifyCommencerPartie(){
        this.activeController = new ControllerPlateau(this.model, this.frame, this);
    }
}