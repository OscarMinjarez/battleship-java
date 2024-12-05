package org.itson.presentation.game;

public class GameModelView implements IGameObserver{

    private static GameModelView instance;
    private GameModel gameModel;
    private GameView gameView;

    private GameModelView() {
        this.gameView = GameView.getInstance();
        this.gameModel = GameModel.getInstance();
        this.gameModel.setGameObserver(this);
    }

    public static GameModelView getInstance() {
        if (instance == null) {
            instance = new GameModelView();
        }
        return instance;
    }
    
    @Override
    public void update() {
        this.gameView.showGameScreen();
    }

    public void shoot(int point) {
        this.gameModel.shoot(point);
    }
    
    public void showGameScreen() {
        this.gameView.showGameScreen();
    }
    

}
