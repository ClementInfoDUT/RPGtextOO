import controller.GameLogic;
import model.GameModel;
import view.GameScreen;

public class Launcher {

  public static void main(String[] args) {

    // architecture M-V-C TRES simplifiée
    // car la "vue" se résume à des affichages en console
    // sans aucune mise à jour lorsque le "modele" change
    // ici le controlleur connait le modele et la vue et sert d'intermédiaire

    GameModel theRootModel = new GameModel();
    GameScreen theRootView = new GameScreen();
    GameLogic theController = new GameLogic(theRootModel, theRootView);

    theController.start();
  }

}
