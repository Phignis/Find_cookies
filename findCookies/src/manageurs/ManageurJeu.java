package manageurs;

import javafx.scene.canvas.Canvas;
import temps.GenerateurMouvement;
import temps.GenerateurTick;
import utile.Dessinateur;

public class ManageurJeu {
    private ManageurNiveau manageurNiveau;
    private GenerateurTick generateurTick;
    private GenerateurMouvement generateurMouvement;

    public ManageurJeu(Canvas canvas) throws Exception {
        manageurNiveau = new ManageurNiveau(canvas, 1);

        generateurTick = new GenerateurTick();
        generateurMouvement = new GenerateurMouvement(canvas);
        generateurTick.attacher(generateurMouvement);
    }
}
