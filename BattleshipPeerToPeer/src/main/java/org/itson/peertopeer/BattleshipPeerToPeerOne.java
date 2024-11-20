package org.itson.peertopeer;

import java.io.IOException;
import java.util.Date;

import domain.Game;
import domain.GameStatus;
import domain.History;
import domain.Player;

public class BattleshipPeerToPeerOne {
    
    public static void main(String[] args) {
        try {
            BattleshipPeerNode node = new BattleshipPeerNode();
            node.run(5000);
            Thread.sleep(2_000);
            node.connect("10.202.109.131", 5000);
            Thread.sleep(10_000);
            GameStatus gameStatus = new GameStatus(
                new History(new Date(), "This is a message", new Player("Oscar")),
                new Game()
            );
            node.writeObject(gameStatus);
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
