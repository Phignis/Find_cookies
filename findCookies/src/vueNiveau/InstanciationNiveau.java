package vueNiveau;

import metier.Couche;
import metier.objets.Interrupteur;
import metier.objets.Porte;
import vueNiveau.objets.InterrupteurGraphique;
import vueNiveau.objets.ObjetGraphique;
import vueNiveau.objets.PorteGraphique;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class InstanciationNiveau {
    private Niveau niveau;

    public InstanciationNiveau(int numNiveau) throws Exception {
        niveau = creerNiveau(numNiveau);
    }

    /**
     * Créér le niveau en chargeant le fichier correspondant au numéro du niveau à charger
     * @param numNiveau numéro du niveau à charger
     * @return Le niveau nouvellement créé
     * @throws Exception Si le numéro de niveau ne correspond à aucun fichier
     */
    private Niveau creerNiveau(int numNiveau) throws Exception {
        Niveau niveau;
        Collection<Couche> listeCouches;

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
    private Collection<Couche> chargerFichier(URI nomFichier) throws IOException {
        File fichier = new File(nomFichier);
        FileReader fr = new FileReader(fichier);
        BufferedReader br = new BufferedReader(fr);
        StringBuffer sb = new StringBuffer();
        int caractere;
        int x=0;
        int y=0;

        int numCouche = 0;
        Collection<Couche> listeCouches = new LinkedList<>();
        Collection<ObjetGraphique> collectionObjets = new ArrayList<>();
        Couche c;

        while((caractere = br.read()) != -1)
        {
            switch((char) caractere){
                case '-':
                    c = new Couche(numCouche, collectionObjets);
                    listeCouches.add(c);
                    collectionObjets = new ArrayList<>(); //on vide la collection d'objets
                    numCouche++; //on incrémente le numéro de la couche pour lire encore plus de dessins
                    y=-2;
                case '\n':
                    x=-1; //pour repasser à 0 ensuite avec le x++;
                    y++;
                    break;
                case '0':
                    // collectionObjets.add(new ObjetGraphique("Sol.png", x, y, null));
                    break;
                case '1':
                    // collectionObjets.add(new ObjetGraphique("Chpatata.png", x, y, null));
                    break;
                case '2':
                    collectionObjets.add(new InterrupteurGraphique(x, y, new Interrupteur()));
                    break;
                case '3':
                    collectionObjets.add(new PorteGraphique(x, y, new Porte()));
                default:
                    // collectionObjets.add(new ObjetGraphique("Rien.png", x, y, null));
                    break;
            }
            x++;
            sb.append((char) caractere);
        }

        fr.close();

        return listeCouches;
    }
}
