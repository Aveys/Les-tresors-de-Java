package com.tresors.repair.controller;

import com.tresors.repair.model.RepairModel;
import com.tresors.repair.vue.JFrameFieldRepair;
import com.tresors.repair.vue.RepairView;

/**
 * A Class that is the controller to every repair action
 * Created by Paul on 30/11/2014.
 */
public class RepairController {
    /*The Repair View, initialized to NULL*/
    public RepairView view = null;
    /*The Repair Model, initialized to NULL*/
    private RepairModel model = null;

    /**
     * Creates a RepairController with a model as parameter
     * @param model
     */
    public RepairController(RepairModel model){
        this.model = model;
        view = new JFrameFieldRepair(this, model.getNbPirates(), model.getNbCanons());
        addListenersToModel();
    }

    private void addListenersToModel() {
        model.addRepairCanonListener(view);
        model.addRepairPirateListener(view);
    }

    public void displayViews(){
        view.display();
    }

    public void closeViews(){
        view.close();
    }

    public void notifyPiratesChanged(int nbPirates){
        model.setNbPirates(nbPirates);
    }
    public void notifyPiratesIncreased(int nbPirates){
        model.setNbPirates(nbPirates);
    }
    public void notifyPiratesDecreased(int nbPirates){
        model.setNbPirates(nbPirates);
    }

    public void notifyCanonsChanged(int nbCanons){
        model.setNbCanons(nbCanons);
    }
    public void notifyCanonsIncreased(int nbCanons){
        model.setNbCanons(nbCanons);
    }
    public void notifyCanonsDecreased(int nbCanons){
        model.setNbCanons(nbCanons);
    }
}

