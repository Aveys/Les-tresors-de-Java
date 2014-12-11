package com.tresors.model;

import com.tresors.event.ChargePositionChangedEvent;
import com.tresors.event.IPositionChangedListener;

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

    public void addPositionChangedListener(IPositionChangedListener listener){
        listeners.add(IPositionChangedListener.class, listener);
    }

    public void removePositionChangedListener(IPositionChangedListener l){
        listeners.remove(IPositionChangedListener.class, l);
    }

    public void firePositionChanged(int oldPosition, int newPosition){
        IPositionChangedListener[] listenerList = (IPositionChangedListener[])listeners.getListeners(IPositionChangedListener.class);
        for (IPositionChangedListener listener : listenerList) {
            listener.positionChanged(new ChargePositionChangedEvent(this, getPosition()));
        }
    }
}
