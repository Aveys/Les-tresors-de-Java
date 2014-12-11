package com.tresors.event.navire;

import com.tresors.model.Charge;

import javax.swing.event.ChangeEvent;

/**
 * Created by Paul on 11/12/2014.
 */
public class NavireChargeAddedEvent extends ChangeEvent {
    private Charge chargeAdded;
    /**
     * Constructs a ChangeEvent object.
     *
     * @param source the Object that is the source of the event
     *               (typically <code>this</code>)
     */
    public NavireChargeAddedEvent(Object source, Charge chargeAdded) {
        super(source);
        this.chargeAdded = chargeAdded;
    }

    public Charge getChargeAdded() {
        return chargeAdded;
    }
}
