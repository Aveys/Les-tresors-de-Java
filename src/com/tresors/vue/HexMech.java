package com.tresors.vue;

import com.tresors.model.Case;

import java.awt.*;

/**
 *
 * Classe librairie de dessin d'hexagons
 * Created by arthurveys on 09/12/14.
 */
public class HexMech {
    public static boolean XYVertex=false;	//true: x,y are the co-ords of the first vertex.
    //false: x,y are the co-ords of the top left rect. co-ord.    ZDZ

    private static int BORDERS=40;	//default number of pixels for the border.

    private static int s=0;	// length of one side
    private static int t=0;	// short side of 30o triangle outside of each hex
    private static int r=0;	// radius of inscribed circle (centre to middle of each side). r= h/2
    private static int h=0;	// height. Distance between centres of two adjacent hexes. Distance between two opposite sides in a hex.

    public static void setBorders(int b){
        BORDERS=b;
    }
    public static int getSide(){return s;}
    public static int getRadius(){return r;}
    public static int getHeight(){return h;}

    /**
     * Calcul des données necessaire au dessin des hexagons
     * @param height la taille des hexagons
     */
    public static void setHeight(int height) {
        h = height;			// h = basic dimension: height (distance between two adj center aka size)
        r = h/2;			// r = radius of inscribed circle
        s = (int) (h / 1.73205);	// s = (h/2)/cos(30)= (h/2) / (sqrt(3)/2) = h / sqrt(3)
        t = (int) (r / 1.73205);	// t = (h/2) tan30 = (h/2) 1/sqrt(3) = h / (2 sqrt(3)) = r / sqrt(3)
    }

    /**
     * Crée un hexagon (Collection de point d'un objet shape)
     * @param x0 Coordonnées x du centre
     * @param y0 Coordonnées y du centre
     * @return un objet hexagon
     */
    public static Polygon hex (int x0, int y0) {

        int y = y0 + BORDERS;
        int x = x0 - BORDERS;
        if (s == 0  || h == 0) {
            System.out.println("ERROR: size of hex has not been set");
            throw new ExceptionInInitializerError();
        }

        int[] cx,cy;

        if (XYVertex)
            cx = new int[] {x,x+s,x+s+t,x+s,x,x-t};  //this is for the top left vertex being at x,y. Which means that some of the hex is cutoff.
        else
            cx = new int[] {x+t,x+s+t,x+s+t+t,x+s+t,x+t,x};	//this is for the whole hexagon to be below and to the right of this point

        cy = new int[] {y,y,y+r,y+r+r,y+r+r,y+r};
        return new Polygon(cx,cy,6);
    }

    /**
     * Dessine un Hexagon avec une position i,j dans le tableau de stockage (coordonnées axiale).
     * @param i La position i dans le tableau (ligne)
     * @param j la position J dans le tableau (colonne)
     * @param type Le type de la case (M,P,R)
     * @param g2 L'objet graphique de dessin
     */
    public static void drawHex(int i,int j,char type,Graphics2D g2){
        int y = (i * h - ((h/2*j))); //complexe (en gros : On prend la hauteur de la colonne 0 (la plus basse) et on soustrait la taille d'un hexagon * le nombre de colonnes
        int x = (int) (h + (j*(0.75*(s*2))));// trés complexe (cf redblobgames)
        Polygon poly = hex(x,y);//on dessine l'hexagon avec les coordonéees calculées
        g2.setColor(Color.DARK_GRAY);
        g2.setStroke(new BasicStroke(1.5f));
        g2.drawPolygon(poly);
        switch(type){
            case 'M':
                g2.setColor(Color.BLUE);//bleu pour la mer
                //g2.drawPolygon(poly);//on dessine l'hexagon
                g2.fillPolygon(poly);//on le rempli
                break;
            case 'P':
                g2.setColor(Color.LIGHT_GRAY);// gris pour port
                //g2.drawPolygon(poly);
                g2.fillPolygon(poly);
                break;
            case 'R':
                g2.setColor(Color.ORANGE);//Orange (clair) pour le repaire
                //g2.drawPolygon(poly);
                g2.fillPolygon(poly);
        }
        //g2.setColor(Color.WHITE);//Texte en blanc DEBUG
        //g2.drawString(type + ": " + i + "," + j, x + BORDERS + s / 2, y + BORDERS + h / 2);// STRING DEBUG
    }

    /**
     * Dessine et rempli un hexagon d'une couleur donné en parametre
     * @param i la position en i sur le tableau
     * @param j la position en j sur le tableau
     * @param g2 L'objet graphique de dessin
     * @param color La couleur
     */
    public static void drawHex(int i,int j,Graphics2D g2,Color color){
        int y = (i * h - ((h/2*j))); //complexe (en gros : On prend la hauteur de la colonne 0 (la plus basse) et on soustrait la taille d'un hexagon * le nombre de colonnes
        int x = (int) (h + (j*(0.75*(s*2))));// trés complexe (cf redblobgames)
        Polygon poly = hex(x,y);
        g2.setColor(color);
        g2.drawPolygon(poly);
    }
    //This function changes pixel location from a mouse click to a hex grid location
    /*****************************************************************************
     * Name: pxtoHex (pixel to hex)
     * Parameters: mx, my. These are the co-ordinates of mouse click.
     * Returns: point. A point containing the coordinates of the hex that is clicked in.
     If the point clicked is not a valid hex (ie. on the borders of the board, (-1,-1) is returned.
     * Function: This only works for hexes in the FLAT orientation. The POINTY orientation would require
     a whole other function (different math).
     It takes into account the size of borders.
     It also works with XYVertex being True or False.
     *****************************************************************************/

    public static Point pxtoHex(int mx, int my) {
        Point p = new Point(-1,-1);

        //correction for BORDERS and XYVertex
        System.out.println(mx);
        mx-=BORDERS+21;
        my -= BORDERS;
        if (XYVertex) mx += t;
        int x = (int) ((mx) / (s+t)); //this gives a quick value for x. It works only on odd cols and doesn't handle the triangle sections. It assumes that the hexagon is a rectangle with width s+t (=1.5*s).
        int y = (int) ((my - (x%2)*r)/h); //this gives the row easily. It needs to be offset by h/2 (=r)if it is in an even column

        /******FIX for clicking in the triangle spaces (on the left side only)*******/
        //dx,dy are the number of pixels from the hex boundary. (ie. relative to the hex clicked in)
        int dx = mx - x*(s+t);
        int dy = my - y*h;

        if (my - (x%2)*r < 0) return p; // prevent clicking in the open halfhexes at the top of the screen

        //System.out.println("dx=" + dx + " dy=" + dy + "  > " + dx*r/t + " <");

        //even columns
        if (x%2==0) {
            if (dy > r) {
            	//bottom half of hexes

                if (dx * r /t < dy - r) {
                    x--;
                }
            }
            if (dy < r) {	//top half of hexes

                if ((t - dx)*r/t > dy ) {
                    x--;
                    y--;
                }
            }
        } else {  // odd columns
            if (dy > h) {	//bottom half of hexe
                        if ((dx) * r/t < dy - h) {

                    x--;
                    y++;
                }
            }
            if (dy< h) {	//top half of hexes
             //System.out.println("" + (t- dx)*r/t +  " " + (dy - r));
                if ((t - dx)*r/t > dy - r) {
                    x--;
                }
            }
        }
        if(x%2==1)y++;

        p.x=y;
        p.y=x;
        return p;
    }

    /**
     * donne la position en pixel d'un hexagon dans la grille
     * @param i la ligne de l'hexagon
     * @param j la colonne de l'hexagon
     * @return le point de coordonnées en pixel
     */
    public static Point hexToPx(int i,int j){
        int x = (int) (r * 3/2 * j);
        int y = (int) ((r * Math.sqrt(3) * (i + 0.5 * (j&1))));
        System.out.println("[DEBUG] Coordonnées de l'hexagon en "+i+","+j+":"+x+","+y);
        return new Point(x,y);
    }
    public static Point hexToPx(Point p) {
        return hexToPx(p.x,p.y);
    }
    /**
     * Hommage à notre chef de projet
     * Renvoi la case selon le systéme de coordonnées voulues par Paul
     * @param i la ligne voulue
     * @param j la colonne voulue
     * @return la bonne case selon Paul
     */
    public Point getPaulCoordinate(int i, int j){
        if (j==2 || j==3)
            return new Point(i,j-1);
        else if (j==4||j==5)
            return new Point(i,j-2);
        else if (j==6||j==7)
            return new Point(i,j-3);
        else if (j==8)
            return new Point(i,j-4);
        else
            return new Point(i,j);
    }
    public Point getPaulCoordinate(Point p){
        return getPaulCoordinate(p.x,p.y);
    }

    /**
     * renvoi les coodonnées comme stocké dans le tableau à partir des coordonnées voulues par Paul
     * @param i la ligne voulue
     * @param j la colonne voulue
     * @return la case avec les coordonnées normale
     */
    public Point getNormalCoordinate(int i, int j){
        if (j==2 || j==3)
            return new Point(i,j+1);
        else if (j==4||j==5)
            return new Point(i,j+2);
        else if (j==6||j==7)
            return new Point(i,j+3);
        else if (j==8)
            return new Point(i,j+4);
        else
            return new Point(i,j);
    }
    public Point getNormalCoordinate(Point p){
        return getNormalCoordinate(p.x,p.y);
    }
}