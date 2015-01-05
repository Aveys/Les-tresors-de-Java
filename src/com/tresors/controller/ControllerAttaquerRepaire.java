package com.tresors.controller;

import com.tresors.event.Repaire.IRepaireChargeListener;
import com.tresors.model.*;
import com.tresors.vue.FramePrincipal;
import com.tresors.vue.VueAttaquer;
import com.tresors.vue.VueAttaquerRepaire;
import com.tresors.vue.VuePlateau;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by aurelia on 05/01/2015.
 */
public class ControllerAttaquerRepaire extends Controller  {
    @Override
    public void doStartAttaquerRepaire() {

    }

    @Override
    public Navire getNavireSelectedAttack() {
        return null;
    }

    /*The Repair View, initialized to NULL*/
    public JPanel view = null;
    /*The Repair Model, initialized to NULL*/
    private Plateau model = null;

    private VuePlateau vuePlateau = null;
    private ControllerPrincipal controllerPrincipal;
    private FramePrincipal framePrincipal;
    private int currentPlayer;//valeur de l'index du joueur actuel commence à 1 et pas 0
    private int currentPlayerStage; //Variable indiquant à quel etape en est le joueur. Conditionne les actions possibles, etape 1 on peux attaquer ou se déplacer, etape 2 on peut attaquer ou réparer
    private Navire navireJoueurActuel;
    private Repaire repaireAttacked;

    private int stateAttaque ; //
    private static final int ATTAQUER = 0;
    private static final int RIPOSTER = 1;
    private static final int QUITTER = 2;

    private int vaincue;
    private static final int ATTGAGNANTE = 1;
    private static final int RIPPGAGNANTE = 2;

    //dostartgame
    public ControllerAttaquerRepaire(Plateau model, FramePrincipal f, ControllerPrincipal controllerPrincipal,int attacking,Repaire attackedRepaire , int currentPlayerStage, int stateAttaque) {
        initController(model,f,controllerPrincipal);

        currentPlayer = attacking;
        this.currentPlayerStage = currentPlayerStage;
        repaireAttacked=attackedRepaire;
        navireJoueurActuel=model.getListJoueurs().get(currentPlayer);
        this.stateAttaque = stateAttaque;

        view = new VueAttaquerRepaire(this);

        framePrincipal.changeView(view);
        addListenersToModel();
    }

    @Override
    public Repaire getRepaireSelectedAttack() {
        return repaireAttacked;
    }
//les autres

    /**
     * A Method that adds listeners to the model
     */
    private void addListenersToModel() {

        model.getListJoueurs().get(currentPlayer).addRepairChargeListener((com.tresors.event.navire.INavireChargeListener) this.view);
        repaireAttacked.addRepairChargeListener((IRepaireChargeListener) this.view);
    }



    //Notifications de modification sur le model
    public void notifyAddJoueur(String nameJoueur, ENavireColor couleurJoueur){
        model.getListJoueurs().add(new Navire(nameJoueur,couleurJoueur));
    }

    public Repaire getRepaireAttacked() {
        return repaireAttacked;
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
        this.controllerPrincipal.doStartPlateau(currentPlayer,currentPlayerStage);
        //currentPlayerStage=3; Stage 3 inexistant? Quelle utilité?

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

    }

    @Override
    public void selectNavire(Navire name) {

    }


    @Override
    public void notifyActionAttaquer(){
        if(stateAttaque!=2){//si on ne quitte pas
            String tabDeResult = "";
            Navire nAttaquant = this.getModel().getListJoueurs().get(this.getCurrentPlayer());
            if (stateAttaque==0){
                if (repaireAttacked.checkRepaireAttaquable()){
                    int nbCanons= nAttaquant.getNbCanons();
                    int[] tabDe = new int[nbCanons];
                    for(int i = 0; i < nbCanons; i++){
                        tabDe[i] = (int) (1 + (Math.random() * (6 - 1)));
                        repaireAttacked.supprimerEmplacement((tabDe[i]+1));
                        tabDeResult += Integer.toString(tabDe[i]) + ", ";
                    }
                    if (!repaireAttacked.checkRepaireAttaquable()){
                        vaincue = ATTGAGNANTE;
                    }
                    stateAttaque = 1;// change l'etat
                }
                else{
                    vaincue = ATTGAGNANTE;
                    stateAttaque = 2;
                }
                this.controllerPrincipal.doStartAttaqueRepaire(currentPlayer, repaireAttacked, currentPlayerStage, stateAttaque);
            }
            else{// alors etat riposter
                //navire n = this.getModel().getListJoueurs().get(this.getCurrentPlayer());
                int nbCanons=repaireAttacked.getNbCanons();
                int[] tabDe = new int[nbCanons];
                for(int i = 0; i < nbCanons; i++){
                    tabDe[i] = (int) (1 + (Math.random() * (6 - 1)));
                    nAttaquant.supprimerChargeAt(tabDe[i]);
                    tabDeResult += Integer.toString(tabDe[i]+1) + ", ";//+1 car commence emplacement a 0
                }
                stateAttaque = 2;
                if (!nAttaquant.checkConfigurationNavire()){
                    vaincue = RIPPGAGNANTE;
                }
                this.controllerPrincipal.doStartAttaqueRepaire(currentPlayer, repaireAttacked, currentPlayerStage, 2);
            }

            //tabDeResult = tabDeResult.substring(0, tabDeResult.lastIndexOf(',') - 1);
            JOptionPane.showMessageDialog(view.getParent(), "Résultat des dés:   " + tabDeResult);
            if(vaincue!=ATTAQUER){
                //TODO implementer pillage
                JOptionPane.showMessageDialog(view.getParent(), "Pille   :" );
            }
        }
        else{// state quitter -> fermer panel
            nextStage();
            this.controllerPrincipal.doStartPlateau(currentPlayer, currentPlayerStage);
            //currentPlayerStage=3; state 3 inexistant

        }

    }

    @Override
    public void setDeplacementAutoriseTrue() {

    }

    @Override
    public boolean isDeplacementAutorise() {
        return false;
    }

    @Override
    public void setDeplacementAutoriseFalse() {

    }

    @Override
    public void doRepaintBateauPanel() {

    }


    public int getStateAttaque() {
        return stateAttaque;
    }
}
