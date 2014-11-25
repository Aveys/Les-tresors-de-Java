package com.tresors.controller;

import com.tresors.model.Case;
import com.tresors.model.Mer;
import com.tresors.model.Port;
import com.tresors.model.Repaire;

/**
 * Created by arthurveys on 21/11/14.
 * Projet java ${PROJECT}
 */
public class ControllerJeu{
    /*
    Type de Cases :
    1. Non affiché (terre)
    2. Port
    3. Mer
    4. Repaire
     */
    private int grilleRef[][] = {   {1,1,1,1,1,1,1,1,1},  //1
                                    {2,2,5,1,1,1,1,1,1},  //2
                                    {3,3,3,3,4,1,1,1,1},  //3
                                    {3,3,3,3,3,3,4,1,1},  //4
                                    {4,1,3,3,3,3,3,3,1},  //5
                                    {1,1,4,3,4,3,4,3,4},  //6
                                    {1,1,1,3,3,3,3,3,3},  //7
                                    {1,1,1,1,1,4,3,3,4},  //8
                                    {1,1,1,1,1,1,1,4,1}}; //9
    private Case grille[][];

    public void initGrille(){
        for (int i = 0; i< 9 ; i++){
            for (int j = 0 ; j < 9 ; j++){
                if( this.grilleRef[i][j] == 1)
                    this.grille[i][j] = null;
                if( this.grilleRef[i][j] == 2)
                    this.grille[i][j] = new Port();
                if( this.grilleRef[i][j] == 3)
                    this.grille[i][j] = new Mer();
                if( this.grilleRef[i][j] == 2)
                    this.grille[i][j] = new Repaire();
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
