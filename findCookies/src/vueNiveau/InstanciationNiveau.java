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

    public InstanciationNiveau(int numNiveau) throws URISyntaxException, IOException {
        Niveau n = creerNiveau(numNiveau);
    }

    public Niveau creerNiveau(int numNiveau) throws URISyntaxException, IOException {
        Niveau niveau;
        int numCouche = 0;
        Collection<Couche> listeCouches = new LinkedList<>();

        //tant qu'on parvient à charger le fichier et pour toutes les couches:
        URI nomFichier = getClass().getResource("/fichiers/" + numNiveau + "-" + numCouche + ".txt").toURI();
        while(nomFichier != null){
            Collection<ObjetGraphique> collectionObjets = chargerFichier(nomFichier);
            Couche c = new Couche(numCouche, collectionObjets);
            listeCouches.add(c);

            for (Couche l : listeCouches) {
                System.out.println(l.toString());
            }
            System.out.println();

            numCouche++;
            try {
                nomFichier = getClass().getResource("/fichiers/" + numNiveau + "-" + numCouche + ".txt").toURI();
            }catch (Exception e){
                break;
            }
        }

        niveau = new Niveau(numNiveau, listeCouches);

        return niveau;
    }

    public Collection<ObjetGraphique> chargerFichier(URI nomFichier) throws IOException {
        File fichier = new File(nomFichier);
        FileReader fr = new FileReader(fichier);
        BufferedReader br = new BufferedReader(fr);
        StringBuffer sb = new StringBuffer();
        int caractere;
        int x=0;
        int y=0;

        Collection<ObjetGraphique> collectionObjets = new ArrayList<>();

        while((caractere = br.read()) != -1)
        {
            switch((char) caractere){
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
        // System.out.println("Contenu du fichier: ");
        // System.out.println(sb);

        return collectionObjets;
    }
}
