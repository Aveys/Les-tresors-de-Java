package com.tresors.event.navire;

import com.tresors.model.Charge;

import javax.swing.event.ChangeEvent;

/**
 * Created by Paul on 11/12/2014.
 */
public class NavireChargeRemovedEvent extends ChangeEvent{
    private Charge chargeRemoved;
    /**
     * Constructs a ChangeEvent object.
     *
     * @param source the Object that is the source of the event
     *               (typically <code>this</code>)
     */
    public NavireChargeRemovedEvent(Object source, Charge chargeRemoved) {
        super(source);
        this.chargeRemoved = chargeRemoved;
    }

    public Charge getChargeRemoved() {
        return chargeRemoved;
    }

}
