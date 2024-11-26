package org.itson.presentation.strategy;

import domain.Game;
import domain.Player;
import java.util.Map;
import lombok.Setter;
import org.itson.presentation.contracts.IBusinessObserver;
import org.itson.presentation.contracts.IModelObserver;

public class StrategyBusiness implements IBusinessObserver {

    private static StrategyBusiness instance;
    private final StrategyModel model;
    private final Game game; // Agregamos el atributo Game

    @Setter
    private IModelObserver modelObserver;

    private StrategyBusiness() {
        this.model = StrategyModel.getInstance();
        this.game = new Game(); // Inicializamos el objeto Game
    }

    public static StrategyBusiness getInstance() {
        if (instance == null) {
            instance = new StrategyBusiness();
        }
        return instance;
    }

    public Map<String, Integer> getShipsAvailable() {
        return model.getShipsAvailable();
    }

    public void placeShip(String shipType) {
        if (model.isShipAvailable(shipType)) {
            model.placeShip(shipType);
            notifyModelUpdate();
        } else {
            System.out.println("No hay mas barcos disponibles .");
        }
    }

    public boolean isShipAvailable(String shipType) {
        return model.isShipAvailable(shipType);
    }

    /**
     * Agrega un jugador al juego.
     *
     * @param player El jugador a agregar.
     */
    public void addPlayer(Player player) {
        if (player != null) {
            this.game.addPlayer(player); // Llamada al método addPlayer de Game
            System.out.println("Jugador dentro: " + player.getName());
        } else {
            System.out.println("El jugador no puede ser nulo.");
        }
    }

    private void notifyModelUpdate() {
        if (modelObserver != null) {
            modelObserver.notify(model.getShipsAvailable());
        }
    }

    @Override
    public void notify(Object object) {
        if (object instanceof Map<?, ?> shipsAvailable && modelObserver != null) {
            modelObserver.notify(shipsAvailable);
        }
    }
}
