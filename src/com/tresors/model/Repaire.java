package com.tresors.model;

import com.tresors.event.Repaire.IRepaireChargeListener;
import com.tresors.event.Repaire.RepaireChargeAddedEvent;
import com.tresors.event.Repaire.RepaireChargeRemoveEvent;

import javax.swing.event.EventListenerList;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by arthurveys on 21/11/14.
 * Projet java ${PROJECT}
 */
public class Repaire extends Case{
    private List<Charge> charges;
    private int montantTresors;

    public Point getCoordonnees() {
        return coordonnees;
    }

    public void setCoordonnees(Point coordonnees) {
        this.coordonnees = coordonnees;
    }

    private Point coordonnees;

    private final EventListenerList listeners = new EventListenerList();

    public Repaire(List<Charge> Charges,int montantTresors) {
        this.charges = charges;
        this.montantTresors=montantTresors;
    }

    public Repaire(){
        this.charges = new ArrayList<Charge>();
        this.montantTresors=0;
    };

    public Repaire(Charge c1,Charge c2,Charge c3,Charge c4,Charge c5,Charge c6,int montantTresors) {
        //List<Charge> list = new ArrayList<Charge>();
        charges = new ArrayList<Charge>();
        if(c1!=null){
            charges.add(c1);
        }
        if(c2!=null){
            charges.add(c2);
        }
        if(c3!=null){
            charges.add(c3);
        }
        if(c4!=null){
            charges.add(c4);
        }
        if(c5!=null){
            charges.add(c5);
        }
        if(c6!=null){
            charges.add(c6);
        }
        this.montantTresors=montantTresors;
    }

    // Listeners
    public EventListenerList getListeners() {
        return listeners;
    }


    /**
     * Actualise les emplacements du repaire (il prend des dégats)
     * @param pos La position à détruire
     * @return true si l'emplacement est détruit, false si il etait vide
     */
    private boolean faireDegats(int pos){
        if(charges.get(pos)==null)
            return false;
        else {
            charges.remove(pos);
            return true;
        }
    }

    /**
     * Vérification si le repaire a encore un pirate et un canon (des qu'on a plus d'un on a gagner)
     * @return true si le repaire est bon, false sinon.
     */
    public boolean checkRepaireAttaquable(){
        boolean checkPirate=false;
        boolean checkCanon=false;

        for(Charge c: this.charges){
            if(c instanceof Pirate)
                checkPirate=true;
            if (c instanceof Canon)
                checkCanon=true;
        }
        return (checkCanon&&checkPirate);
    }

    /**
     * verifier la presence d'un montant equivalent a un tresore
     * @return true si il y a une montant/tresor
     */
    //TODO un repaire ne possede pas de tresore mais un montant, doit on changer ça?
    public boolean estPillable(){
        return this.montantTresors != 0;
    }



    public void supprimerEmplacement(int pos){
        List<Charge> listTmp = charges;

        for(Charge c : listTmp){
            if(pos==c.getPosition()){
                charges.remove(c);
            }
        }
    }

    public int getNbCanons(){
        int nb=0;
        for (Charge c : charges){
            if(c instanceof Canon)
                nb++;
        }
        return nb;
    }

    public int getNbPirates(){
        int nb=0;
        for (Charge c : charges){
            if(c instanceof Pirate)
                nb++;
        }
        return nb;
    }

    public List<Charge> getCharges() {
        return charges;
    }

    public int getMontantTresors() {
        return montantTresors;
    }

    public void setMontantTresors(int montantTresors) {
        this.montantTresors = montantTresors;
    }


    public void fireChargeAdded(Charge charge){

        IRepaireChargeListener[] listenerList = (IRepaireChargeListener[])listeners.getListeners(IRepaireChargeListener.class);

        for (IRepaireChargeListener listener : listenerList) {
            //TODO gérer le traitement de l'ajout d'une charge
            System.out.print(charge.getPosition());
            listener.chargeAdded(new RepaireChargeAddedEvent(this, charge));
        }
    }

    public void fireChargeRemoved(int position){
        IRepaireChargeListener[] listenerList = (IRepaireChargeListener[])listeners.getListeners(IRepaireChargeListener.class);
        for (IRepaireChargeListener listener : listenerList) {
            //TODO gérer le traitement de l'ajout d'une charge
            listener.chargeRemoved(new RepaireChargeRemoveEvent(this, position));
        }
    }

    public void addRepairChargeListener(IRepaireChargeListener listener){

            listeners.add(IRepaireChargeListener.class, listener);
        }
    public void removeRepairChargeListener(IRepaireChargeListener l){
            listeners.remove(IRepaireChargeListener.class, l);
    }

}
