package com.tresors.controller;

import com.tresors.model.ENavireColor;
import com.tresors.model.Plateau;
import com.tresors.vue.FramePrincipal;

/**
 * Controller Principal qui appelle les autres controllers et est étendus par les autres controllers
 * Created by Paul on 13/12/2014.
 */
public abstract class Controller {
    public abstract void initController(Plateau model, FramePrincipal f, ControllerPrincipal controllerPrincipal);
    public abstract void notifyAddJoueur(String nameJoueur, ENavireColor couleurJoueur);
    public abstract void notifyCommencerPartie();
    public abstract Plateau getModel();
}
