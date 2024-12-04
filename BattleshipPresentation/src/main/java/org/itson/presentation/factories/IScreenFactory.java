package org.itson.presentation.factories;

import org.itson.domain.Game;

public interface IScreenFactory {
    void showStandbyScreen();
    void showGameScreen(Game game);
}
