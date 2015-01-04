package com.tresors.controller;



import com.tresors.event.navire.INavireChargeListener;
import com.tresors.model.*;
import com.tresors.vue.FramePrincipal;
import com.tresors.vue.VuePlateau;
import com.tresors.vue.VueReparer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by arthurveys on 21/11/14.
 * Projet java ${PROJECT}
 */
public class ControllerReparer extends Controller {

    /*The Repair View, initialized to NULL*/
    public JPanel view = null;
    /*The Repair Model, initialized to NULL*/
    private Plateau model = null;

    private VuePlateau vuePlateau = null;
    private ControllerPrincipal controllerPrincipal;
    private FramePrincipal framePrincipal;
    private int currentPlayer;//valeur de l'index du joueur actuel commence à 1 et pas 0
    private int currentPlayerStage; //Variable indiquant à quel etape en est le joueur. Conditionne les actions possibles, etape 1 on peux attaquer ou se déplacer, etape 2 on peut attaquer ou réparer


    //dostartgame
    public ControllerReparer(Plateau model, FramePrincipal f, ControllerPrincipal controllerPrincipal) {
        initController(model,f,controllerPrincipal);


        //test reparer ajout des pirates / canons
        currentPlayer = 0;
        //fin de test
        view = new VueReparer(this);
        currentPlayerStage = 1;
        framePrincipal.changeView(view);
        addListenersToModel();
    }

    //les autres

    /**
     * A Method that adds listeners to the model
     */
    private void addListenersToModel() {

        model.getListJoueurs().get(currentPlayer).addRepairChargeListener((INavireChargeListener) this.view);
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
        model.getListJoueurs().get(currentPlayer).fireEmplacementChanged(new Point(x, y));
    }

    @Override
    public void doStartRepair() {
    }

    @Override
    public void ajouterPirateRepair() {
        Navire n =this.getModel().getListJoueurs().get(currentPlayer);
        ArrayList<Integer> positionLibre= n.getPositionLibre();
        if(positionLibre.size()>0)
            n.ajouterPirate(new Pirate(positionLibre.get(0)));
        else {
            System.out.println("action imposible");
        }
    }

    @Override
    public void ajouterCanonRepair() {
        Navire n =this.getModel().getListJoueurs().get(currentPlayer);
        ArrayList<Integer> positionLibre= n.getPositionLibre();
        if(positionLibre.size()>0)
            n.ajouterCanon(new Canon(positionLibre.get(0)));
        else {
            System.out.println("action imposible");
        }


    }

    @Override
    public void supprimerCanonRepair() {
        Navire n =this.getModel().getListJoueurs().get(currentPlayer);
        ArrayList<Integer> positionLibre= n.getPositionLibre();
        if(n.getNbCanons()>0)
            n.supprimerCanon();
        else {
            System.out.println("action imposible");
        }

    }

    @Override
    public void supprimerPirateRepair() {
        Navire n =this.getModel().getListJoueurs().get(currentPlayer);

        if(n.getNbPirates()>0)
            n.supprimerPirate();
        else {
            System.out.println("action imposible");
        }
    }


    @Override
    public void doStartPlateau() {
        this.controllerPrincipal.doStartPlateau();
        currentPlayerStage=3;

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
    public Navire getNavireSelectedAttack() {
        return null;
    }

    @Override
    public void doStartAttaquer() {

    }

    @Override
    public void notifyActionAttaquer() {

    }
}
