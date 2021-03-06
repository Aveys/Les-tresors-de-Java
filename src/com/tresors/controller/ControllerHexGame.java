package com.tresors.controller;

import com.tresors.model.ENavireColor;
import com.tresors.model.Navire;
import com.tresors.model.Plateau;
import com.tresors.model.Repaire;
import com.tresors.vue.FramePrincipal;
import com.tresors.vue.HexGame;
import com.tresors.vue.HexMech;

import javax.swing.*;

/**
 * Created by Nicolas Sagon on 14/12/2014.
 */
public class ControllerHexGame extends Controller {

    private Plateau model;
    private FramePrincipal framePrincipal;
    private JPanel view;
    private ControllerPrincipal controllerPrincipal;


    @Override
    public Repaire getRepaireSelectedAttack() {
        return null;
    }

    public ControllerHexGame(Plateau model, FramePrincipal frame, ControllerPrincipal controller) {
        initController(model, frame, controller);
        HexMech.setHeight(100);
        HexMech.setBorders(5);
        /*view = new HexGame(model.getPlateau(),100,model.getListJoueurs());//
        framePrincipal.changeView(view);*/
    }

    @Override
    public void initController(Plateau model, FramePrincipal frame, ControllerPrincipal controller) {
        this.model = model;
        this.framePrincipal = frame;
        this.controllerPrincipal = controller;
    }

    @Override
    public void notifyAddJoueur(String nameJoueur, ENavireColor couleurJoueur) {

    }
    @Override
    public void doStartGame() {

    }

    @Override
    public int getCurrentPlayer() {
        return 0;
    }

    @Override
    public Plateau getModel() {
        return model;
    }

    @Override
    public void nextStage() {

    }

    @Override
    public int getCurrentPlayerStage() {
        return 0;
    }



    @Override
    public void notifyPlayerMoved(int x, int y) {

    }

    @Override
    public void doStartRepair() {

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
    public void setView(JPanel view) {

    }

    @Override
    public Navire getNavireSelectedAttack() {
        return null;
    }

    @Override
    public void doStartAttaquer() {

    }

    @Override
    public void doStartAttaquerRepaire() {

    }

    @Override
    public void selectNavire(Navire name) {

    }

    @Override
    public void doStartPlateau() {

    }

    @Override
    public void notifyActionAttaquer() {

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

    @Override
    public void selectRepaire(Repaire repaireAttaquer) {

    }

    @Override
    public boolean getAttaqueRp() {
        return false;
    }

    @Override
    public void setAttaqueRp(boolean estVrai) {

    }


}
