import controller.GameLogic;
import model.GameModel;
import view.GameScreen;



public class Launcher {

  public static void main(String[] args) {

    

    GameModel theRootModel = new GameModel();
    GameScreen theRootView = new GameScreen();
    GameLogic theController = new GameLogic(theRootModel, theRootView);

    theController.start();
  }

}
