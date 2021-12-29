import clock.BoucleTemporelle;
import clock.GenerateurTick;
import metier.Couche;
import metier.Interrupteur;
import metier.Niveau;
import metier.Porte;
import metier.gestion.porte.update.RemiseMementoPorte;
import observateur.ObservateurGenerique;
import utile.observateur.Observateur;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestGlobal {
    public static void main(String args[]) {
        // TestClock.testBoucle();
        /*if(!testUniciteSujetAbstract()) {
            System.err.println("Soucis dans le test d'unicité des instances abonnés a un SujetAbstract");
        } else System.out.println(("Test d'unicité des instances abonnés a un SujetAbstract réussi!"));*/

        if(!testUpdatePorte()) {
            System.err.println("Soucis dans le test d'update d'une porte");
        } else System.out.println(("Test d'update d'une porte réussi!"));
    }

    private static void testStructure() {
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

    private static boolean testUniciteSujetAbstract() {

        boolean reussi;

        BoucleTemporelle b = new BoucleTemporelle(1);
        Observateur o = new ObservateurGenerique("obs1");
        if(!b.attacher(o) || b.attacher(o) || !b.attacher(new ObservateurGenerique("obs2"))) return false;

        System.out.println("Vous devriez voir deux lignes de notification, une pour obs1, et une pour obs2");
        b.update(null);
        Scanner c = new Scanner(System.in);
        System.out.println("Il y a t'il bien eu 2 lignes, une pour obs1 et une pour obs2? (true/false)");

        try {
            reussi = c.nextBoolean();
        } catch(InputMismatchException e) {
            reussi = false;
        }

        if(!reussi) {
            c.close();
            return false;
        }

        if(!b.detacher(o)) {
            c.close();
            return false;
        }

        System.out.println("Vous devriez voir une lignes de notification, pour obs2");
        b.update(null);
        System.out.println("Il y a t'il bien eu 1 ligne pour obs2? (true/false)");

        try {
            reussi = c.nextBoolean();
        } catch(InputMismatchException e) {
            reussi = false;
        }


        c.close();

        return reussi;
    }

    private static boolean testUpdatePorte() {
        Porte p = new Porte();
        Interrupteur i = new Interrupteur("too", 3,3);
        BoucleTemporelle b = new BoucleTemporelle(1); // update a chaque tick

        p.setActionneur(i); // censé créer un gestion pour gérer les notifs de Interrupteur, on ne peut donc a nouveau l'ajouter
        //if(p.getActionneur() != i) return false;

        p.setEstOuverte(true);
        if(!p.isEstOuverte()) return false;

        // on est a true, et les update généré par b ne sont pas encore censé changer a false notre état
        b.attacher(p);
        GenerateurTick t = new GenerateurTick();
        t.interrompreGenerateur();
        b.update(t); // b notifie p, mais p est censé rester dans son état

        if(!p.isEstOuverte()) return false;

        // on le refait cette fois avec l'action d'update pour la boucle
        p.ajouterActionUpdate(b, new RemiseMementoPorte(p));
        b.update(t); // b notifie p, mais p recoit et doit s'update

        if(p.isEstOuverte()) return false;
        // on est dans le cas où p est fermée par la boucle
        i.actionnerInterrupteur(); // on active l'interrupteur, la porte doit donc s'ouvrir

        if(!p.isEstOuverte()) return false;

        return true;
    }
}
