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
    private Player[] player = new Player[2];   
    
    public void addPlayer(Player player) {
        for (int i = 0; i < this.player.length; i++) {
            if (this.player[i] == null) {
                this.player[i] = player;
                break;
            }
        }
    }
}
