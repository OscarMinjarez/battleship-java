
package org.itson.presentation.strategy;

import domain.Player;
import domain.Ship;
import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.*;


/**
 *
 * @author PabloCeasxr
 */
public class StrategyModel {
    private Map<String, Integer> shipsAvailable;
    private java.util.List<IStrategyObserver> observers;

    public StrategyModel() {
        shipsAvailable = new HashMap<>() {
            {
                put("Aircraft carriers", 2);  // 2 portaaviones
                put("Cruisers", 2);  // 2 cruceros
                put("Submarines", 4);  // 4 submarinos
                put("Ships", 3);  // 3 barcos de 1 celda
            }
        };
        observers = new ArrayList<>();
    }

    public void addObserver(IStrategyObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(IStrategyObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (IStrategyObserver observer : observers) {
            observer.update();
        }
    }

    public Map<String, Integer> getShipsAvailable() {
        return shipsAvailable;
    }

    public void placeShip(String shipType) {
        if (shipsAvailable.containsKey(shipType) && shipsAvailable.get(shipType) > 0) {
            shipsAvailable.put(shipType, shipsAvailable.get(shipType) - 1);
            notifyObservers();  // Notificar a los observadores sobre los cambios
        }
    }

    public boolean isShipAvailable(String shipType) {
        return shipsAvailable.getOrDefault(shipType, 0) > 0;
    }
}
