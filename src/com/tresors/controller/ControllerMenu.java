package com.tresors.controller;

import com.tresors.model.Plateau;
import com.tresors.vue.VueMenu;

/**
 * Created by Nicolas Sagon on 11/12/2014.
 */
public class ControllerMenu {
    /*The Repair View, initialized to NULL*/
    public VueMenu view = null;
    /*The Repair Model, initialized to NULL*/
    private Plateau model = null;

    public ControllerMenu(Plateau model) {
        this.model = model;
        view = new VueMenu(this);
        addListenersToModel();
    }

    /**
     * A Method that adds listeners to the model
     */
    private void addListenersToModel() {
        model.addRepairCanonListener(view);
        model.addRepairPirateListener(view);
    }
}
