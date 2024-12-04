package org.itson.presentation.strategy;

import javax.swing.*;
import java.awt.*;
import org.itson.domain.Player;

/**
 * Clase que actúa como intermediaria entre la Vista y la Lógica del Negocio.
 * Implementa el patrón MVVM para manejar la interacción usuario-sistema.
 */
public class StrategyModelView {

    private static StrategyModelView instance; // Instancia única (Singleton)
    private final StrategyBusiness business; // Referencia a la capa de Negocio
    private final StrategyView view; // Referencia a la Vista

    private int currentShipSize = 0; // Tamaño del barco seleccionado
    private boolean horizontalOrientation = true; // Orientación del barco seleccionado

    /**
     * Constructor privado (Singleton) Inicializa las referencias a la capa de
     * Negocio y la Vista.
     */
    private StrategyModelView() {
        business = StrategyBusiness.getInstance();
        view = StrategyView.getInstance();
        initialize();
    }

    /**
     * Método para obtener la instancia única de StrategyModelView.
     *
     * @return La instancia única de StrategyModelView.
     */
    public static StrategyModelView getInstance() {
        if (instance == null) {
            instance = new StrategyModelView();
        }
        return instance;
    }

    /**
     * Inicializa la configuración de eventos entre la Vista y el Modelo.
     */
    private void initialize() {
        view.initCustomButtonRow(this::handleCustomButtonClick);

        JButton[] gridButtons = view.getGridButtons();
        for (int i = 0; i < gridButtons.length; i++) {
            final int index = i;
            gridButtons[i].addActionListener(e -> handleGridButtonClick(index));
        }
    }

    /**
     * Método para iniciar el juego con el jugador configurado.
     *
     * @param player El jugador con su configuración.
     */
    public void startGame(Player player) {
        view.initializeGame(player); // Configura la vista con los datos del jugador.
        view.setVisible(true); // Hace visible la vista del juego.
    }

    private void handleCustomButtonClick(String actionCommand) {
        switch (actionCommand) {
            case "Horizontal" ->
                horizontalOrientation = true;
            case "Vertical" ->
                horizontalOrientation = false;
            default ->
                currentShipSize = getShipSize(actionCommand);
        }
    }

   private void handleGridButtonClick(int index) {
    if (currentShipSize == 0) {
        System.out.println("Por favor selecciona un barco.");
        return;
    }

    JButton[] buttons = view.getGridButtons();
    String playerColor = view.getPlayerColor(); // Obtener el color del jugador.

    if (!canPlaceShip(index, currentShipSize, horizontalOrientation, buttons, playerColor)) {
        System.out.println("No hay espacio suficiente para colocar el barco o está muy cerca de otro.");
        return;
    }

    placeShip(index, currentShipSize, horizontalOrientation, buttons, playerColor);
    business.placeShip(getShipTypeBySize(currentShipSize));
    view.updateShipsCountLabel(business.getShipsAvailable());
}


  private boolean canPlaceShip(int startIndex, int shipSize, boolean horizontal, JButton[] buttons, String playerColor) {
    int row = startIndex / 10;
    for (int i = 0; i < shipSize; i++) {
        int index = horizontal ? startIndex + i : startIndex + i * 10;
        if (index >= buttons.length || buttons[index].getBackground() == Color.RED || buttons[index].getBackground() == Color.BLUE) {
            return false;
        }
        if (horizontal && index / 10 != row) {
            return false;
        }
        if (isAdjacentToShip(index, buttons)) {
            return false;
        }
    }
    return true;
}

    private boolean isAdjacentToShip(int index, JButton[] buttons) {
    int[] adjacentOffsets = {-1, 1, -10, 10}; // Izquierda, derecha, arriba, abajo

    for (int offset : adjacentOffsets) {
        int adjacentIndex = index + offset;

        if (adjacentIndex >= 0 && adjacentIndex < buttons.length) {
            // Evitar errores en los bordes de la cuadrícula
            if (offset == -1 && index % 10 == 0) {
                continue; // Evita moverse de izquierda a otra fila
            }
            if (offset == 1 && index % 10 == 9) {
                continue; // Evita moverse de derecha a otra fila
            }
            if (buttons[adjacentIndex].getBackground() == Color.RED || buttons[adjacentIndex].getBackground() == Color.BLUE) {
                return true;
            }
        }
    }
    return false;
}

  private void placeShip(int startIndex, int shipSize, boolean horizontal, JButton[] buttons, String playerColor) {
    Color shipColor = "Red".equals(playerColor) ? Color.RED : Color.BLUE;
    for (int i = 0; i < shipSize; i++) {
        int index = horizontal ? startIndex + i : startIndex + i * 10;
        buttons[index].setBackground(shipColor); // Asignar color del jugador al barco.
    }
    System.out.println("Barco colocado en posición " + startIndex + " con orientación "
            + (horizontal ? "Horizontal" : "Vertical"));
}


    private int getShipSize(String shipType) {
        return switch (shipType) {
            case "Aircraft carriers" ->
                4;
            case "Cruisers" ->
                3;
            case "Submarines" ->
                2;
            case "Ships" ->
                1;
            default ->
                0;
        };
    }

    private String getShipTypeBySize(int size) {
        return switch (size) {
            case 4 ->
                "Aircraft carriers";
            case 3 ->
                "Cruisers";
            case 2 ->
                "Submarines";
            case 1 ->
                "Ships";
            default ->
                null;
        };
    }
}
