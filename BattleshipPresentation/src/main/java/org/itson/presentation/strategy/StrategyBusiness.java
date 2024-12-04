package org.itson.presentation.strategy;

import org.itson.domain.Game;
import org.itson.domain.Player;
import java.util.Map;
import lombok.Setter;
import org.itson.presentation.contracts.IBusinessObserver;
import org.itson.presentation.contracts.IModelObserver;

/**
 * Clase que gestiona la lógica del negocio del juego.
 * Coordina las interacciones entre el modelo y otras partes del sistema.
 */
public class StrategyBusiness implements IBusinessObserver {

    private static StrategyBusiness instance; // Instancia única (Singleton).
    private final StrategyModel model; // Referencia al modelo de datos.
    private final Game game; // Objeto que maneja la lógica del juego.

    @Setter
    private IModelObserver modelObserver; // Observador para notificar cambios.

    /**
     * Constructor privado que inicializa el modelo y el juego.
     */
    private StrategyBusiness() {
        this.model = StrategyModel.getInstance();
        this.game = new Game();
    }

    /**
     * Obtiene la instancia única de la clase.
     * @return Instancia única de StrategyBusiness.
     */
    public static StrategyBusiness getInstance() {
        if (instance == null) {
            instance = new StrategyBusiness();
        }
        return instance;
    }

    /**
     * Devuelve los barcos disponibles desde el modelo.
     * @return Mapa con los barcos disponibles.
     */
    public Map<String, Integer> getShipsAvailable() {
        return model.getShipsAvailable();
    }

    /**
     * Intenta colocar un barco de tipo específico.
     * @param shipType Tipo de barco a colocar.
     */
    public void placeShip(String shipType) {
        if (model.isShipAvailable(shipType)) {
            model.placeShip(shipType);
            notifyModelUpdate(); // Notifica a la vista.
        } else {
            System.out.println("No hay barcos disponibles de este tipo.");
        }
    }

    /**
     * Agrega un jugador al juego.
     * @param player Jugador a agregar.
     */
    public void addPlayer(Player player) {
        if (player != null) {
            game.addPlayer(player);
            System.out.println("Jugador agregado: " + player.getName());
        } else {
            System.out.println("El jugador no puede ser nulo.");
        }
    }

    /**
     * Notifica cambios en el modelo a la capa de presentación.
     */
    private void notifyModelUpdate() {
        if (modelObserver != null) {
            modelObserver.notify(model.getShipsAvailable());
        }
    }

    /**
     * Responde a notificaciones de otros componentes.
     * @param object Datos enviados en la notificación.
     */
    @Override
    public void notify(Object object) {
        if (object instanceof Map<?, ?> shipsAvailable && modelObserver != null) {
            modelObserver.notify(shipsAvailable);
        }
    }
}
