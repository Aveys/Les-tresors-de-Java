package com.tresors.controller;


import com.tresors.event.navire.INavirePositionListener;
import com.tresors.model.*;
import com.tresors.vue.FramePrincipal;
import com.tresors.vue.HexMech;
import com.tresors.vue.VuePlateau;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by arthurveys on 21/11/14.
 * Projet java ${PROJECT}
 */
public class ControllerPlateau extends Controller {

    /*The Repair View, initialized to NULL*/
    public JPanel view = null;
    /*The Repair Model, initialized to NULL*/
    private Plateau model = null;

    private VuePlateau vuePlateau = null;
    private ControllerPrincipal controllerPrincipal;
    private FramePrincipal framePrincipal;
    private int currentPlayer;//valeur de l'index du joueur actuel commence à 1 et pas 0
    private int currentPlayerStage; //Variable indiquant à quel etape en est le joueur. Conditionne les actions possibles, etape 1 on peux attaquer ou se déplacer, etape 2 on peut attaquer ou réparer
    private Navire navireSelectedAttack;
    private boolean deplacementAutorise=false;

    //dostartgame
    public ControllerPlateau(Plateau model, FramePrincipal f, ControllerPrincipal controllerPrincipal) {
        initController(model,f,controllerPrincipal);


        //test reparer ajout des pirates / canons
        ////
        ////
        currentPlayer = 0;

        Navire n =this.getModel().getListJoueurs().get(currentPlayer);
        if(n.getNbCanons()+n.getNbPirates()<=0) {
            n.ajouterPirate(new Pirate(1));
            n.ajouterPirate(new Pirate(2));
            n.ajouterPirate(new Pirate(5));

            n.ajouterCanon(new Canon(4));
            n.ajouterCanon(new Canon(0));
        }
        ///
        ///
        //fin de test
        //test Attaquer ajout des pirates / canons
        ////
        ////
        if(this.getModel().getListJoueurs().size()>=2) {
            currentPlayer = 1;

            n = this.getModel().getListJoueurs().get(currentPlayer);
            if (n.getNbCanons() + n.getNbPirates() <= 0) {
                n.ajouterPirate(new Pirate(1));
                n.ajouterCanon(new Canon(2));
                n.ajouterPirate(new Pirate(5));
                n.ajouterCanon(new Canon(3));
                n.ajouterCanon(new Canon(4));
                n.ajouterCanon(new Canon(0));
            }
        }
        ///
        ///
        //fin de test

        currentPlayer = 0;
        view = new VuePlateau(this);
        currentPlayerStage = 1;

        framePrincipal.changeView(view);
        addListenersToModel();
    }

  //les autres


    /**
     * A Method that adds listeners to the model
     */
    private void addListenersToModel() {
        model.getListJoueurs().get(currentPlayer).addNavirePositionListener((INavirePositionListener)this.view);
    }



    //Notifications de modification sur le model
    public void notifyAddJoueur(String nameJoueur, ENavireColor couleurJoueur){
        model.getListJoueurs().add(new Navire(nameJoueur,couleurJoueur));
    }

    public void nextPlayer(){
        this.currentPlayer++;
        this.currentPlayer = (this.currentPlayer % (getModel().getListJoueurs().size()));
    }

    /**
     * Methode qui permet de passer au stage suivant et appelle le prochain player si on est déja au  stage 2
     */
    @Override
    public void nextStage(){
        if (this.currentPlayerStage == 2){//Si on est au stage 2
            this.currentPlayerStage = 1;//on reset la valeur à stage1
            nextPlayer();//on change de joueur
        }
       else if (this.currentPlayerStage == 1){//Si on est au stage 1
            this.currentPlayerStage = 2;//on passe au stage 2
        }
    }

    public void doStartGame(){
        this.controllerPrincipal.doStartGame();
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public int getCurrentPlayerStage() {
        return currentPlayerStage;
    }

    @Override
    public void notifyPlayerMoved(int x, int y) {
        Point p = new Point(HexMech.pxtoHex(x, y));
        Navire n=model.getListJoueurs().get(currentPlayer);
        Set<Point> deplacements = new HashSet<Point>();
        Set<Point> deplacementsTransformes = new HashSet<Point>();
        deplacements=getModel().deplacementPossible(n);
        for(Point pt : deplacements)
        {

            deplacementsTransformes.add(HexMech.getNormalCoordinate(pt));
        }
        if(deplacementsTransformes.contains(p))
        {
            n.setCoordonnees(p);
            nextStage();
        }

    }

    @Override
    public void doStartRepair() {
        this.controllerPrincipal.doStartRepair();
    }

    @Override
    public void ajouterPirateRepair() {
    }

    @Override
    public void ajouterCanonRepair() {
    }

    @Override
    public void supprimerCanonRepair() {
    }

    @Override
    public void supprimerPirateRepair() {
    }


    @Override
    public void doStartPlateau() {
    }


    public void setCurrentPlayerStage(int currentPlayerStage) {
        this.currentPlayerStage = currentPlayerStage;
    }

    @Override
    public void initController(Plateau model, FramePrincipal f, ControllerPrincipal controllerPrincipal) {
        this.model = model;
        this.framePrincipal = f;
        this.controllerPrincipal = controllerPrincipal;
    }

    @Override
    public Plateau getModel() {
        return model;
    }
    public void setView(JPanel view) {
        this.view = view;
    }

    @Override
    public void doStartAttaquer() {
        //todo selection du navire à attaquer

        if(model.getListJoueurs().size()>=2) {
            navireSelectedAttack=model.getListJoueurs().get(1);
            this.controllerPrincipal.doStartAttaquer();
        }
        else{System.out.print("pas assez de joueur");}
    }

    public Navire getNavireSelectedAttack() {
        return navireSelectedAttack;
    }

    @Override
    public void notifyActionAttaquer() {

    }

    public void setDeplacementAutoriseTrue() {
        this.deplacementAutorise = true;
    }
    public boolean isDeplacementAutorise() {
        return deplacementAutorise;
    }

}
