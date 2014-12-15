package com.tresors.controller;

import com.tresors.model.ENavireColor;
import com.tresors.model.Plateau;
import com.tresors.vue.FramePrincipal;
import com.tresors.HexGame;
import com.tresors.vue.HexMech;

import javax.swing.*;

/**
 * Created by Nicolas Sagon on 14/12/2014.
 */
public class ControllerHexGame extends Controller {

    private Plateau model;
    private FramePrincipal framePrincipal;
    private JPanel view;
    private ControllerPrincipal controllerPrincipal;


    public ControllerHexGame(Plateau model, FramePrincipal frame, ControllerPrincipal controller) {
        initController(model, frame, controller);
        HexMech.setHeight(100);
        HexMech.setBorders(5);
        view = new HexGame(model.getPlateau(),100);
        framePrincipal.changeView(view);
    }

    @Override
    public void initController(Plateau model, FramePrincipal frame, ControllerPrincipal controller) {
        this.model = model;
        this.framePrincipal = frame;
        this.controllerPrincipal = controller;
    }

    @Override
    public void notifyAddJoueur(String nameJoueur, ENavireColor couleurJoueur) {

    }
    @Override
    public void notifyCommencerPartie() {

    }

    @Override
    public Plateau getModel() {
        return model;
    }
}
