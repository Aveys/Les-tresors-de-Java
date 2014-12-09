package com.tresors.repair;

import com.tresors.repair.controller.RepairController;
import com.tresors.repair.model.RepairModel;

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

