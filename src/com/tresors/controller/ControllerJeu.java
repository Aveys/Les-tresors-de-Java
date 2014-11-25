package com.tresors.controller;

import com.tresors.model.*;

import java.util.TreeMap;

/**
 * Created by arthurveys on 21/11/14.
 * Projet java ${PROJECT}
 */
public class ControllerJeu{

    private TreeMap<String, String> listJoueurs = getListJoueurs();

    private Plateau plateau = new Plateau(listJoueurs);



}
