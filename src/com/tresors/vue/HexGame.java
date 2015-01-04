package com.tresors.vue;

import com.tresors.controller.HexToolbox;
import com.tresors.model.Case;
import com.tresors.model.ENavireColor;
import com.tresors.model.Navire;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTableUI;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by arthurveys on 09/12/14.
 */
public class HexGame extends JPanel{
    final static int BSIZE = 10; //taille de la grille (10 en longueur)
    final static int HEXSIZE = 100;	//Taille des hexagons
    final static int BORDERS = 5;
    final static int SCRSIZE = HEXSIZE * (BSIZE + 1) + BORDERS*3; //screen size (vertical dimension).
    private final Case[][] plateau;
    private final ArrayList<Navire> navires;
    public ArrayList<NavireComponent> GraphicsNavires;
    private ArrayList<BateauAffichagePanel> listBateau;


    /**
     * Crée un panel de'hexagons
     * @param plateau Le tableau de Case
     * @param hexSize La taille des hexagons
     * @param listJoueurs
     */
    public HexGame(Case[][] plateau, int hexSize, ArrayList<Navire> listJoueurs) {
        this.plateau=plateau;
        this.navires=listJoueurs;
        HexMech.setHeight(hexSize);

        listBateau = new ArrayList<BateauAffichagePanel>();

        for(Navire n : listJoueurs)
        {
            BateauAffichagePanel tmp = new BateauAffichagePanel(n.getColor());
         //   tmp.setLocation(hexToPixel(n.getCoordonnees()));
        }

        for(BateauAffichagePanel b : listBateau){
            this.add(b);
        }

        //Pour tester : commanter les deux for et ajouter les bateau comme ceci :

        /*
            BateauAffichagePanel test1 = new BateauAffichagePanel(ENavirColor.blanc);
            test1.setLocation(150,150);
            this.add(test1);
         */

    }

    /**
     * Fonction appelée à la creation du panel et qui dessine la grille d'hexagones
     * @param g object graphique du panel (affectation auto)
     */
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;//conversion en 2D
        this.setBackground(Color.DARK_GRAY);// Background du Panel
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //Anti-Aliasing
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));// La police
        super.paintComponent(g2);
        //Dessine la grille
        for (int i=0;i<9;i++) {
            for (int j=0;j<9;j++) {
                Case tmp = plateau[i][j];// on récupére la case du plateau
                if(tmp !=null)//Si elle est null, on ne la dessine pas
                    HexMech.drawHex(i, j, Case.getTypeCase(tmp), g2);// Utilisation de la fonction de dessin de debug (texte) )
            }
        }
       // for(navire n : navires){this.GraphicsNavires.add(new NavireComponent(n));        }
    }

    public void drawCircle(Graphics cg, int xCenter, int yCenter, int r) {
        cg.fillOval(xCenter-r, yCenter-r, 2*r, 2*r);
    }//end drawCircle

    /**
     * Hommage à notre chef de projet
     * Renvoi la case selon le systéme de coordonnées voulues par Paul
     * @param i la ligne voulue
     * @param j la colonne voulue
     * @return la bonne case selon Paul
     */
    public Case GetCasePaulCoordinate(int i, int j){
        if (j==2 || j==3)
            return plateau[i][j-1];
        else if (j==4||j==5)
            return plateau[i][j-2];
        else if (j==6||j==7)
            return plateau[i][j-3];
        else if (j==8)
            return plateau[i][j-4];
        else
            return plateau[i][j];
    }
}
