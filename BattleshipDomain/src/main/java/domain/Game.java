package domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Game implements Serializable {

    private GameState state;
    private Player turn;
    private Player[] players = new Player[2]; // Arreglo para almacenar dos jugadores

    /**
     * Método para añadir un jugador al arreglo de jugadores.
     *
     * @param player Jugador a añadir.
     * @throws IllegalStateException Si ya hay dos jugadores registrados.
     */
    public void addPlayer(Player player) {
        if (players[0] == null) {
            players[0] = player;
        } else if (players[1] == null) {
            players[1] = player;
        } else {
            throw new IllegalStateException("El juego ya tiene dos jugadores.");
        }
    }
}
