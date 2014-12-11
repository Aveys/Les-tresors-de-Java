package com.tresors.vue;

import com.tresors.model.ENavireColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Nicolas Sagon on 11/12/2014.
 */
public class VueMenu extends JPanel{

    JLabel labelNbjoueur;
    int nbJoueur = 0;
    JTextField nameJoueur;
    JButton buttonAddJoueur;

    public VueMenu() {

        this.setLayout(new GridLayout(0, 3));
        labelNbjoueur = new JLabel(nbJoueur + " joueur");
        buttonAddJoueur = new JButton("Ajouter un joueur");

        nameJoueur = new JTextField();

        this.add(labelNbjoueur);
        this.add(nameJoueur);
        this.add(buttonAddJoueur);

        buttonAddJoueur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel labelJoueurAdd = new JLabel(getNameJoueur().getText() + ", Couleur : " + getStringCouleur());
                setNbJoueur(getNbJoueur() + 1);
                getLabelNbjoueur().setText(getNbJoueur() + "joueur");
                addComponent(labelJoueurAdd);
                if(getNbJoueur() == 6) {
                    getButtonAddJoueur().setEnabled(false);
                }
            }
        });

    }

    public String getStringCouleur() {

        String couleur = "";
        switch(nbJoueur){
            case 0:
                couleur = ENavireColor.Blanc.getStringCouleur();
                break;
            case 1:
                couleur = ENavireColor.Bleu.getStringCouleur();
                break;
            case 2:
                couleur = ENavireColor.Jaune.getStringCouleur();
                break;
            case 3:
                couleur = ENavireColor.Orange.getStringCouleur();
                break;
            case 4:
                couleur = ENavireColor.Rouge.getStringCouleur();
                break;
            case 5:
                couleur = ENavireColor.Violet.getStringCouleur();
                break;
        }
        return couleur;
    }

    public void addComponent(Component c) {
        this.add(c);
    }

    public int getNbJoueur() {
        return nbJoueur;
    }

    public void setNbJoueur(int nbJoueur) {
        this.nbJoueur = nbJoueur;
    }

    public JTextField getNameJoueur() {
        return nameJoueur;
    }

    public void setNameJoueur(JTextField nameJoueur) {
        this.nameJoueur = nameJoueur;
    }

    public JButton getButtonAddJoueur() {
        return buttonAddJoueur;
    }

    public void setButtonAddJoueur(JButton buttonAddJoueur) {
        this.buttonAddJoueur = buttonAddJoueur;
    }

    public JLabel getLabelNbjoueur() {
        return labelNbjoueur;
    }

    public void setLabelNbjoueur(JLabel labelNbjoueur) {
        this.labelNbjoueur = labelNbjoueur;
    }
}

