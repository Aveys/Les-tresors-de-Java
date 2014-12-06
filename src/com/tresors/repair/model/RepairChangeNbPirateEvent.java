package com.tresors.repair.model;

import javax.swing.event.ChangeEvent;

/**
 * Created by Paul on 30/11/2014.
 */

public class RepairChangeNbPirateEvent extends ChangeEvent {
    private int newNbPirates;

    public RepairChangeNbPirateEvent(Object source, int newNbPirates){
        super(source);
        this.newNbPirates = newNbPirates;
    }

    public int getNewNbPirates() {
        return newNbPirates;
    }
}
