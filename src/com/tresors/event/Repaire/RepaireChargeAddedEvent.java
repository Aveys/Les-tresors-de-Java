package com.tresors.event.Repaire;

import com.tresors.model.Charge;

import javax.swing.event.ChangeEvent;

/**
 * Created by aurelia on 05/01/2015.
 */
public class RepaireChargeAddedEvent  extends ChangeEvent {
    private Charge chargeAdded;
    /**
     * Constructs a ChangeEvent object.
     *
     * @param source the Object that is the source of the event
     *               (typically <code>this</code>)
     */
    public RepaireChargeAddedEvent(Object source, Charge chargeAdded) {
        super(source);
        this.chargeAdded = chargeAdded;
        //System.out.println(chargeAdded);
    }

    public Charge getChargeAdded() {
        return chargeAdded;
    }
}
