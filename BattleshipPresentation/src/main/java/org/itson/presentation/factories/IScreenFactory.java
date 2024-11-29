package org.itson.presentation.factories;

import domain.Game;

public interface IScreenFactory {
    void showStandbyScreen();
    void showGameScreen(Game game);
}