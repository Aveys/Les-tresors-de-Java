package com.tresors.controller;

import com.tresors.model.ENavireColor;
import com.tresors.model.Navire;
import com.tresors.model.Plateau;
import com.tresors.vue.FramePrincipal;
import com.tresors.vue.VuePlateau;

import javax.swing.*;

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
    private int currentPlayer;//valeur de l'index du joueur actuel
    private boolean currentPlayerStage; //Variable indiquant à quel tour en est le joueur. Conditionne les actions possibles, tour 1 on peux attaquer ou se déplacer, tour 2 on peut attaquer ou réparer

    public ControllerPlateau(Plateau model, FramePrincipal f, ControllerPrincipal controllerPrincipal) {
        initController(model,f,controllerPrincipal);
        view = new VuePlateau(this);
        framePrincipal.changeView(view);
        addListenersToModel();
    }

    /**
     * A Method that adds listeners to the model
     */
    private void addListenersToModel() {
        //model.addRepairCanonListener(view);
        //model.addRepairPirateListener(view);
    }

    //Notifications de modification sur le model
    public void notifyAddJoueur(String nameJoueur, ENavireColor couleurJoueur){
        model.getListJoueurs().add(new Navire(nameJoueur,couleurJoueur));
    }

    public void nextPlayer(){
        this.currentPlayer++;
        this.currentPlayer %= (getModel().getListJoueurs().size());
    }

    /**
     * Methode qui permet de passer au stage suivant et appelle le prochain player si on est déja au  stage 2
     */
    public void nextStage(){
        //Booleen à deux états, true = stage2; false = stage1
        if (this.currentPlayerStage){//Si on est au stage 2
            this.currentPlayerStage = false;//on reset la valeur à stage1
            nextPlayer();//on change de joueur
        }
       else if (this.currentPlayerStage == false){//Si on est au stage 1
            this.currentPlayerStage = true;//on passe au stage 2
        }
    }

    public void notifyCommencerPartie(){
        this.controllerPrincipal.notifyCommencerPartie();
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

}
