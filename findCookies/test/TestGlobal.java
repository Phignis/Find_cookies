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

        ////
        System.out.println("----------------------");

        NiveauGroupe ng1 = new NiveauGroupe(1);

        System.out.println(ng1);

        NiveauGroupe ng2 = new NiveauGroupe(2, 25, 50);
        ng2.ajouterCouche(new Couche(0));
        ng2.ajouterCouche(new Couche(1));
        ng2.enleverCouche(new Couche(0));

        System.out.println(ng2);
    }
}
