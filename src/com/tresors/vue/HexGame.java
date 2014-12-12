package com.tresors.vue;

import javax.swing.*;
import java.awt.*;

/**
 * Created by arthurveys on 09/12/14.
 */
public class HexGame extends JPanel{
    final static int EMPTY = 0;
    final static int BSIZE = 10; //board size.Z
    final static int HEXSIZE = 200;	//hex size in pixels
    final static int BORDERS = 5;
    final static int SCRSIZE = HEXSIZE * (BSIZE + 1) + BORDERS*3; //screen size (vertical dimension).
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        super.paintComponent(g2);
        //draw grid
        for (int i=0;i<BSIZE;i++) {
            for (int j=0;j<5;j++) {
                HexMech.drawHex(i,j,g2);
            }
        }
        /*//fill in hexes
        for (int i=0;i<BSIZE;i++) {
            for (int j=0;j<BSIZE;j++) {
                //if (board[i][j] < 0) hexmech.fillHex(i,j,COLOURONE,-board[i][j],g2);
                //if (board[i][j] > 0) hexmech.fillHex(i,j,COLOURTWO, board[i][j],g2);
                hexmech.fillHex(i,j,board[i][j],g2);
            }
        }*/


    }
    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container content = frame.getContentPane();
        HexMech.setHeight(100);
        HexMech.setBorders(5);
        content.add(new HexGame());
        frame.setSize((int)(SCRSIZE/1.23), SCRSIZE);
        frame.setResizable(true);
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
    }

}
