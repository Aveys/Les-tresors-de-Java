package com.tresors.vue;

import java.awt.*;

/**
 * Created by arthurveys on 09/12/14.
 */
public class HexMech {
    public final static boolean orFLAT= true;
    public static boolean XYVertex=false;	//true: x,y are the co-ords of the first vertex.
    //false: x,y are the co-ords of the top left rect. co-ord.    ZDZ

    private static int BORDERS=100;	//default number of pixels for the border.

    private static int s=0;	// length of one side
    private static int t=0;	// short side of 30o triangle outside of each hex
    private static int r=0;	// radius of inscribed circle (centre to middle of each side). r= h/2
    private static int h=0;	// height. Distance between centres of two adjacent hexes. Distance between two opposite sides in a hex.

    public static void setXYasVertex(boolean b) {
        XYVertex=b;
    }
    public static void setBorders(int b){
        BORDERS=b;
    }

    /** This functions takes the Side length in pixels and uses that as the basic dimension of the hex.
     It calculates all other needed constants from this dimension.
     */
    public static void setSide(int side) {
        s=side;
        t =  (int) (s / 2);			//t = s sin(30) = (int) CalculateH(s);
        r =  (int) (s * 0.8660254037844);	//r = s cos(30) = (int) CalculateR(s);
        h=2*r;
    }
    public static void setHeight(int height) {
        h = height;			// h = basic dimension: height (distance between two adj centresr aka size)
        r = h/2;			// r = radius of inscribed circle
        s = (int) (h / 1.73205);	// s = (h/2)/cos(30)= (h/2) / (sqrt(3)/2) = h / sqrt(3)
        t = (int) (r / 1.73205);	// t = (h/2) tan30 = (h/2) 1/sqrt(3) = h / (2 sqrt(3)) = r / sqrt(3)
    }

    public static Polygon hex (int x0, int y0) {

        int y = y0 + BORDERS;
        int x = x0 + BORDERS;
        if (s == 0  || h == 0) {
            System.out.println("ERROR: size of hex has not been set");
            return new Polygon();
        }

        int[] cx,cy;

        //I think that this XYvertex stuff is taken care of in the int x line above. Why is it here twice?
        if (XYVertex)
            cx = new int[] {x,x+s,x+s+t,x+s,x,x-t};  //this is for the top left vertex being at x,y. Which means that some of the hex is cutoff.
        else
            cx = new int[] {x+t,x+s+t,x+s+t+t,x+s+t,x+t,x};	//this is for the whole hexagon to be below and to the right of this point

        cy = new int[] {y,y,y+r,y+r+r,y+r+r,y+r};
        return new Polygon(cx,cy,6);
    }

    public static void drawHex(int i, int j, Graphics2D g2) {
        int x = (int) (h + (j*(0.75*(s*2))));
        int y = (i * h - ((h/2*j)));
        Polygon poly = hex(x,y);
        g2.setColor(Color.BLUE);
        g2.setColor(Color.ORANGE);
        g2.drawString(i+","+j,x+BORDERS+s,y+BORDERS+h/2);
        g2.drawPolygon(poly);
    }
    public static void drawHex(int i,int j,char type,Graphics2D g2){
        int x = (int) (h + (j*(0.75*(s*2))));
        int y = (i * h - ((h/2*j)));
        Polygon poly = hex(x,y);
        g2.setColor(Color.black);
        g2.drawString(type + ": " + i + "," + j, x + BORDERS + s / 2, y + BORDERS + h / 2);
       switch(type){
           case 'M':
               g2.setColor(Color.BLUE);
               g2.drawPolygon(poly);
               g2.fillPolygon(poly);
               break;
           case 'P':
               g2.setColor(Color.LIGHT_GRAY);
               g2.drawPolygon(poly);
               g2.fillPolygon(poly);
               break;
           case 'R':
               g2.setColor(Color.ORANGE);
               g2.drawPolygon(poly);
               g2.fillPolygon(poly);
       }
    }
}
