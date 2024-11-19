package org.itson.peertopeer;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Date;

import org.itson.peertopeer.client.PeerClient;

import domain.Game;
import domain.GameStatus;
import domain.History;
import domain.Player;

public class PeerToPeerClientTwo {

    public static void main(String[] args) {
        try {
            PeerClient client = new PeerClient(5001);
            client.connect("10.202.109.131", 5000);
            GameStatus gameStatus = new GameStatus(
                new History(new Date(), "This is an another message", new Player("Oscar")),
                new Game()
            );
            client.writeObject(gameStatus);
        } catch (UnknownHostException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
