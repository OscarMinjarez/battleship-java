package org.itson.domain;

import java.io.Serializable;

public enum GameState implements Serializable {
    WaitPlayers,
    PrepareStrategy,
    InitializeGame,
    PlayerInTurn,
    VerifyShoot,
    ChangeTurn,
    VerifyPlayerShips
}
