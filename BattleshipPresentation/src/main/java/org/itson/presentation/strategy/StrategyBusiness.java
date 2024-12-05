package org.itson.presentation.strategy;

import org.itson.domain.Player;
import java.util.Map;
import lombok.Setter;
import org.itson.domain.Table;
import org.itson.presentation.contracts.IBusinessObserver;
import org.itson.presentation.contracts.IModelObserver;

/**
 * Clase que gestiona la lógica del negocio del juego. Coordina las
 * interacciones entre el modelo y otras partes del sistema.
 */
public class StrategyBusiness implements IBusinessObserver {

    private static StrategyBusiness instance;
    private final StrategyModel model;
    private Player player;
    private Table table;

    @Setter
    private IModelObserver modelObserver;

    /**
     * Constructor privado que inicializa el modelo y el juego.
     */
    private StrategyBusiness() {
        this.model = StrategyModel.getInstance();
        this.player = new Player();
        this.table = new Table();
    }

    /**
     * Obtiene la instancia única de la clase.
     *
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
     *
     * @return Mapa con los barcos disponibles.
     */
    public Map<String, Integer> getShipsAvailable() {
        return model.getShipsAvailable();
    }

    /**
     * Intenta colocar un barco de tipo específico.
     *
     * @param shipType Tipo de barco a colocar.
     */
    public void placeShip(String shipType) {
        if (model.isShipAvailable(shipType)) {
            model.placeShip(shipType);
            notifyModelUpdate();
        } else {
            System.out.println("No quedan barcos disponibles de este tipo: " + shipType);
        }
    }

    /**
     * Verifica si hay barcos disponibles de un tipo específico.
     *
     * @param shipType Tipo de barco.
     * @return true si hay barcos disponibles, false en caso contrario.
     */
    public boolean isShipAvailable(String shipType) {
        return model.isShipAvailable(shipType);
    }

    /**
     * Agrega un jugador al juego.
     *
     * @param player Jugador a agregar.
     */
    public void addPlayer(Player player) {
        //  System.out.println("Player added: " + player.getName() + " with color: " + player.getColor());
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
     *
     * @param object Datos enviados en la notificación.
     */
    @Override
    public void notify(Object object) {
        if (object instanceof Map<?, ?> shipsAvailable && modelObserver != null) {
            modelObserver.notify(shipsAvailable);
        }
    }
}
