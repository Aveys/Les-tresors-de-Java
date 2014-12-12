package com.tresors.model;

import java.awt.*;

public enum ENavireColor {
    Bleu,
    Orange,
    Violet,
    Jaune,
    Rouge,
    Blanc;

    public Color getCouleur(){

        Color tmp;
        switch (this){
            case Bleu :
                tmp = Color.BLUE;
                break;

            case Orange :
                tmp = Color.ORANGE;
                break;

            case Violet :
                tmp = Color.MAGENTA;
                break;

            case Jaune :
                tmp = Color.YELLOW;
                break;

            case Rouge :
                tmp = Color.RED;
                break;

            case Blanc :
                tmp = Color.WHITE;
                break;
            default:
                tmp = Color.WHITE;
        }
        return tmp;
    }

    public String getUrlImage() {
        String url = "";

        switch(this) {
            case Bleu:
                url = "res/images/bleu.png";
                break;

            case Orange:
                url = "res/images/orange.png";
                break;

            case Violet:
                url = "res/images/violet.png";
                break;

            case Jaune:
                url = "res/images/jaune.png";
                break;

            case Rouge:
                url = "res/images/rouge.png";
                break;

            case Blanc:
                url = "res/images/blanc.png";
                break;
        }
        return url;
    }

    public String getStringCouleur() {
        String couleur = "";

        switch(this) {
            case Bleu:
                couleur = "bleu";
                break;

            case Orange:
                couleur = "orange";
                break;

            case Violet:
                couleur = "violet";
                break;

            case Jaune:
                couleur = "jaune";
                break;

            case Rouge:
                couleur = "rouge";
                break;

            case Blanc:
                couleur = "blanc";
                break;
        }
        return couleur;
    }
}
