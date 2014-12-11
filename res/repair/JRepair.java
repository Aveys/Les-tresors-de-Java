package repair;

import repair.controller.RepairController;
import repair.model.RepairModel;

/**
 * Created by Paul on 30/11/2014.
 */
public class JRepair {
    public static void main(String[] args) {
        RepairModel model = new RepairModel(3,3);
        RepairController controller = new RepairController(model);
        controller.displayViews();
    }
}

