package com.tresors.vue;

import com.tresors.model.Case;
import com.tresors.model.Plateau;

import javax.swing.*;
import java.awt.*;

/**
 * Created by arthurveys on 09/12/14.
 */
public class HexGame extends JPanel{
    final static int BSIZE = 10; //board size.Z
    final static int HEXSIZE = 400;	//hex size in pixels
    final static int BORDERS = 5;
    final static int SCRSIZE = HEXSIZE * (BSIZE + 1) + BORDERS*3; //screen size (vertical dimension).
    private final Case[][] plateau;

    public HexGame(Case[][] plateau) {
        this.plateau=plateau;
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        g2.setBackground(Color.DARK_GRAY);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        super.paintComponent(g2);
        //draw grid
        for (int i=0;i<9;i++) {
            for (int j=0;j<9;j++) {
                Case tmp = plateau[i][j];
                if(tmp !=null)
                    HexMech.drawHex(i,j,Case.getTypeCase(tmp),g2);
            }
        }
    }
    public static void main(String[] args){
        Plateau pl = new Plateau();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container content = frame.getContentPane();
        HexMech.setHeight(100);
        HexMech.setBorders(5);

        content.add(new HexGame(pl.getPlateau()));
        frame.setSize((int)(SCRSIZE/1.23), SCRSIZE);
        frame.setResizable(true);
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
    }

}
