package com.tresors.controller;

import com.tresors.model.ENavireColor;
import com.tresors.model.Navire;
import com.tresors.model.Plateau;
import com.tresors.model.Repaire;
import com.tresors.vue.FramePrincipal;

import javax.swing.*;

/**
 * Controller Principal qui appelle les autres controllers et est étendus par les autres controllers
 *  'show' affiche une vue
 *  'notify' effectue une modification du model
 *  'do' lance une action demandée par la vue et gérée par le controller directement
 *  'fire' lance une modification de la vue depuis la modification du model
 * Created by Paul on 13/12/2014.
 */
public abstract class Controller {
    public abstract void initController(Plateau model, FramePrincipal f, ControllerPrincipal controllerPrincipal);
    public abstract void notifyAddJoueur(String nameJoueur, ENavireColor couleurJoueur);
    public abstract void doStartGame();
    public abstract int getCurrentPlayer();
    public abstract Plateau getModel();
    public abstract void nextStage();
    public abstract int getCurrentPlayerStage();
    public abstract void notifyPlayerMoved(int x,int y);
    public abstract void doStartRepair();
    public abstract void doStartPlateau();

    public abstract void ajouterPirateRepair();
    public abstract void ajouterCanonRepair();
    public abstract void supprimerCanonRepair();
    public abstract void supprimerPirateRepair();
    public abstract void setView(JPanel view);
    public abstract Navire getNavireSelectedAttack();
    public abstract Repaire getRepaireSelectedAttack();
    public abstract void doStartAttaquer();
    public abstract void doStartAttaquerRepaire();
    public abstract void selectNavire(Navire name);
    public abstract void notifyActionAttaquer();
    public abstract void setDeplacementAutoriseTrue();
    public abstract boolean isDeplacementAutorise();

    public abstract void setDeplacementAutoriseFalse();

    public abstract void doRepaintBateauPanel();
}
