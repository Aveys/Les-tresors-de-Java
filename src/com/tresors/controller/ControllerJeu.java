package com.tresors.controller;

import com.tresors.model.*;
import com.tresors.vue.JFrameRepair;
import com.tresors.vue.RepairView;
import com.tresors.vue.Vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeMap;

/**
 * Created by arthurveys on 21/11/14.
 * Projet java ${PROJECT}
 */
public class ControllerJeu {

    private Model model = new Model();
    private Vue view = new Vue();

    /**
     * Creates a RepairController with a model as parameter
     * @param model a RepairModel used by the controller as database
     */
    public ControllerJeu(Model model){
        this.model = model;
        view = new JFrameTresors(this, model.getNbPirates(), model.getNbCanons());
        addListenersToModel();
    }

    /**
     * A Method that adds listeners to the model
     */
    private void addListenersToModel() {
        model.addRepairCanonListener(view);
        model.addRepairPirateListener(view);
    }

    /**
     * Displays the required view
     */
    public void displayViews(){
        view.display();
    }
    /**
     * Closes the window
     */
    public void closeViews(){
        view.close();
    }
    /**
     * A Method that indicates to the model that data has been modified
     * @param nbPirates the new amount of pirates on the ship
     */
    public void notifyPiratesChanged(int nbPirates){
        model.setNbPirates(nbPirates);
    }
    /**
     * A Method that indicates to the model that data has been modified
     * The number of Pirates on a Ship have been Increased to nbPirates
     * @param nbPirates the new amount of pirates on the ship
     */
    public void notifyPiratesIncreased(int nbPirates){
        model.setNbPirates(nbPirates);
    }
    /**
     * A Method that indicates to the model that data has been modified
     * The number of Pirates on a Ship have been Decreased to nbPirates
     * @param nbPirates the new amount of pirates on the ship
     */
    public void notifyPiratesDecreased(int nbPirates){
        model.setNbPirates(nbPirates);
    }
    /**
     * A Method that indicates to the model that data has been modified
     * @param nbCanons the new amount of canons on the ship
     */
    public void notifyCanonsChanged(int nbCanons){
        model.setNbCanons(nbCanons);
    }
    /**
     * A Method that indicates to the model that data has been modified
     * The number of Pirates on a Ship have been Increased to nbCanons
     * @param nbCanons the new amount of canons on the ship
     */
    public void notifyCanonsIncreased(int nbCanons){
        model.setNbCanons(nbCanons);
    }
    /**
     * A Method that indicates to the model that data has been modified
     * The number of Pirates on a Ship have been Decreased to nbCanons
     * @param nbCanons the new amount of canons on the ship
     */
    public void notifyCanonsDecreased(int nbCanons){
        model.setNbCanons(nbCanons);
    }
}
