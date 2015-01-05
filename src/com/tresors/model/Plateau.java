package com.tresors.model;

import com.tresors.controller.HexToolbox;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Observable;
import java.util.Set;


public class Plateau extends Observable{
    /* Structure de la Carte et type des Cases
    Type de Cases :
        1. Non affiché (terre)
        2. Port
        3. Mer
        4. Repaire  */

    //Attributes
    private ArrayList<Navire> listJoueurs = new ArrayList<Navire>();
    public static ArrayList<Repaire> templateRepaire = new ArrayList<Repaire>();
    private Case[][] plateau;
    ArrayList<Repaire> listDesRepaires = new ArrayList<Repaire>();//liste des repaires

    /**
     * Constructor by default
     */
    public Plateau() {
        initRepaire();
        int grilleRef[][] = {
                {1,1,1,1,1,1,1,1,1},  //1
                {2,2,1,1,1,1,1,1,1},  //2
                {3,3,3,3,4,1,1,1,1},  //3
                {3,3,3,3,3,3,4,1,1},  //4
                {4,1,3,3,3,3,3,3,1},  //5
                {1,1,4,3,4,3,4,3,4},  //6
                {1,1,1,1,3,3,3,3,3},  //7
                {1,1,1,1,1,4,3,3,4},  //8
                {1,1,1,1,1,1,1,4,1}}; //9
        // Génération de la Carte
        this.plateau = new Case[9][9];
        for (int i = 0; i< 9 ; i++){
            for (int j = 0 ; j < 9 ; j++){
                if( grilleRef[i][j] == 1)
                    this.plateau[i][j] = null;
                if( grilleRef[i][j] == 2)
                    this.plateau[i][j] = new Port(i,j);
                if( grilleRef[i][j] == 3)
                    this.plateau[i][j] = new Mer(i,j);
                if( grilleRef[i][j] == 4){
                    Repaire repaireTemp = this.repaireAleatoire();
                    repaireTemp.setCoordonnees(new Point(i,j));
                    this.plateau[i][j] = repaireTemp;
                    listDesRepaires.add(repaireTemp);
                }
            }
        }


        /*
        WTF
        Attribution des navires pour chaque joueur
        for (Map.Entry<String,ENavireColor> e:listJoueurs.entrySet()) {
        this.listJoueurs.add(new navire(e.getKey(), e.getValue()));
        }
        */
    }

    /**
     * initialisation de la liste predefinie des repaires
     */
    public void initRepaire (){
        Canon canonP0 = new Canon(0);
        Canon canonP1 = new Canon(1);
        Canon canonP2 = new Canon(2);
        Canon canonP3 = new Canon(3);

        Pirate pirateP1 = new Pirate(1);
        Pirate pirateP2 = new Pirate(2);
        Pirate pirateP3 = new Pirate(3);
        Pirate pirateP4 = new Pirate(4);


        templateRepaire.add(new Repaire(canonP1,canonP2,pirateP3,pirateP4,null, null,3));
        templateRepaire.add(new Repaire(canonP0, canonP1, canonP2, pirateP3, pirateP4, null, 5));
        templateRepaire.add(new Repaire(canonP1, pirateP2, null, null, null, null, 2));
        templateRepaire.add(new Repaire(canonP0, canonP0,pirateP1, null, null, null, 3 ));
        templateRepaire.add(new Repaire(canonP1, canonP2, pirateP3, null, null, null,2));
        templateRepaire.add(new Repaire(canonP0, canonP1, canonP2,canonP3,pirateP4,null, 4 ));
        templateRepaire.add(new Repaire(canonP0, canonP0, canonP1,canonP2, canonP3, pirateP4, 5));
        templateRepaire.add(new Repaire(canonP0, pirateP1,pirateP2, pirateP3, null, null, 5));
        templateRepaire.add(new Repaire(canonP1, canonP2, pirateP3, pirateP4, null, null, 3));
        templateRepaire.add(new Repaire(canonP0, pirateP1, pirateP2, null, null, null, 4));
    }

    /**
     *
     * @return Repaire aleatoire
     */
    public Repaire repaireAleatoire(){
        if(templateRepaire.isEmpty())
            return null;
        int nmbAleatoir = (int) (Math.random()*templateRepaire.size());
        Repaire repaireTemp = templateRepaire.get(nmbAleatoir);
        templateRepaire.remove(nmbAleatoir);
        return repaireTemp;
    }



    public Set<Point> deplacementPossible(Point p, int nbDePirate){
        if(nbDePirate>0){
            Set<Point> listPoint=new HashSet<Point>();
            Set<Point> listTemp= new HashSet<Point>();
            listTemp.add(p);
            for (int i = 0; i <nbDePirate ; i++) {

                for (Point pt : listTemp) {
                    listPoint.addAll(HexToolbox.getVoisins(pt));
                }

                listTemp.addAll(listPoint);

                for (Point pt: listTemp){
                    if(!HexToolbox.estNavigable(this.plateau,pt)){
                        listPoint.remove(pt);

                    }
                 }

                listTemp.clear();
                listTemp.addAll(listPoint);

            }
            listPoint.remove(p);
            return listPoint;

        }
        else
            return null;
    }

    public Set<Point> deplacementPossible(Navire n){
        Point p = new Point(n.getCoordonnees());
        int nbDePirate= n.getNbPirates();
        if(nbDePirate>0){

            Set<Point> listPoint=new HashSet<Point>();
            Set<Point> listTemp= new HashSet<Point>();
            listTemp.add(p);
            for (int i = 0; i <nbDePirate ; i++) {

                for (Point pt : listTemp) {
                    listPoint.addAll(HexToolbox.getVoisins(pt));
                }

                listTemp.addAll(listPoint);

                for (Point pt: listTemp){
                    if(!HexToolbox.estNavigable(this.plateau,pt)){
                        listPoint.remove(pt);

                    }
                }

                listTemp.clear();
                listTemp.addAll(listPoint);

            }
            listPoint.remove(p);
            return listPoint;

        }
        else
            return null;
    }

    public Case getCase(Point p){

        for (Case lign[] : this.plateau){
            for (Case tmpCase : lign){
                if(tmpCase!=null) {
                if(tmpCase.getCoord() == p)return tmpCase;
                }
            }
        }
        return null;
    }

    public Case getCase(int x, int y){

        for (Case lign[] : this.plateau){
                for (Case tmpCase : lign){
                    if(tmpCase!=null) {
                        if (tmpCase.getCoord().y == y && tmpCase.getCoord().x == x)
                            return tmpCase;
                    }
                }
        }
        return null;
    }
    /**
     * Marche comme {@link #getVoisinsAttaquable(Point point)}
     */
    public ArrayList<Point> getVoisinsAttaquable(int x,int y){
        return getVoisinsAttaquable(new Point(x,y));
    }

    /**
     * Renvoi les coordonnées de toutes les cases attaquable
     * @param point le point source
     * @return la liste des points correpsondants à des hexagones attaquable
     */
     //TODO : Tester cette méthode !
    public ArrayList<Point> getVoisinsAttaquable(Point point){
        ArrayList<Point> attaquable = new ArrayList<Point>();
        ArrayList<Point> voisins = HexToolbox.getVoisins(point);
        voisins.add(new Point(point.x,point.y));
        Case tmp;
        for (Point p :voisins){
            tmp = plateau[p.x][p.y];
            if (tmp instanceof Repaire){
                if (((Repaire) tmp).checkRepaireAttaquable())
                    attaquable.add(p);
            }

            ArrayList<Navire> listNavire = getNavire(p);
            for (Navire n : listNavire){
                if (n.checkConfigurationNavire())
                    attaquable.add(p);
            }

        }
        return attaquable;
    }

    /**
     * Retourne les Navires situé à un point particulier
     * @param p Le point à analyser
     * @return la liste des navires présent sur le point
     */
    public ArrayList<Navire> getNavire(Point p){
        ArrayList<Navire> list = new ArrayList<Navire>();
        for (Navire n:listJoueurs){
            if(n.getCoordonnees().equals(p)){
               list.add(n);
            }
        }
        return list;
    }

    /**
     * voir {@link #getNavire(Point p)}
     * @param x la position en x
     * @param y la position en y
     * @return la liste des navires présent sur le point
     */
    public ArrayList<Navire> getNavire(int x,int y){
        return getNavire(new Point(x,y));
    }


    /**
     * Retourne les Navires situé à un point particulier
     * @param p Le point à analyser
     * @return la liste des navires présent sur le point
     */
    public Repaire getRepaire(Point p){
        Repaire mRepaire = new Repaire();
        for (Repaire r: listDesRepaires){
            if(r.getCoordonnees().x == p.x && r.getCoordonnees().y==p.y){
                mRepaire = r;
            }
        }
        return mRepaire;
    }


    /**
     * voir {@link #getNavire(Point p)}
     * @param x la position en x
     * @param y la position en y
     * @return la liste des navires présent sur le point
     */
    public Repaire getRepaire(int x,int y){
        return getRepaire(new Point(x, y));
    }

    public ArrayList<Repaire> getListDesRepaires() {
        return listDesRepaires;
    }

    /**
     * Retourne le type de case par rapport la coordonnée en parametre
     * @param x la position en x de la case cible
     * @param y la position en y de la case cible
     * @return M pour une case Mer, P pour une case Port, R pour une case de Repaire, 0 si la case n'est d'aucun type
     */
    public char getTypeCase(int x,int y){
        if (x<9 && y<9){
            Case tmp=plateau[x][y];
            if(tmp instanceof Mer)
                return 'M';
            else if(tmp instanceof Port)
                return 'P';
            else if (tmp instanceof Repaire)
                return 'R';
        }

        return '0';
    }
    /**
     * Retourne le type de case par rapport la coordonnée en parametre
     * @param point Le point source
     * @return M pour une case Mer, P pour une case Port, R pour une case de Repaire, 0 si la case n'est d'aucun type
     */
    public char getTypeCase(Point2D point){
        Case tmp=plateau[(int)point.getX()][(int)point.getY()];
        if(tmp instanceof Mer)
            return 'M';
        else if(tmp instanceof Port)
            return 'P';
        else if (tmp instanceof Repaire)
            return 'R';
        else
            return '0';
    }
    public boolean isNoTreasures(){
        for (Repaire repaireTmp : this.listDesRepaires){
            if(repaireTmp.getMontantTresors()>0)
                return false;
        }
        for (Navire NavireTmp : this.listJoueurs ){
            if (NavireTmp.estPillable())
                return false;
        }
        return true;
    }

    //Getters Setters
    public ArrayList<Navire> getListJoueurs() {
        return listJoueurs;
    }
    public Case[][] getPlateau(){return plateau;}



}
