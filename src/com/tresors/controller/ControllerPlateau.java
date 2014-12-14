package com.tresors.controller;


import com.tresors.model.ENavireColor;
import com.tresors.model.Navire;
import com.tresors.model.Plateau;
import com.tresors.vue.FramePrincipal;
import com.tresors.vue.VuePlateau;

import javax.swing.*;

/**
 * Created by arthurveys on 21/11/14.
 * Projet java ${PROJECT}
 */
public class ControllerPlateau extends Controller {
    /*The Repair View, initialized to NULL*/
    public JPanel view = null;
    /*The Repair Model, initialized to NULL*/
    private Plateau model = null;
    private VuePlateau vuePlateau = null;
    private ControllerPrincipal controllerPrincipal;
    private FramePrincipal framePrincipal;

    public ControllerPlateau(Plateau model, FramePrincipal f, ControllerPrincipal controllerPrincipal) {
        initController(model,f,controllerPrincipal);
        view = new VuePlateau(this);
        framePrincipal.changeView(view);
        addListenersToModel();
    }

    /**
     * A Method that adds listeners to the model
     */
    private void addListenersToModel() {
        //model.addRepairCanonListener(view);
        //model.addRepairPirateListener(view);
    }

    public void notifyAddJoueur(String nameJoueur, ENavireColor couleurJoueur){
        model.getListJoueurs().add(new Navire(nameJoueur,couleurJoueur));
    }

    public void notifyCommencerPartie(){
        this.controllerPrincipal.notifyCommencerPartie();
    }

    @Override
    public void initController(Plateau model, FramePrincipal f, ControllerPrincipal controllerPrincipal) {
        this.model = model;
        this.framePrincipal = f;
        this.controllerPrincipal = controllerPrincipal;
    }
}
