package org.itson.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.ArrayList;
import java.util.List;


public class Game {

    private final List<Player> players;

    public Game() {
        this.players = new ArrayList<>();
    }

    /**
     * Agrega un jugador al juego.
     *
     * @param player El jugador a agregar.
     */
    public void addPlayer(Player player) {
        if (player != null) {
            players.add(player);
            System.out.println("Jugador añadido: " + player.getName());
        } else {
            System.out.println("No se puede añadir un jugador nulo.");
        }
    }

    public List<Player> getPlayers() {
        return players;
    }
}
