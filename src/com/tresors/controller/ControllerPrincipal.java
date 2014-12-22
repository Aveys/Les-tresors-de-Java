package com.tresors.controller;

import com.tresors.model.Plateau;
import com.tresors.vue.FramePrincipal;

/**
 * Controller Principal qui appelle les autres controllers
 *  'show' affiche une vue
 *  'notify' effectue une modification du model
 *  'do' lance une action demandée par la vue et gérée par le controller directement
 *  'fire' lance une modification de la vue depuis la modification du model
 *
 * Created by Paul on 13/12/2014.
 */
public class ControllerPrincipal {
    private Controller activeController;
    private FramePrincipal frame;
    private Plateau model;

    public ControllerPrincipal(){
        frame = new FramePrincipal();
    }

    public void showViewMenu(){
        this.model = new Plateau();
        this.activeController = new ControllerMenu(model, frame, this);
    }

    public void showViewPlateau(){
        this.activeController = new ControllerPlateau(model, frame, this);
    }

    public void doStartGame(){
        this.activeController = new ControllerPlateau(this.model, this.frame, this);
    }
}