package com.tresors.model;

import javafx.geometry.Point3D;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe Navire
 * Classe modele pour un joueur (Un Navire = Un joueur)
 */
public class Navire {

    private String name;
    private Color color;
    private int score;
    private Point3D coordonnées;
    private List<Charge> emplacement;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        if(score <0)
            System.out.println("Le score ne peut pas être negatif (DEBUG : implementer une exception");
        else
            this.score = score;
    }

    public Point3D getCoordonnées() {
        return coordonnées;
    }

    public void setCoordonnées(Point3D coordonnées) {
        this.coordonnées = coordonnées;
    }

    public Navire(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    /**
     * Determine si l'emplacement est vide ou contient un object
     * @param pos
     * @return false si l'emplacement est déja pris
     */
    private boolean isEmplacementEmpty(int pos){
        return emplacement.get(pos) == null;
    }

    /**
     * Retourne la charge à l'emplacement
     * @param pos position de l'emplacement
     * @return la charge à l'emplacement. NULL si l'emplacement est vide.
     */
    private Charge getEmplacement(int pos){
        return emplacement.get(pos);
    }

    /**
     * Vérification si le beateau a encore un pirate et un canon
     * @return true si le navire est bon, false sinon.
     */
    private boolean checkConfigurationNavire(){
        boolean checkPirate=false;
        boolean checkCanon=false;
        for(Charge c: this.emplacement){
            if(c instanceof Pirate)
                checkPirate=true;
            if (c instanceof Canon)
                checkCanon=true;
        }
        return checkCanon&&checkPirate;
    }

    /**
     * Verifie si le bateau est pillable
     * @return true si le bateau ets pillable, false si il ne l'est pas
     */
    private boolean estPillable(){
        if(checkConfigurationNavire()){
            boolean checkTresor=false;
            for (Charge c : emplacement){
                if(c instanceof Tresor)
                    return true;
            }
        }
        else
            return false;
    }
    private int faireDegats(ArrayList<Integer> list){
        int totalDetruis=0;
        for(int a : list){
            Charge tmp = emplacement.get(a);
            if(tmp!=null){

            }


        }
    }
}
