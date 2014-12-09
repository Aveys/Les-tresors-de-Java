package repair.vue;

import repair.controller.RepairController;
import repair.model.IRepairCanonListener;
import repair.model.IRepairPirateListener;

/**
 * Created by Paul on 30/11/2014.
 */
public abstract class RepairView implements IRepairPirateListener, IRepairCanonListener {
    private RepairController controller = null;

    public RepairView(RepairController controller){
        super();

        this.controller = controller;
    }

    public final RepairController getController(){
        return controller;
    }

    public abstract void display();
    public abstract void close();
}

