package com.tresors.model;

/**
 * Created by arthurveys on 21/11/14.
 * Projet java ${PROJECT}
 */
public class Tresor extends Charge{
    private int montant;

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        if(montant>0)
            this.montant = montant;
    }

    public Tresor(int montant) {
        this.montant = montant;
    }
}
