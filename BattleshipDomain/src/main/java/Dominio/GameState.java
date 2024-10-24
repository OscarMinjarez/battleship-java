package Dominio;

/**
 * 
 */
public enum GameState {
    WaitPlayers,
    PrepareStrategy,
    InitializeGame,
    PlayerInTurn,
    VerifyShoot,
    ChangeTurn,
    VerifyPlayerShips
}