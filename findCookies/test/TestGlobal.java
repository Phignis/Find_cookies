public class TestGlobal {
    public static void main(String args[]) {

        Niveau n = new Niveau(1);
        Couche c0 = new Couche(0);
        c0.ajouterObjet(new Objet("mon1erObjet", 2, 5, 3, 5));
        c0.ajouterObjet(new Objet("mon2emeObjet", 24, 5, 3, 6));
        Couche c1 = new Couche(1);
        c1.ajouterObjet(new Objet("mon3emeObjet", 0, 5, 3, 6));
        c1.ajouterObjet(new Objet("mon4emeObjet", 246, 5, 3, 6));

        n.setScene(new Scene(5, 10));
        n.getScene().ajouterCouche(c0);
        n.getScene().ajouterCouche(c1);

        System.out.println(n);


    }

    private static void testObservateur() {
        Niveau n = new Niveau(0);
        Couche c1 = new Couche(1);
        c1.ajouterObjet(new Interrupteur());
    }
}
