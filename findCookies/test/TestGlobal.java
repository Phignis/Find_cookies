import metier.Couche;
import metier.Interrupteur;
import metier.Niveau;
import test_clock.TestClock;

public class TestGlobal {
    public static void main(String args[]) {
        TestClock.testBoucle();
    }

    private static  void testStructure() {
        Niveau n = new Niveau(1);
        Couche c0 = new Couche(0);
        c0.ajouterObjet(new Interrupteur("mon1erObjet", 3, 5));
        c0.ajouterObjet(new Interrupteur("mon2emeObjet",  3, 6));
        Couche c1 = new Couche(1);
        c1.ajouterObjet(new Interrupteur("mon3emeObjet",  3, 6));
        c1.ajouterObjet(new Interrupteur("mon4emeObjet",  3, 6));

        n.ajouterCouche(c0);
        n.ajouterCouche(c1);
        System.out.println(n);

        ////
        System.out.println("----------------------");

        Niveau ng1 = new Niveau(1);

        System.out.println(ng1);

        Niveau ng2 = new Niveau(2, 25, 50);
        ng2.ajouterCouche(new Couche(0));
        ng2.ajouterCouche(new Couche(1));
        ng2.enleverCouche(new Couche(0));

        System.out.println(ng2);
    }

    /* private static void testObservateur() {
        Niveau n = new Niveau(0);
        Couche c1 = new Couche(1);
        c1.ajouterObjet(new métier.Interrupteur());
    } */
}
