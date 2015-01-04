package com.tresors.controller;

import com.tresors.model.Case;
import com.tresors.model.Repaire;
import sun.plugin.javascript.navig.Array;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by arthurveys on 25/11/14.
 */
public class HexToolbox {
//TODO est-ce que ces fonction ne vont pas dans plateau?

    public static ArrayList<Repaire> templateRepaire;
    /**
     * Donne les coordonnées des cases voisines
     * @param source Les coordonnées de départ
     * @return Un tableau de point avec les coordonnées des voisins
     */
    public static ArrayList<Point> getVoisins(Point source){
        ArrayList<Point> res = new ArrayList<Point>();
        ArrayList<Point> neighbors = new ArrayList<Point>(Arrays.asList(new Point((source.x + 1), (source.y + 0)), new Point((source.x + 1), (source.y + 1)), new Point((source.x + 0), (source.y + 1)), new Point((source.x - 1), (source.y + 0)), new Point((source.x + 0), (source.y - 1)), new Point((source.x + 1), (source.y - 1))));
        for(Point p :neighbors){
            if(!((p.x<0||p.x>8)||(p.y<0||p.y>5))){
                res.add(p);
            }
        }
        return res;

    }

    /**
     * Donne la distance absolue entre les deux centres des hexagones
     * @param hex1 L'hexagone source
     * @param hex2 L'hexagone de destination
     * @return La distance absolue entre deux
     */
    //TODO quesque la distance absolue? c'est pas le nombre de case minimum en tous cas. Passe pas test
    public static int distanceHex(Point hex1, Point hex2){
        return ((Math.abs(hex1.y-hex2.x)+ Math.abs(hex1.y-hex2.y))+Math.abs(hex1.x+hex1.y-hex2.x-hex2.y))/2;
    }

    /**
     * Verifie si la case est navigable
     * @param plateau Le plateau de jeu
     * @param p la case à vérifier
     * @return True si la case est navigable, false sinon
     */
    //TODO prendre en compte la sortie de port pour la fonction de deplassement Plateau.caseSurLequelJePeuAller()
    public static boolean estNavigable(Case[][] plateau, Point p) {
        Case c = plateau[p.x][p.y];
        return !(c instanceof Repaire) && c != null;
    }

}
