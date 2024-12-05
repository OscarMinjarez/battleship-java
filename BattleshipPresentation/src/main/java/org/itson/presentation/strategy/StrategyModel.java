package org.itson.presentation.strategy;

import java.util.HashMap;
import java.util.Map;
import org.itson.domain.AbstractShip;
import org.itson.domain.AircraftCarrier;
import org.itson.domain.Cruise;
import org.itson.domain.Player;
import org.itson.domain.Ship;
import org.itson.domain.Submarine;
import org.itson.domain.Table;

/**
 * Clase que representa el modelo de datos del juego. Se encarga de manejar la
 * cantidad de barcos disponibles y de notificar a los observadores de los
 * cambios.
 */
public class StrategyModel {

    private static StrategyModel instance; // Instancia única (Singleton).
    private IStrategyObserver observer; // Observador para notificar cambios.
    private Map<String, Integer> shipsAvailable; // Mapa de barcos disponibles.
    private Player player;
    private Table table;
    private AbstractShip[] ships;

    /**
     * Constructor privado para inicializar el modelo con datos predeterminados.
     */
    private StrategyModel() {
        shipsAvailable = new HashMap<>() {
            {
                put("Aircraft carriers", 2);
                put("Cruisers", 2);
                put("Submarines", 4);
                put("Ships", 3);
            }
        };
        this.player = new Player();
        this.table = new Table();
        this.ships = new AbstractShip[10];
    }

    /**
     * Obtiene la instancia única del modelo.
     *
     * @return Instancia única de StrategyModel.
     */
    public static StrategyModel getInstance() {
        if (instance == null) {
            instance = new StrategyModel();
        }
        return instance;
    }

    /**
     * Establece el observador que será notificado de los cambios.
     *
     * @param observer Observador que implementa IStrategyObserver.
     */
    public void setObserver(IStrategyObserver observer) {
        this.observer = observer;
    }

    /**
     * Reduce la cantidad de barcos disponibles para el tipo especificado y
     * notifica a los observadores.
     *
     * @param shipType Tipo de barco.
     */
    public void placeShip(String shipType) {
        if (shipsAvailable.containsKey(shipType) && shipsAvailable.get(shipType) > 0) {
            shipsAvailable.put(shipType, shipsAvailable.get(shipType) - 1);
            for (int i = 0; i < this.ships.length; i++) {
                if (shipType.equalsIgnoreCase("Aircraft carriers")) {
                    this.ships[i] = new AircraftCarrier();
                    System.out.println("Aircraft carrier added to list");
                }
                if (shipType.equalsIgnoreCase("Cruisers")) {
                    this.ships[i] = new Cruise();
                    System.out.println("Cruisers added to list");
                }
                if (shipType.equalsIgnoreCase("Submarines")) {
                    this.ships[i] = new Submarine();
                    System.out.println("Submarines added to list");
                }
                if (shipType.equalsIgnoreCase("Ships")) {
                    this.ships[i] = new Ship();
                    System.out.println("Ships added to list");
                }
            }
            notifyObserver();
        } else {
            System.out.println("No quedan barcos disponibles del tipo: " + shipType);
        }
    }

    /**
     * Obtiene los barcos disponibles.
     *
     * @return Mapa con los barcos y sus cantidades disponibles.
     */
    public Map<String, Integer> getShipsAvailable() {
        return shipsAvailable;
    }

    /**
     * Verifica si hay barcos disponibles de un tipo específico.
     *
     * @param shipType Tipo de barco.
     * @return Verdadero si hay barcos disponibles, falso si no.
     */
    public boolean isShipAvailable(String shipType) {
        return shipsAvailable.getOrDefault(shipType, 0) > 0;
    }

    /**
     * Notifica al observador sobre cambios en el modelo.
     */
    private void notifyObserver() {
        if (observer != null) {
            observer.update(shipsAvailable);
        }
    }
}
