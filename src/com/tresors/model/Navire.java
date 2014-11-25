package com.tresors.model;

import javafx.geometry.Point3D;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Classe Navire
 * Classe modele pour un joueur (Un Navire = Un joueur)
 */
public class Navire {

    private String capitaine;
    private String color;
    private int score;
    private Point coordonnees;
    private List<Charge> emplacement;

    public String getCapitaine() {
        return capitaine;
    }

    public void setCapitaine(String capitaine) {
        this.capitaine = capitaine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        if(score <0)
            System.out.println("Le score ne peut pas être negatif (DEBUG : implementer une exception");
        else
            this.score = score;
    }

    public Point getCoordonnees() {
        return coordonnees;
    }

    public void setCoordonnees(Point coordonnees) {
        this.coordonnees = coordonnees;
    }

    public void setCoordonnees(int x,int y){
        this.coordonnees=new Point(x,y);
    }

    public void setEmplacement(List<Charge> emplacement) {
        this.emplacement = emplacement;
    }


    public Navire(String capitaine, String color) {
        this.capitaine = capitaine;
        this.color = color;
        this.score=0;
        this.emplacement=new ArrayList<Charge>();
        //TODO: Vérifier les coordonnées de départ
        this.coordonnees=new Point(0,0);
    }

    /**
     * Donne le nombre de Pirate dans le navire
     * @return le nombre de pirate dans le navire
     */
    public int getNbPirate(){
        int nb=0;
        for (Charge c : emplacement){
            if(c instanceof Pirate)
                nb++;
        }
        return nb;
    }

    /**
     * Ajoute un nombre de points à un score
     * @param score le nombre de points à ajouter
     */
    public void addScore(int score){
        this.score=+score;
    }

    /**
     * Detecte si le joueur à atteint le score de victoire
     * @return true si le joueur est vainqueur.
     */
    public boolean estVainqueur(){
        return score >=10;
    }

    /**
     * Ajoute une charge à un emplacement du bateau
     * @param pos La position de l'emplacement
     * @param type le type de charge (P pour pirate, C pour canon)
     */
    public void ajouterCharge(int pos, char type){
        switch (type){
            case 'P':
                emplacement.set(pos,new Pirate());
                break;
            case 'C':
                emplacement.set(pos,new Canon());
                break;
        }
    }

    /**
     * ajouter un trésor sur l'emplacement d'un bateau
     * @param pos La position d'ajout du trésor
     * @param montant Le montant du trésor
     */
    public void ajouterTresor(int pos, int montant){
        if(montant>0)
            emplacement.set(pos,new Tresor(montant));
    }

    /**
     * Echange la position entre deux charges
     * @param pos1 la premiere position
     * @param pos2 la deuxieme position
     */
    public void echangerEmplacement(int pos1,int pos2){
        Charge tmp;
        tmp=emplacement.get(pos1);
        emplacement.set(pos1,emplacement.get(pos2));
        emplacement.set(pos2,tmp);
    }

    /**
     * Determine si l'emplacement est vide ou contient un object
     * @param pos
     * @return false si l'emplacement est déja pris
     */
    private boolean isEmplacementEmpty(int pos){
        return emplacement.get(pos) == null;
    }

    /**
     * Retourne la charge à l'emplacement
     * @param pos position de l'emplacement
     * @return la charge à l'emplacement. NULL si l'emplacement est vide.
     */
    private Charge getEmplacement(int pos){
        return emplacement.get(pos);
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

    /**
     * Verifie si le bateau est pillable
     * @return true si le bateau ets pillable, false si il ne l'est pas
     */
    public boolean estPillable(){
        if(checkConfigurationNavire()){
            boolean checkTresor=false;
            for (Charge c : emplacement){
                if(c instanceof Tresor)
                    return true;
            }
        }
        else
            return false;
        return false;
    }

    /**
     * Supprime un emplacements du navire (il prend des dégats)
     * @param pos La position à détruire
     * @return true si l'emplacement est détruit, false si il etait vide
     */
    private boolean supprimerEmplacement(int pos){
        if(emplacement.get(pos)==null)
            return false;
        else {
            emplacement.remove(pos);
            return true;
        }
    }

    /**
     * Retourne le contenu du Navire (Position,Charge)
     * @return le contenu du Navire (Position,Charge)
     */
    public HashMap<Integer,Charge> getContenuNavire() {
        HashMap<Integer, Charge> list = new HashMap<Integer, Charge>();
        for (int i = 0; i < 6; i++) {
            list.put(i, emplacement.get(i));
        }
        return list;
    }
}
