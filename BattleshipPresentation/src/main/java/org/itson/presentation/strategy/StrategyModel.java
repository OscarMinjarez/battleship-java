
package org.itson.presentation.strategy;

import java.util.HashMap;
import java.util.Map;

public class StrategyModel {

    private static StrategyModel instance;
    private IStrategyObserver observer; // Un único observer
    private Map<String, Integer> shipsAvailable;

    private StrategyModel() {
        shipsAvailable = new HashMap<>() {{
            put("Aircraft carriers", 2);
            put("Cruisers", 2);
            put("Submarines", 4);
            put("Ships", 3);
        }};
    }

    public static StrategyModel getInstance() {
        if (instance == null) {
            instance = new StrategyModel();
        }
        return instance;
    }

    public void setObserver(IStrategyObserver observer) {
        this.observer = observer;
    }

    public void placeShip(String shipType) {
    if (shipsAvailable.containsKey(shipType) && shipsAvailable.get(shipType) > 0) {
        shipsAvailable.put(shipType, shipsAvailable.get(shipType) - 1);
        notifyObserver();
    } else {
        System.out.println("No more ships of type " + shipType + " available.");
    }
}


    public Map<String, Integer> getShipsAvailable() {
        return shipsAvailable;
    }

    public boolean isShipAvailable(String shipType) {
        return shipsAvailable.getOrDefault(shipType, 0) > 0;
    }

    private void notifyObserver() {
        if (observer != null) {
            observer.update(shipsAvailable); // Envía los datos actuales al observer
        }
    }
}
