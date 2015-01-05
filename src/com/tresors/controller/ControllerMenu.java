package com.tresors.controller;

import com.tresors.model.ENavireColor;
import com.tresors.model.Navire;
import com.tresors.model.Plateau;
import com.tresors.vue.FramePrincipal;
import com.tresors.vue.VueMenu;
import com.tresors.vue.VuePlateau;

import javax.swing.*;

/**
 * Controller du Menu
 * Methods:
 *  'show' affiche une vue
 *  'notify' effectue une modification du model
 *  'do' lance une action demandée par la vue et gérée par le controller directement
 *  'fire' lance une modification de la vue depuis la modification du model
 *
 * Created by Nicolas Sagon on 11/12/2014.
 */
public class ControllerMenu extends Controller {

    public JPanel view = null;
    private Plateau model = null;
    private VuePlateau vuePlateau = null;
    private ControllerPrincipal controllerPrincipal;
    private FramePrincipal framePrincipal;

    public ControllerMenu(Plateau model, FramePrincipal frame, ControllerPrincipal controller) {
        initController(model,frame,controller);
        view = new VueMenu(this);
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

    public void notifyAddJoueur(String nameJoueur, ENavireColor couleurJoueur){
        model.getListJoueurs().add(new Navire(nameJoueur, couleurJoueur));
    }

    public void doStartGame(){
        this.controllerPrincipal.doStartGame();
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
    public void selectNavire(Navire name) {

    }

    @Override
    public void doStartPlateau() {

    }

    @Override
    public void initController(Plateau model, FramePrincipal frame, ControllerPrincipal controller) {
        this.model = model;
        this.framePrincipal = frame;
        this.controllerPrincipal = controller;
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


}
