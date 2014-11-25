package com.tresors.model;

import javafx.geometry.Point3D;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


public class Plateau {
    /*  Type de Cases :
        1. Non affiché (terre)
        2. Port
        3. Mer
        4. Repaire  */
    private int grilleRef[][] = {   {1,1,1,1,1,1,1,1,1},  //1
            {2,2,5,1,1,1,1,1,1},  //2
            {3,3,3,3,4,1,1,1,1},  //3
            {3,3,3,3,3,3,4,1,1},  //4
            {4,1,3,3,3,3,3,3,1},  //5
            {1,1,4,3,4,3,4,3,4},  //6
            {1,1,1,3,3,3,3,3,3},  //7
            {1,1,1,1,1,4,3,3,4},  //8
            {1,1,1,1,1,1,1,4,1}}; //9

    private ArrayList<Navire> listJoueurs;
    private Case[][] plateau;
    //TODO: Creer une liste de x,y de chaque repaire pour y acceder sans parcourt labourieux ???
    public Plateau(TreeMap<String,String> listJoueurs) {
        //TODO: cree la matrice de cases, l'emplacement de départ
        for (Map.Entry<String,String> e:listJoueurs.entrySet()) {
            this.listJoueurs.add(new Navire(e.getKey(), e.getValue()));
        }
    }

    public void initGrille(){
        for (int i = 0; i< 9 ; i++){
            for (int j = 0 ; j < 9 ; j++){
                if( this.grilleRef[i][j] == 1)
                    this.plateau[i][j] = null;
                if( this.grilleRef[i][j] == 2)
                    this.plateau[i][j] = new Port();
                if( this.grilleRef[i][j] == 3)
                    this.plateau[i][j] = new Mer();
                if( this.grilleRef[i][j] == 2)
                    this.plateau[i][j] = new Repaire();
            }
        }
    }

    public void afficheGrille(){
        for (int i = 0; i< 9 ; i++){
            for (int j = 0 ; j < 9 ; j++){
                System.out.println(plateau[i][j].toString());
            }
        }
    }

    public void getVoisinsAttaquable(int x,int y,int z) throws NotImplementedException{
        //TODO: Donne une liste des repaires et Navires attaquables autour d'une position.
    }
    public void getVoisinsAttaquable(Point3D point)throws NotImplementedException{
        //TODO: Donne une liste des repaires et Navires attaquables autour d'une position. CF Methode précédente
    }

    /**
     * Retourne le type de case par rapport la coordonnée en parametre
     * @param x la position en x de la case cible
     * @param y la position en y de la case cible
     * @return M pour une case Mer, P pour une case Port, R pour une case de Repaire, 0 si la case n'est d'aucun type
     */
    public char getTypeCase(int x,int y){
        //TODO : Verifier pour le nombre de points
        Case tmp=plateau[x][y];
        if(tmp instanceof Mer)
            return 'M';
        else if(tmp instanceof Port)
            return 'P';
        else if (tmp instanceof Repaire)
            return 'R';
        else
            return '0';
    }
    /**
     * Retourne le type de case par rapport la coordonnée en parametre
     * @param point Le point source
     * @return M pour une case Mer, P pour une case Port, R pour une case de Repaire, 0 si la case n'est d'aucun type
     */
    public char getTypeCase(Point2D point){
        //TODO : Verifier pour le nombre de points
        Case tmp=plateau[(int)point.getX()][(int)point.getY()];
        if(tmp instanceof Mer)
            return 'M';
        else if(tmp instanceof Port)
            return 'P';
        else if (tmp instanceof Repaire)
            return 'R';
        else
            return '0';
    }

    public void isNoTreseasures(){
        //TODO: Verifier si il n'y a plus de trésors sur la map -> fin du jeu
    }
    //TODO : BEAUCOUP DE METHODE DE PATHFINDING
}
