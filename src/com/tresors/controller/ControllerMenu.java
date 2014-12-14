package com.tresors.controller;

import com.tresors.model.ENavireColor;
import com.tresors.model.Navire;
import com.tresors.model.Plateau;
import com.tresors.vue.FramePrincipal;
import com.tresors.vue.VueMenu;
import com.tresors.vue.VuePlateau;

import javax.swing.*;

/**
 * Created by Nicolas Sagon on 11/12/2014.
 */
public class ControllerMenu extends Controller {
    /*The Repair View, initialized to NULL*/
    public JPanel view = null;
    /*The Repair Model, initialized to NULL*/
    private Plateau model = null;
    private VuePlateau vuePlateau = null;
    private ControllerPrincipal controllerPrincipal;
    private FramePrincipal framePrincipal;

    public ControllerMenu(Plateau model, FramePrincipal frame, ControllerPrincipal controller) {
        initController(model,frame,controller);
        view = new VueMenu(this);
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
    public Plateau getModel() {
        return model;
    }

    @Override
    public void initController(Plateau model, FramePrincipal frame, ControllerPrincipal controller) {
        this.model = model;
        this.framePrincipal = frame;
        this.controllerPrincipal = controller;
    }
}
