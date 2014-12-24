package com.tresors.event.navire;

import com.tresors.model.Charge;

import javax.swing.event.ChangeEvent;

/**
 * Created by Paul on 11/12/2014.
 */
public class NavireChargeRemovedEvent extends ChangeEvent{
    private int posChargeRemoved;
    /**
     * Constructs a ChangeEvent object.
     *
     * @param source the Object that is the source of the event
     *               (typically <code>this</code>)
     */
    public NavireChargeRemovedEvent(Object source, int posChargeRemoved) {
        super(source);
        this.posChargeRemoved = posChargeRemoved;
    }

    public int getPosChargeRemoved() {
        return posChargeRemoved;
    }

}
