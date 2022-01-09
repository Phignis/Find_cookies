import vueNiveau.InstanciationNiveau;

import java.io.IOException;
import java.net.URISyntaxException;

public class TestInstanciationNiveau {
    public static void main(String args[]) {
        try {
            TestInstanciationNiveau();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void TestInstanciationNiveau() throws URISyntaxException, IOException {
        InstanciationNiveau in = new InstanciationNiveau(1);
    }
}
