package com.tresors.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arthurveys on 21/11/14.
 * Projet java ${PROJECT}
 */
public class Repaire extends Case{
    private List<Charge> emplacement;
    private int montantTresors;

    public Repaire(List<Charge> emplacement,int montantTresors) {
        this.emplacement = emplacement;
        this.montantTresors=montantTresors;
    }
    public Repaire(Charge c1,Charge c2,Charge c3,Charge c4,Charge c5,Charge c6,int montantTresors) {
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
        if(emplacement.get(pos)==null)
            return false;
        else {
            emplacement.remove(pos);
            return true;
        }
    }

    /**
     * Vérification si le beateau a encore un pirate et un canon
     * @return true si le navire est bon, false sinon.
     */
    public boolean checkConfigurationNavire(){
        boolean checkPirate=false;
        boolean checkCanon=false;
        for(Charge c: this.emplacement){
            if(c instanceof Pirate)
                checkPirate=true;
            if (c instanceof Canon)
                checkCanon=true;
        }
        return checkCanon&&checkPirate;
    }
    public boolean estPillable(){
        for(Charge c: this.emplacement){
            if(c instanceof Tresor)
                return true;
        }
        return false;
    }
    public void supprimerEmplacement(int pos){
        emplacement.remove(pos);
    }
}
