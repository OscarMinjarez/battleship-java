package org.itson.presentation.contracts;

import domain.Game;

public interface IScreenFactory {
    void showStandbyScreen();
    void showGameScreen(Game game);
}
