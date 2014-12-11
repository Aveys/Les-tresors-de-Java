package com.tresors.event;

import javax.swing.event.ChangeEvent;

/**
 * A class that extends ChangeEvent and allows an event to modify the model
 * Created by Paul on 11/12/2014.
 * @author Paul Ribierre
 * @see javax.swing.event.ChangeEvent
 */
public class ChargePositionChangedEvent extends ChangeEvent{
    private int position;

    public ChargePositionChangedEvent(Object source, int newPosition){
        super(source);
        this.position = newPosition;
    }

    public int getPosition() {
        return position;
    }
}
