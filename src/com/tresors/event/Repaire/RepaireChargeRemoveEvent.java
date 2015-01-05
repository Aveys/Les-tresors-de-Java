package com.tresors.event.Repaire;

import javax.swing.event.ChangeEvent;

/**
 * Created by aurelia on 05/01/2015.
 */
public class RepaireChargeRemoveEvent extends ChangeEvent {
    private int posChargeRemoved;
    /**
     * Constructs a ChangeEvent object.
     *
     * @param source the Object that is the source of the event
     *               (typically <code>this</code>)
     */
    public RepaireChargeRemoveEvent(Object source, int posChargeRemoved) {
        super(source);
        this.posChargeRemoved = posChargeRemoved;
    }

    public int getPosChargeRemoved() {
        return posChargeRemoved;
    }

}
