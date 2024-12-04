
package org.itson.presentation.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase que representa el modelo de datos del juego.
 * Se encarga de manejar la cantidad de barcos disponibles
 * y de notificar a los observadores de los cambios.
 */
public class StrategyModel {

    private static StrategyModel instance; // Instancia única (Singleton).
    private IStrategyObserver observer; // Observador para notificar cambios.
    private Map<String, Integer> shipsAvailable; // Mapa de barcos disponibles.

    /**
     * Constructor privado para inicializar el modelo con datos predeterminados.
     */
    private StrategyModel() {
        shipsAvailable = new HashMap<>() {{
            put("Aircraft carriers", 2);
            put("Cruisers", 2);
            put("Submarines", 4);
            put("Ships", 3);
        }};
    }

    /**
     * Obtiene la instancia única del modelo.
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
     * @param observer Observador que implementa IStrategyObserver.
     */
    public void setObserver(IStrategyObserver observer) {
        this.observer = observer;
    }

    /**
     * Reduce la cantidad de barcos disponibles para el tipo especificado
     * y notifica a los observadores.
     * @param shipType Tipo de barco.
     */
    public void placeShip(String shipType) {
        if (shipsAvailable.containsKey(shipType) && shipsAvailable.get(shipType) > 0) {
            shipsAvailable.put(shipType, shipsAvailable.get(shipType) - 1);
            notifyObserver(); // Notifica cambios.
        } else {
            System.out.println("No hay barcos disponibles de tipo: " + shipType);
        }
    }

    /**
     * Obtiene los barcos disponibles.
     * @return Mapa con los barcos y sus cantidades disponibles.
     */
    public Map<String, Integer> getShipsAvailable() {
        return shipsAvailable;
    }

    /**
     * Verifica si hay barcos disponibles de un tipo específico.
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
