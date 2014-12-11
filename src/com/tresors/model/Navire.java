package com.tresors.model;

import com.tresors.event.IRepairCanonListener;
import com.tresors.event.IRepairPirateListener;
import com.tresors.event.RepairChangeNbCanonEvent;
import com.tresors.event.RepairChangeNbPirateEvent;

import javax.swing.event.EventListenerList;
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
    private ArrayList<Charge> emplacement;
    private final EventListenerList listeners = new EventListenerList();
    //TODO verifier que l'emplacement commence a 1 pour que ça correspond au de

    public Navire(String capitaine, String color) {
        this.capitaine = capitaine;
        this.color = color;
        this.score=0;
        this.emplacement=new ArrayList<Charge>();
        this.coordonnees=new Point(1,0);
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
                emplacement.set(pos,new Pirate(pos));
                fireNbPiratesChanged(this.getNbPirates(),"ajout");
                break;
            case 'C':
                emplacement.set(pos,new Canon(pos));
                fireNbCanonsChanged(this.getNbCanons(),"ajout");
                break;
        }
    }
    /**
     * Ajouter un Pirate à la fin de l'arraylist sans spécifier de position
     */
    public void ajouterPirate(){
        this.emplacement.add(new Pirate(emplacement.size()));
        fireNbPiratesChanged(this.getNbPirates(),"ajout");
    }
    /**
     * Ajouter un Canon à la fin de l'arraylist sans spécifier de position
     */
    public void ajouterCanon(){
        this.emplacement.add(new Pirate(emplacement.size()));
        fireNbCanonsChanged(this.getNbCanons(),"ajout");
    }
    /**
     * ajouter un trésor sur l'emplacement d'un bateau
     * @param pos La position d'ajout du trésor
     * @param montant Le montant du trésor
     */
    public void ajouterTresor(int pos, int montant){
        if(montant>0)
            emplacement.set(pos,new Tresor(montant,pos));
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
           if(emplacement.get(pos) instanceof Pirate)
           {
               emplacement.remove(pos);
               fireNbPiratesChanged(this.getNbPirates(),"suppression");
           }
           else if (emplacement.get(pos) instanceof Canon)
           {
               emplacement.remove(pos);
               fireNbCanonsChanged(this.getNbCanons(),"suppression");
           }

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

    public void fireNbCanonsChanged(int NbCanons, String type){
        IRepairCanonListener[] listenerList = (IRepairCanonListener[])listeners.getListeners(IRepairCanonListener.class);
        if (type=="ajout") {
            for (IRepairCanonListener listener : listenerList) {
                listener.canonsChanged(new RepairChangeNbCanonEvent(this, getNbCanons()));
                listener.canonsIncreased(new RepairChangeNbCanonEvent(this, getNbCanons()));
            }
        }
        else if (type=="suppression"){
            for (IRepairCanonListener listener : listenerList) {
                listener.canonsChanged(new RepairChangeNbCanonEvent(this, getNbCanons()));
                listener.canonsDecreased(new RepairChangeNbCanonEvent(this, getNbCanons()));
            }
        }
    }

    public void fireNbPiratesChanged(int NbPirates, String type){
        IRepairPirateListener[] listenerList = (IRepairPirateListener[])listeners.getListeners(IRepairPirateListener.class);
        if (type=="ajout") {
            for (IRepairPirateListener listener : listenerList) {
                listener.piratesChanged(new RepairChangeNbPirateEvent(this, getNbPirates()));
                listener.piratesIncreased(new RepairChangeNbPirateEvent(this, getNbPirates()));
            }
        }
        else if (type=="suppression"){
            for (IRepairPirateListener listener : listenerList) {
                listener.piratesChanged(new RepairChangeNbPirateEvent(this, getNbPirates()));
                listener.piratesDecreased(new RepairChangeNbPirateEvent(this, getNbPirates()));
            }
        }
    }
//Getters Setters
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
    public List<Charge> getListEmplacement() {
        return emplacement;
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
    /**
     * Donne le nombre de Pirate dans le navire
     * @return le nombre de pirate dans le navire
     */
    public int getNbPirates(){
        int nb=0;
        for (Charge c : emplacement){
            if(c instanceof Pirate)
                nb++;
        }
        return nb;
    }
    /**
     * Donne le nombre de canon dans le navire
     * @return le nombre de canon dans le navire
     */
    public int getNbCanons(){
        int nb=0;
        for (Charge c : emplacement){
            if(c instanceof Canon)
                nb++;
        }
        return nb;
    }
}
