package com.tresors.model;

import com.tresors.event.IRepairCanonListener;
import com.tresors.event.IRepairPirateListener;
import com.tresors.event.RepairChangeNbCanonEvent;
import com.tresors.event.RepairChangeNbPirateEvent;

import javax.swing.event.EventListenerList;
//TODO Finish Javadoc
//TODO Implement to project
/**
 * A class that is the Model in the Model View Controller architecture
 * It contains the data
 * Created by Paul on 30/11/2014.
 * @author Paul Ribierre
 */
public class RepairModel {
    private int nbPirates;
    private int nbCanons;
    private final EventListenerList listeners = new EventListenerList();

    /**
     * Creates a Model with 3 canons and 3 pirates by default
     */
    public RepairModel(){this(3,3);}

    /**
     * Creates a Model with 3 canons and 3 pirates by default
     * @param nbCanons The number of canons by default
     * @param nbPirates The number of pirates by default
     */
    public RepairModel(int nbCanons, int nbPirates){
        super();
        this.nbPirates = nbPirates;
        this.nbCanons = nbCanons;
    }

    /**
     * Returns the amount of canons on the ship
     * @return the amount of canons on the ship
     */
    public int getNbCanons() {
        return nbCanons;
    }

    /**
     * Sets the amount of canons on the ship
     * @param nbCanons the amount of canons on the ship
     */
    public void setNbCanons(int nbCanons) {
        int old = getNbCanons();
        this.nbCanons = nbCanons;
        fireNbCanonsChanged(old,nbCanons);
    }

    /**
     * Returns the amount of pirates on the ship
     * @return the amount of pirates on the ship
     */
    public int getNbPirates() {
        return nbPirates;
    }

    /**
     * Sets the amount of pirates on the ship
     * @param nbPirates the amount of pirates on the ship
     */
    public void setNbPirates(int nbPirates) {
        int old = getNbPirates();
        this.nbPirates = nbPirates;
        fireNbPiratesChanged(old, nbPirates);
    }

    /**
     * Returns the list of
     * @return
     */
    public EventListenerList getListeners() {
        return listeners;
    }
    public void addRepairPirateListener(IRepairPirateListener listener){
        listeners.add(IRepairPirateListener.class, listener);
    }
    public void removeRepairPirateListener(IRepairPirateListener l){
        listeners.remove(IRepairPirateListener.class, l);
    }
    public void addRepairCanonListener(IRepairCanonListener listener){
        listeners.add(IRepairCanonListener.class, listener);
    }
    public void removeRepairCanonListener(IRepairCanonListener l){
        listeners.remove(IRepairCanonListener.class, l);
    }

    public void fireNbCanonsChanged(int oldNbCanons, int newNbCanons){
        IRepairCanonListener[] listenerList = (IRepairCanonListener[])listeners.getListeners(IRepairCanonListener.class);
       if (oldNbCanons < newNbCanons) {
            for (IRepairCanonListener listener : listenerList) {
                listener.canonsChanged(new RepairChangeNbCanonEvent(this, getNbCanons()));
                listener.canonsIncreased(new RepairChangeNbCanonEvent(this, getNbCanons()));
            }
        }
        else if (oldNbCanons > newNbCanons){
            for (IRepairCanonListener listener : listenerList) {
                listener.canonsChanged(new RepairChangeNbCanonEvent(this, getNbCanons()));
                listener.canonsDecreased(new RepairChangeNbCanonEvent(this, getNbCanons()));
            }
        }
    }
    public void fireNbPiratesChanged(int oldNbPirates, int newNbPirates){
        IRepairPirateListener[] listenerList = (IRepairPirateListener[])listeners.getListeners(IRepairPirateListener.class);
        if (oldNbPirates < newNbPirates) {
            for (IRepairPirateListener listener : listenerList) {
                listener.piratesChanged(new RepairChangeNbPirateEvent(this, getNbPirates()));
                listener.piratesIncreased(new RepairChangeNbPirateEvent(this, getNbPirates()));
            }
        }
        else if (oldNbPirates > newNbPirates){
            for (IRepairPirateListener listener : listenerList) {
                listener.piratesChanged(new RepairChangeNbPirateEvent(this, getNbPirates()));
                listener.piratesDecreased(new RepairChangeNbPirateEvent(this, getNbPirates()));
            }
       }
    }
}
