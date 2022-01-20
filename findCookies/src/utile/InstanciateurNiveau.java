package utile;

import objets.niveaux.Couche;
import objets.niveaux.graphiques.*;
import objets.niveaux.metiers.Interrupteur;
import objets.niveaux.metiers.Porte;
import objets.niveaux.Niveau;
import objets.niveaux.metiers.ObjetVide;
import objets.niveaux.metiers.deplacables.Personnage;

import java.io.*;
import java.net.URI;
import java.util.ArrayList;

public class InstanciateurNiveau {
    /**
     * Nombre d'éléments en largeur sur une couche
     */
    private int maxX = 0;
    public int getMaxX(){ return maxX; }

    /**
     * Nombre d'éléments en hauteur sur une couche
     */
    private int maxY = 0;
    public int getMaxY(){ return maxY; }

    private Niveau niveau;
    public Niveau getNiveau(){
        return niveau;
    }

    /**
     * Créér le niveau en chargeant le fichier correspondant au numéro du niveau à charger
     * @param numNiveau numéro du niveau à charger
     * @return Le niveau nouvellement créé
     * @throws Exception Si le numéro de niveau ne correspond à aucun fichier
     */
    public Niveau creerNiveau(int numNiveau) throws Exception {
        Niveau niveau;
        ArrayList<Couche> listeCouches;

        URI nomFichier = getClass().getResource("/fichiers/" + numNiveau + ".txt").toURI();
        if(nomFichier == null){
            throw new Exception("Le fichier n'est pas accéssible");
        }
        listeCouches = chargerFichier(nomFichier);

        niveau = new Niveau(numNiveau, listeCouches);
        return niveau;
    }

    /**
     * Charge le fichier correspondant au numéro du niveau et charge couche par couche la collection d'objets correpondante
     * @param nomFichier Nom du fichier à charger
     * @return une collection d'objets par couches
     * @throws IOException si le fichier chargé n'est pas accessible ou sa lecture pose problème
     */
    private ArrayList<Couche> chargerFichier(URI nomFichier) throws Exception {
        File fichier = new File(nomFichier);
        FileReader fr = new FileReader(fichier);
        BufferedReader br = new BufferedReader(fr);
        StringBuffer sb = new StringBuffer();
        int caractere;
        int x=0;
        int y=0;

        int numCouche = 0;
        ArrayList<Couche> listeCouches = new ArrayList<Couche>();
        ArrayList<ObjetGraphique> collectionObjets = new ArrayList<>();
        Couche c;

        ObjetVideGraphique objetVideGraphique;

        while((caractere = br.read()) != -1)
        {
            switch((char) caractere){
                case '-':
                    c = new Couche(numCouche, collectionObjets);
                    listeCouches.add(c);
                    collectionObjets = new ArrayList<ObjetGraphique>(); //on vide la collection d'objets
                    numCouche++; //on incrémente le numéro de la couche pour lire encore plus de dessins
                    y=-3;
                case '\n':
                    x=-1; //pour repasser à 0 ensuite avec le x++;
                    y++;
                    break;
                case '0':
                     objetVideGraphique = new ObjetVideGraphique(x, y, new ObjetVide());
                     objetVideGraphique.setCheminImage("sol_6.png");
                     collectionObjets.add(objetVideGraphique);
                    break;
                case '1':
                    collectionObjets.add(new PersonnageGraphique(x, y, new Personnage()));
                    break;
                case '2':
                    collectionObjets.add(new InterrupteurGraphique(x, y, new Interrupteur()));
                    break;
                case '3':
                    collectionObjets.add(new PorteGraphique(x, y, new Porte()));
                    break;
                case '4':
                    objetVideGraphique = new ObjetVideGraphique(x, y, new ObjetVide());
                    objetVideGraphique.setCheminImage("rocher.png");
                    collectionObjets.add(objetVideGraphique);
                case '5':
                    objetVideGraphique = new ObjetVideGraphique(x, y, new ObjetVide());
                    objetVideGraphique.setCheminImage("carton.png");
                    collectionObjets.add(objetVideGraphique);

                default:
                    objetVideGraphique = new ObjetVideGraphique(x, y, new ObjetVide());
                    objetVideGraphique.setCheminImage("skin_par_defaut.png");
                    collectionObjets.add(objetVideGraphique);
                    break;
            }
            x++;
            sb.append((char) caractere);
        }

        maxX = x;
        maxY = y;

        fr.close();

        return listeCouches;
    }
}
