package com.tresors.controller;

/**
 * Created by arthurveys on 21/11/14.
 * Projet java ${PROJECT}
 */
public class ControllerJeu{
    private Case grille[][];

    public void initGrille(){
        for (int i = 0; i< 9 ; i++){
            for (int j = 0 ; j < 9 ; j++){
                this.grille[i][j] = new Case(i,j);
            }
        }
    }

    public void afficheGrille(){
        for (int i = 0; i< 9 ; i++){
            for (int j = 0 ; j < 9 ; j++){
                System.out.println(grille[i][j].toString());
            }
        }
    }

}
