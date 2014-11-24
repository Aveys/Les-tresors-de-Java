package com.tresors.model;

import javafx.geometry.Point3D;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


public class Plateau {
    private ArrayList<Navire> listJoueurs;
    private Case[][] plateau;
    //TODO: Creer une liste de x,y de chaque repaire pour y acceder sans parcourt labourieux ???
    public Plateau(TreeMap<String,String> listJoueurs) {
        //TODO: cree la matrice de cases, l'emplacement de départ
        for (Map.Entry<String,String> e:listJoueurs.entrySet()) {
            this.listJoueurs.add(new Navire(e.getKey(), e.getValue()));
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
