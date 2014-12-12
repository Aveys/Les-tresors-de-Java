package com.tresors.model;

import com.tresors.event.charge.ChargePositionChangedEvent;
import com.tresors.event.charge.IChargePositionChangedListener;

import javax.swing.event.EventListenerList;

/**
 * Created by arthurveys on 21/11/14.
 * Projet java ${PROJECT}
 */
public abstract class Charge {
    int position;
    private final EventListenerList listeners = new EventListenerList();

    public Charge(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int newPosition) {
        int oldPosition = this.position;
        this.position = newPosition;
        firePositionChanged(oldPosition,newPosition);
    }

    public EventListenerList getListeners() {
        return listeners;
    }

    public void addPositionChangedListener(IChargePositionChangedListener listener){
        listeners.add(IChargePositionChangedListener.class, listener);
    }

    public void removePositionChangedListener(IChargePositionChangedListener l){
        listeners.remove(IChargePositionChangedListener.class, l);
    }

    public void firePositionChanged(int oldPosition, int newPosition){
        IChargePositionChangedListener[] listenerList = (IChargePositionChangedListener[])listeners.getListeners(IChargePositionChangedListener.class);
        for (IChargePositionChangedListener listener : listenerList) {
            listener.positionChanged(new ChargePositionChangedEvent(this, getPosition()));
        }
    }
}
