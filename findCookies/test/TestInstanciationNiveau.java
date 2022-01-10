import metier.objets.Interrupteur;
import validation.Collisionneur;
import vueNiveau.InstanciationNiveau;
import vueNiveau.objets.InterrupteurGraphique;
import vueNiveau.objets.ObjetGraphique;

import java.io.IOException;
import java.net.URISyntaxException;

public class TestInstanciationNiveau {
    public static void main(String args[]) {
        try {
            TestInstanciationNiveau();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /*
         System.out.println("Contenu du fichier: ");
         System.out.println(sb);

        for (Couche l : listeCouches) {
            System.out.println(l.toString());
        }
        System.out.println();
        */
    }

    public static void TestInstanciationNiveau() throws Exception {
        InstanciationNiveau in = new InstanciationNiveau(1);
    }
}
