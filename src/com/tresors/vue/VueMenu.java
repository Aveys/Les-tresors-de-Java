package com.tresors.vue;

import com.tresors.controller.Controller;
import com.tresors.controller.ControllerMenu;
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
    JPanel pageStart;
    JPanel listJoueur;
    JPanel pageEnd;
    JButton commencerPartie;
    private Controller controller = null;

    public VueMenu(Controller controllerMenu) {

        this.controller = controllerMenu;
        this.setLayout(new BorderLayout());
        labelNbjoueur = new JLabel(nbJoueur + " joueur");
        buttonAddJoueur = new JButton("Ajouter un joueur");

        nameJoueur = new JTextField();
        nameJoueur.setPreferredSize(new Dimension(150, 30));

        commencerPartie = new JButton("Commencer la partie");

        pageStart = new JPanel();
        pageStart.setLayout(new FlowLayout());

        pageStart.add(labelNbjoueur);
        pageStart.add(nameJoueur);
        pageStart.add(buttonAddJoueur);

        listJoueur = new JPanel();
        listJoueur.setLayout(new GridLayout(0,3));

        pageEnd = new JPanel();
        pageEnd.setLayout(new FlowLayout());
        pageEnd.add(commencerPartie);

        this.add(pageStart, BorderLayout.PAGE_START);
        this.add(listJoueur, BorderLayout.CENTER);
        this.add(pageEnd, BorderLayout.PAGE_END);

        buttonAddJoueur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameJoueur = getNameJoueur().getText();
                ENavireColor couleurJoueur = getCouleur();
                JLabel labelJoueurAdd = new JLabel(nameJoueur + ", Couleur : " + couleurJoueur.getStringCouleur());
                setNbJoueur(getNbJoueur() + 1);
                if (nbJoueur > 1) {
                    getLabelNbjoueur().setText(getNbJoueur() + " joueurs");
                } else {
                    getLabelNbjoueur().setText(getNbJoueur() + " joueur");
                }
                addJoueur(labelJoueurAdd);
                getController().notifyAddJoueur(nameJoueur, couleurJoueur);
                if (getNbJoueur() == 6) {
                    getButtonAddJoueur().setEnabled(false);
                }
            }
        });

        commencerPartie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getController().notifyCommencerPartie();
            }
        });

    }

    public final Controller getController() {
        return controller;
    }

    public void setController(ControllerMenu controller) {
        this.controller = controller;
    }

    public ENavireColor getCouleur() {

        ENavireColor couleur;
        switch(nbJoueur){
            case 0:
                couleur = ENavireColor.Blanc;
                break;
            case 1:
                couleur = ENavireColor.Bleu;
                break;
            case 2:
                couleur = ENavireColor.Jaune;
                break;
            case 3:
                couleur = ENavireColor.Orange;
                break;
            case 4:
                couleur = ENavireColor.Rouge;
                break;
            case 5:
                couleur = ENavireColor.Violet;
                break;
            default:
                couleur = ENavireColor.Blanc;
        }
        return couleur;
    }

    public void addJoueur(Component c) {
        listJoueur.add(c);
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

