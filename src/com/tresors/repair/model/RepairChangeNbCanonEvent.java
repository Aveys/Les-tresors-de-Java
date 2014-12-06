package com.tresors.repair.model;

import javax.swing.event.ChangeEvent;

/**
 * A class that extends ChangeEvent and allows an event to modify the model
 * Created by Paul on 30/11/2014.
 * @author Paul Ribierre
 * @see javax.swing.event.ChangeEvent
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
