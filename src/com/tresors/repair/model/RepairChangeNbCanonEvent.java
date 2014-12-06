package com.tresors.repair.model;

import javax.swing.event.ChangeEvent;

/**
 * Created by Paul on 30/11/2014.
 */

public class RepairChangeNbCanonEvent extends ChangeEvent {
    private int newNbCanons;

    public RepairChangeNbCanonEvent(Object source, int newNbCanons){
        super(source);
        this.newNbCanons = newNbCanons;
    }

    public int getNewNbCanons() {
        return newNbCanons;
    }
}
