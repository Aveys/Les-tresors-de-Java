package com.tresors.model;

import java.awt.*;

/**
 * Classe Navire
 * Classe modele pour un joueur (Un Navire = Un joueur)
 */
public class Navire {

    private String name;
    private Color color;
    private int score;
    private Point coordonnées;
    private Charge[] emplacement;

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

    public Point getCoordonnées() {
        return coordonnées;
    }

    public void setCoordonnées(Point coordonnées) {
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
        return emplacement[pos] == null;
    }
    private Charge getEmplacement(int pos){
        return emplacement[pos];
    }

}
