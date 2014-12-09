package com.tresors.model;

import com.tresors.controller.HexToolbox;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Map;
import java.util.Observable;
import java.util.TreeMap;


public class Plateau extends Observable{
    /* Structure de la Carte et type des Cases
    Type de Cases :
        1. Non affiché (terre)
        2. Port
        3. Mer
        4. Repaire  */
    private int grilleRef[][] = {
            {1,1,1,1,1,1,1,1,1},  //1
            {2,2,5,1,1,1,1,1,1},  //2
            {3,3,3,3,4,1,1,1,1},  //3
            {3,3,3,3,3,3,4,1,1},  //4
            {4,1,3,3,3,3,3,3,1},  //5
            {1,1,4,3,4,3,4,3,4},  //6
            {1,1,1,3,3,3,3,3,3},  //7
            {1,1,1,1,1,4,3,3,4},  //8
            {1,1,1,1,1,1,1,4,1}}; //9

    private ArrayList<Navire> listJoueurs = new ArrayList<Navire>();
    public static ArrayList<Repaire> templateRepaire = new ArrayList<Repaire>();
    private Case[][] plateau;
    ArrayList<Repaire> listDesRepaires = new ArrayList<Repaire>();//liste des repaires

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


        this.templateRepaire.add(new Repaire(canonP1,canonP2,pirateP3,pirateP4,null, null,3));
        this.templateRepaire.add(new Repaire(canonP0, canonP1, canonP2, pirateP3, pirateP4, null, 5));
        this.templateRepaire.add(new Repaire(canonP1, pirateP2, null, null, null, null, 2));
        this.templateRepaire.add(new Repaire(canonP0, canonP0,pirateP1, null, null, null, 3 ));
        this.templateRepaire.add(new Repaire(canonP1, canonP2, pirateP3, null, null, null,2));
        this.templateRepaire.add(new Repaire(canonP0, canonP1, canonP2,canonP3,pirateP4,null, 4 ));
        this.templateRepaire.add(new Repaire(canonP0, canonP0, canonP1,canonP2, canonP3, pirateP4, 5));
        this.templateRepaire.add(new Repaire(canonP0, pirateP1,pirateP2, pirateP3, null, null, 5));
        this.templateRepaire.add(new Repaire(canonP1, canonP2, pirateP3, pirateP4, null, null, 3));
        this.templateRepaire.add(new Repaire(canonP0, pirateP1, pirateP2, null, null, null, 4));
    }

    /**
     *
     * @return Repaire aleatoire
     */
    public Repaire repaireAleatoire(){
        int nmbAleatoir =  (int)Math.random()*this.templateRepaire.size();
        Repaire repaireTemp = this.templateRepaire.get(nmbAleatoir);
        this.templateRepaire.remove(nmbAleatoir);
        return repaireTemp;
    }

    /**
     *
     * @param listJoueurs Map de Joueurs de Type nom,couleur
     */
    public Plateau(TreeMap<String,String> listJoueurs) {
        initRepaire();
        // Génération de la Carte
        this.plateau = new Case[9][9];
        for (int i = 0; i< 9 ; i++){
            for (int j = 0 ; j < 9 ; j++){
                if( this.grilleRef[i][j] == 1)
                    this.plateau[i][j] = null;
                if( this.grilleRef[i][j] == 2)
                    this.plateau[i][j] = new Port();
                if( this.grilleRef[i][j] == 3)
                    this.plateau[i][j] = new Mer();
                if( this.grilleRef[i][j] == 4){
                    Repaire repaireTemp = this.repaireAleatoire();
                    this.plateau[i][j] = repaireTemp;
                    listDesRepaires.add(repaireTemp);
                }

            }
        }
        //Attribution des navires pour chaque joueur
        for (Map.Entry<String,String> e:listJoueurs.entrySet()) {
            this.listJoueurs.add(new Navire(e.getKey(), e.getValue()));
        }
    }
//TODO rennomer la fonction car je n'ai pas eu d'idee de nom
    /**
     * methode de deplacement retournent la liste des cases autorise au joueur
     * @param positionInitiale position du joueur lors de l'appel initial
     * @param nmbDePirate nombre de deplacement autorise pour ce joueur
     * @return la liste des cases autoriser (a colorier en verts)
     */
    public ArrayList<Case> caseAuthorized(ArrayList<Case> positionInitiale, int nmbDePirate){
        if(nmbDePirate!=0){
            //pas fini la recursion
            ArrayList<Case> listeCase = positionInitiale;
            // pour toute les dernieres case quelle sont les cases a coté ou on a le droits d'aller
            for (Case tmpCase : positionInitiale){
                ArrayList<Point> listeCaseTemp;
                listeCaseTemp = HexToolbox.getVoisins(tmpCase.getCoord());
                //est-ce que ces voisins sont des cases navigable
                for (Point point : listeCaseTemp){
                    if(HexToolbox.estNavigable(this.plateau,point)){
                        listeCaseTemp.remove(point);
                    }
                }
                //  cases correspondant a la liste des points et les ajoute au navigable
                for (Point point : listeCaseTemp){
                    listeCase.add(getCase(point));
                }
            }
            return caseAuthorized(listeCase, nmbDePirate-1);

        }
        else
            return positionInitiale;
    }

    public Case getCase(Point p){
        for (Case lign[] : this.plateau){
            for (Case tmpCase : lign){
                if(tmpCase.getCoord() == p)
                    return tmpCase;
            }
        }
        return null;
    }

    public Case getCase(int x, int y){
        for (Case lign[] : this.plateau){
            for (Case tmpCase : lign){
                if(tmpCase.getCoord().y == y && tmpCase.getCoord().x == x )
                    return tmpCase;
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
        //TODO : Verifier pour le nombre de points
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
    //TODO : Si veux une methode de pathfinding mais les chemin possible sont deja fait

    public ArrayList<Navire> getListJoueurs() {
        return listJoueurs;
    }
}
