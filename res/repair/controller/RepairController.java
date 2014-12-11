package repair.controller;

import repair.model.RepairModel;
import repair.vue.JFrameFieldRepair;
import repair.vue.RepairView;

/**
 * A Class that is the controller to every repair action
 * Created by Paul on 30/11/2014.
 * @author Paul Ribierre
 */
public class RepairController {
    /*The Repair View, initialized to NULL*/
    public RepairView view = null;
    /*The Repair Model, initialized to NULL*/
    private RepairModel model = null;

    /**
     * Creates a RepairController with a model as parameter
     * @param model a RepairModel used by the controller as database
     */
    public RepairController(RepairModel model){
        this.model = model;
        view = new JFrameFieldRepair(this, model.getNbPirates(), model.getNbCanons());
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

