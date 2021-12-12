package test_clock;

import clock.BoucleTemporelle;
import utile.patron_observateur.Observateur;

public class TestClock {

    public static void testBoucle() {
        BoucleTemporelle b = new BoucleTemporelle(5);

        Observateur o = new ObservateurGenerique("observateur 1");
        b.attacher(o);
        Observateur o1 = new ObservateurGenerique("observateur 2");
        b.attacher(o1);
    }
}
