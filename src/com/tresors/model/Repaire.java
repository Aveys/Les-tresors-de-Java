package com.tresors.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arthurveys on 21/11/14.
 * Projet java ${PROJECT}
 */
public class Repaire extends Case{
    private List<Charge> Charges;
    private int montantTresors;

    public Repaire(List<Charge> Charges,int montantTresors) {
        this.Charges = Charges;
        this.montantTresors=montantTresors;
    }
    public Repaire(Charge c1,Charge c2,Charge c3,Charge c4,Charge c5,Charge c6,int montantTresors) {
        super();
        List<Charge> list = new ArrayList<Charge>();
        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.add(c4);
        list.add(c5);
        list.add(c6);
        this.montantTresors=montantTresors;
    }

    /**
     * Actualise les emplacements du repaire (il prend des dégats)
     * @param pos La position à détruire
     * @return true si l'emplacement est détruit, false si il etait vide
     */
    private boolean faireDegats(int pos){
        if(Charges.get(pos)==null)
            return false;
        else {
            Charges.remove(pos);
            return true;
        }
    }

    /**
     * Vérification si le repaire a encore un pirate ou un canon (des qu'on a plus d'un on a gagner)
     * @return true si le repaire est bon, false sinon.
     */
    public boolean checkConfigurationRepaire(){
        boolean checkPirate=false;
        boolean checkCanon=false;

        for(Charge c: this.Charges){
            if(c instanceof Pirate)
                checkPirate=true;
            if (c instanceof Canon)
                checkCanon=true;
        }
        return (checkCanon||checkPirate);
    }

    /**
     * verifier la presence d'un montant equivalent a un tresore
     * @return true si il y a une montant/tresor
     */
    //TODO un repaire ne possede pas de tresore mais un montant, doit on changer ça?
    public boolean estPillable(){
        if (this.montantTresors!=0)
            return true;
        else
            return false;
    }


    public void supprimerEmplacement(int pos){
        Charges.remove(pos);
    }

    public int getMontantTresors() {
        return montantTresors;
    }

    public void setMontantTresors(int montantTresors) {
        this.montantTresors = montantTresors;
    }
}
