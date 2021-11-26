public class TestGlobal {
    public static void main(String args[]) {

        Niveau n = new Niveau(1);
        Couche c0 = new Couche(0);
        Couche c1 = new Couche(1);

        n.setScene(new Scene(5, 10));
        n.getScene().ajouterCouche(c0);
        n.getScene().ajouterCouche(c1);

        System.out.println(n);


    }
}
