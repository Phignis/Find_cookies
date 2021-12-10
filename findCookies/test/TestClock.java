import clock.BoucleTemporelle;
import clock.Observateur;

public class TestClock {

    public static void testBoucle() {
        BoucleTemporelle b = new BoucleTemporelle(5);

        Observateur o = new Observateur("observateur 1");

        b.attacher(o);
    }
}
