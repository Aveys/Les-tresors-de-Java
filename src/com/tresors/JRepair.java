package com.tresors;

import com.tresors.controller.RepairController;
import com.tresors.model.Plateau;
import com.tresors.model.RepairModel;

import java.util.TreeMap;

/**
 * Created by Paul on 30/11/2014.
 */
public class JRepair {
    public static void main(String[] args) {
        TreeMap<String,String> listJoueurs = new TreeMap<String,String>();

        Plateau model = new Plateau(listJoueurs);
        RepairController controller = new RepairController(model);
        controller.displayViews();
    }
}

