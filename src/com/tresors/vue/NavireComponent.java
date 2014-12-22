package com.tresors.vue;

import java.awt.*;

/**
 * Composant d'affichage Navire
 * Created by arthurveys on 19/12/14.
 */
public class NavireComponent extends Component{
    private int i;
    private int j;
    private int x;
    private int y;

    private final int size = 10;
    private Color couleur;

    public NavireComponent(int i, int j,Color couleur) {
        this.i = i;
        this.j = j;
        this.couleur = couleur;
    }

    public void deplacerNavire(int i,int j){
        this.i = i;
        this.j = j;
        this.repaint();
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        calcPosition();
        g.fillOval(this.x, this.y, this.size, this.size);
    }
    @Override
    public void repaint(){
        calcPosition();
        super.repaint(x,y,this.size,this.size);
    }
    public void calcPosition(){
        int h = HexMech.getHeight();
        int s = HexMech.getSide();
        if(h == 0 || s== 0)
            throw new ExceptionInInitializerError();
        this.x=(int) (h + (j*(0.75*(s*2))));
        this.y = (i * h - ((h/2*j)));
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }
}
