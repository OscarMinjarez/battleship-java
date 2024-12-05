package org.itson.presentation.game;


public class GameModel {

    private static GameModel instance;
    private IGameObserver gameOberver;
    private GameBusiness gameBusiness;
    
    private GameModel() {
        this.gameBusiness = GameBusiness.getInstance();
        this.gameBusiness.setModel(this);
    }

    public void update() {
        gameOberver.update();
    }

    public static GameModel getInstance() {
        if (instance == null) {
            return instance = new GameModel();
        }
        return instance;

    }

    public void shoot(int index) {
        this.gameBusiness.shoot(index);
    }
    public void setGameObserver(IGameObserver gameObserver) {
        this.gameOberver = gameObserver;
    }
    
}
