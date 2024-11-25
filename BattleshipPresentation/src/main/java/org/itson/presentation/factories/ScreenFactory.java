package org.itson.presentation.factories;

import domain.Game;
import org.itson.presentation.game.GameModelView;
import org.itson.presentation.standby.StandbyViewModel;

public class ScreenFactory implements IScreenFactory {
    
    private static ScreenFactory instance;
    
    private ScreenFactory() {
        
    }
    
    public static ScreenFactory getInstance() {
        if (ScreenFactory.instance == null) {
            ScreenFactory.instance = new ScreenFactory();
        }
        return ScreenFactory.instance;
    }
    
    @Override
    public void showStandbyScreen() {
        StandbyViewModel standbyViewModel = StandbyViewModel.getInstance();
        standbyViewModel.showStandbyScreen();
    }
    
    @Override
    public void showGameScreen(Game game) {
        GameModelView gameModelView = GameModelView.getInstance();
        gameModelView.setGame(game);
        gameModelView.showGameScreen();
    }
}
