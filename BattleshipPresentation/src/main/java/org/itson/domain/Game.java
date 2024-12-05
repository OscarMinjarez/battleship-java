package org.itson.domain;

import lombok.Getter;

public class Game {

    @Getter
    private final Player[] players;
    private Player turn;

    public Game() {
        this.players = new Player[2];
    }

    /**
     * Agrega un jugador al juego.
     *
     * @param index
     * @return 
     */
    public boolean shoot(int index) {
        for (Player player : this.players) {
            if (!player.equals(this.turn)) {
                return player.getTable().shoot(index);
            }
        }
        return false;
    }

    public void addPlayer(Player player) {
        for (int i = 0; i < this.players.length; i++) {
            if (this.players[i] == null) {
                this.players[i] = player;
                break;
            }
        }
    }

}
