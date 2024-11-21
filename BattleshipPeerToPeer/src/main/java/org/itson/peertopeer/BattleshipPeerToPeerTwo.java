package org.itson.peertopeer;

import java.io.IOException;
import java.util.Date;

import domain.Game;
import domain.GameStatus;
import domain.History;
import domain.Player;

public class BattleshipPeerToPeerTwo {
    
    public static void main(String[] args) {
        try {
            BattleshipPeerNode node = new BattleshipPeerNode();
            node.connect("localhost", 5000);
            Thread.sleep(15_000);
            GameStatus gameStatus = new GameStatus(
                new History(new Date(), "This is an another message", new Player("Oscar")),
                new Game()
            );
            node.writeObject(gameStatus);
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
