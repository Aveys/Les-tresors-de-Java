package com.tresors.controller;

import com.tresors.model.ENavireColor;
import com.tresors.model.Navire;
import com.tresors.model.Plateau;
import com.tresors.vue.VueMenu;
import com.tresors.vue.VuePlateau;

import javax.swing.*;

/**
 * Created by Nicolas Sagon on 11/12/2014.
 */
public class ControllerMenu {
    /*The Repair View, initialized to NULL*/
    public JPanel view = null;
    /*The Repair Model, initialized to NULL*/
    private Plateau model = null;
    private VuePlateau vuePlateau = null;

    public ControllerMenu(Plateau model) {
        this.model = model;
        view = new VueMenu(this);
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

    public void notifyCallBoardView(){
       // this.view = new VuePlateauAlternatif(new ControllerPlateau(model));
    }
}
