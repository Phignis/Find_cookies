import clock.BoucleTemporelle;
import utile.patron_observateur.Observateur;

public class TestClock {

    public static void testBoucle() {
        BoucleTemporelle b = new BoucleTemporelle(5);

        Observateur o = new Porte();

        b.attacher(o);
    }
}
