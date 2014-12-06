package com.tresors.repair.model;

import javax.swing.event.EventListenerList;

public class RepairModel {
    private int nbPirates;
    private int nbCanons;
    private final EventListenerList listeners = new EventListenerList();

    public RepairModel(){
        /**
         * Creates a Model with 3 canons and 3 pirates by default
         */
        this(3,3);
    }

    public RepairModel(int nbCanons, int nbPirates){
        super();

        this.nbPirates = nbPirates;
        this.nbCanons = nbCanons;
    }

    public int getNbCanons() {
        return nbCanons;
    }

    public void setNbCanons(int nbCanons) {
        int old = getNbCanons();
        this.nbCanons = nbCanons;
        fireNbCanonsChanged(old,nbCanons);
    }

    public int getNbPirates() {
        return nbPirates;
    }

    public void setNbPirates(int nbPirates) {
        int old = getNbPirates();
        this.nbPirates = nbPirates;
        fireNbPiratesChanged(old, nbPirates);
    }

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
