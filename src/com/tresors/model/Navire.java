package com.tresors.model;

import com.tresors.event.navire.*;

import javax.swing.event.EventListenerList;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Classe navire
 * Classe modele pour un joueur (Un navire = Un joueur)
 */
public class Navire {
    //Attributes
    private String capitaine;
    private ENavireColor color;
    private int score;
    private Point coordonnees;
    private ArrayList<Charge> emplacement;

    private final EventListenerList listeners = new EventListenerList();

    public Navire(String capitaine, ENavireColor color) {
        this.capitaine = capitaine;
        this.color = color;
        this.score=0;
        this.emplacement=new ArrayList<Charge>();
        this.coordonnees=new Point(1,0);
    }

    //Methods
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
     * @param charge charge à ajouter au navire
     */
    public void ajouterCharge(Charge charge){
        if (charge  instanceof Pirate) {
            emplacement.add(charge);
            fireChargeAdded(charge);
        }
        else if (charge instanceof Canon){
            emplacement.add(charge);
            fireChargeAdded(charge);
        }
    }
    /**
     * Ajouter un Pirate à la fin de l'arraylist sans spécifier de position
     */
    public void ajouterPirate(Pirate pirate){
        //ajoute un pirate à la fin de l'array list
        this.emplacement.add(pirate);

        fireChargeAdded(pirate);
    }
    /**
     * Ajouter un Canon à la fin de l'arraylist sans spécifier de position
     */
    public void ajouterCanon(Canon canon){
        this.emplacement.add(canon);
        fireChargeAdded(canon);
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

    public int getTresore(){
        if (getEmplacement(5) instanceof Tresor){
            return ((Tresor) getEmplacement(5)).getMontant();
        }
        return 0;
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
        emplacement.set(pos2, tmp);
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
    public boolean supprimerChargeAt(int pos){
        int  indexChARemov=9;//9 car pas possible
        int i;
        for(i= 0; i<emplacement.size() ; i++){
            if(emplacement.get(i).getPosition()==pos){
                indexChARemov=i;
            }
        }
        //int position= emplacement.get(pos).getPosition();
        if(indexChARemov!=9){
            emplacement.remove(indexChARemov);
            fireChargeRemoved(pos);
        }
       return true;
    }

    /**
     * Retourne le contenu du navire (Position,charge)
     * @return le contenu du navire (Position,charge)
     */
    public HashMap<Integer,Charge> getContenuNavire() {
        HashMap<Integer, Charge> list = new HashMap<Integer, Charge>();
        for (int i = 0; i < emplacement.size(); i++) {
            list.put(i, emplacement.get(i));
        }
        return list;
    }
    public String  getTypeCharge(int i) {
            //System.out.println(emplacement.get(j).getPosition() +"=="+i);
            for(Charge c: emplacement)
            {

                if (c.getPosition() == i) {
                    if (c instanceof Pirate)
                        return "Pirate";
                    if (c instanceof Canon)
                        return "Canon";
                }

            }
        return "null";
    }


    public ArrayList<Integer> getPositionLibre() {
        ArrayList<Integer> positionLibre= new ArrayList<Integer>();

        for (int i = 0; i <6 ; i++) {positionLibre.add(i);}

        for(Charge c: emplacement)
        {

            positionLibre.remove(positionLibre.indexOf(c.getPosition()));
        }


        return positionLibre;
    }

    public void supprimerPirate() {
        for (int i = 0; i <emplacement.size() ; i++) {
                if (emplacement.get(i) instanceof Pirate) {
                    {
                        int pos= emplacement.get(i).getPosition();
                        emplacement.remove(i);
                        fireChargeRemoved(pos);
                        break;
                    }

                }
            }

    }

    public void supprimerCanon() {
        for (int i = 0; i <emplacement.size() ; i++) {
            if (emplacement.get(i) instanceof Canon) {
                int pos= emplacement.get(i).getPosition();
                emplacement.remove(i);
                fireChargeRemoved(pos);
                break;
            }
        }

    }

    // Listeners
    public EventListenerList getListeners() {
        return listeners;
    }

   //Getters Setters
    public String getCapitaine() {
        return capitaine;
    }
    public void setCapitaine(String capitaine) {
        this.capitaine = capitaine;
    }
    public ENavireColor getColor() {
        return color;
    }
    public void setColor(ENavireColor color) {
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
        fireEmplacementChanged(this.coordonnees);
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

    //Fire Change in View
    /*public void fireNbCanonsChanged(int NbCanons, String type){
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
    }*/
   /* public void fireNbPiratesChanged(int NbPirates, String type){
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
*/
    public void fireEmplacementChanged(Point P){
        INavirePositionListener[] listenerList = (com.tresors.event.navire.INavirePositionListener[])listeners.getListeners(com.tresors.event.navire.INavirePositionListener.class);
        for (com.tresors.event.navire.INavirePositionListener listener : listenerList) {
            listener.positionChanged(new com.tresors.event.navire.NavirePositionChangedEvent(this, getCoordonnees()));
        }
    }

    public void fireNameChanged(String name){
        com.tresors.event.navire.INavireNameListener[] listenerList = (com.tresors.event.navire.INavireNameListener[])listeners.getListeners(com.tresors.event.navire.INavireNameListener.class);
        for (com.tresors.event.navire.INavireNameListener listener : listenerList) {
            listener.nameChanged(new com.tresors.event.navire.NavireNameChangedEvent(this, getCapitaine()));
        }
    }

    public void fireColorChanged(String color){
        com.tresors.event.navire.INavireColorListener[] listenerList = (com.tresors.event.navire.INavireColorListener[])listeners.getListeners(com.tresors.event.navire.INavireColorListener.class);
        for (com.tresors.event.navire.INavireColorListener listener : listenerList) {
            listener.colorChanged(new NavireColorChangedEvent(this, getColor()));
        }
    }

    public void fireScoreChanged(String color){
        INavireScoreListener[] listenerList = (INavireScoreListener[])listeners.getListeners(INavireScoreListener.class);
        for (INavireScoreListener listener : listenerList) {
            listener.scoreChanged(new NavireScoreChangedEvent(this, getScore()));
        }
    }

    public void fireChargeAdded(Charge charge){

        INavireChargeListener[] listenerList = (INavireChargeListener[])listeners.getListeners(INavireChargeListener.class);

        for (INavireChargeListener listener : listenerList) {
            System.out.print(charge.getPosition());
            listener.chargeAdded(new NavireChargeAddedEvent(this, charge));
        }
    }

    public void fireChargeRemoved(int position){
        INavireChargeListener[] listenerList = (INavireChargeListener[])listeners.getListeners(INavireChargeListener.class);
        for (INavireChargeListener listener : listenerList) {
            listener.chargeRemoved(new NavireChargeRemovedEvent(this, position));
        }
    }


    public void addRepairChargeListener(INavireChargeListener listener){

        listeners.add(INavireChargeListener.class, listener);
    }
    public void removeRepairChargeListener(INavireChargeListener l){
        listeners.remove(INavireChargeListener.class, l);
    }
    public void addNavirePositionListener(INavirePositionListener listener){

        listeners.add(INavirePositionListener.class, listener);
    }
    public void removeNavirePositionListener(INavirePositionListener l){
        listeners.remove(INavirePositionListener.class, l);
    }



}
