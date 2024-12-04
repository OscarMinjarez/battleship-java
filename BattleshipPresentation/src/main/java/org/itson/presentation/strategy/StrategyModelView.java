package org.itson.presentation.strategy;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que actúa como intermediaria entre la Vista y la Lógica del Negocio.
 * Implementa el patrón MVVM para manejar la interacción usuario-sistema.
 */
public class StrategyModelView {

    private static StrategyModelView instance; // Instancia única (Singleton).
    private final StrategyBusiness business; // Referencia a la lógica de negocio.
    private final StrategyView view; // Referencia a la vista.

    private int currentShipSize = 0; // Tamaño del barco seleccionado.
    private boolean horizontalOrientation = true; // Orientación del barco seleccionado.

    private StrategyModelView() {
        business = StrategyBusiness.getInstance();
        view = StrategyView.getInstance();
        initialize();
    }

    public static StrategyModelView getInstance() {
        if (instance == null) {
            instance = new StrategyModelView();
        }
        return instance;
    }

    private void initialize() {
        view.initCustomButtonRow(this::handleCustomButtonClick);

        JButton[] gridButtons = view.getGridButtons();
        for (int i = 0; i < gridButtons.length; i++) {
            final int index = i;
            gridButtons[i].addActionListener(e -> handleGridButtonClick(index));
        }
    }

    private void handleCustomButtonClick(String actionCommand) {
        switch (actionCommand) {
            case "Horizontal" -> horizontalOrientation = true;
            case "Vertical" -> horizontalOrientation = false;
            default -> currentShipSize = getShipSize(actionCommand);
        }
    }

    private void handleGridButtonClick(int index) {
        JButton[] buttons = view.getGridButtons();
        if (currentShipSize == 0 || !canPlaceShip(index, currentShipSize, horizontalOrientation, buttons)) {
            System.out.println("Barco no puede colocarse aquí.");
            return;
        }
        placeShip(index, currentShipSize, horizontalOrientation, buttons);
        business.placeShip(getShipTypeBySize(currentShipSize));
        view.updateShipsCountLabel(business.getShipsAvailable());
    }

    private boolean canPlaceShip(int startIndex, int shipSize, boolean horizontal, JButton[] buttons) {
        for (int i = 0; i < shipSize; i++) {
            int index = horizontal ? startIndex + i : startIndex + i * 10;
            if (index >= buttons.length || buttons[index].getBackground() == Color.RED || isAdjacentToShip(index, buttons)) {
                return false;
            }
        }
        return true;
    }

    private boolean isAdjacentToShip(int index, JButton[] buttons) {
        int[] adjacentOffsets = {-1, 1, -10, 10};
        for (int offset : adjacentOffsets) {
            int adjacentIndex = index + offset;
            if (adjacentIndex >= 0 && adjacentIndex < buttons.length && buttons[adjacentIndex].getBackground() == Color.RED) {
                return true;
            }
        }
        return false;
    }

    private void placeShip(int startIndex, int shipSize, boolean horizontal, JButton[] buttons) {
        for (int i = 0; i < shipSize; i++) {
            int index = horizontal ? startIndex + i : startIndex + i * 10;
            buttons[index].setBackground(Color.RED);
        }
    }

    private int getShipSize(String shipType) {
        return switch (shipType) {
            case "Aircraft carriers" -> 4;
            case "Cruisers" -> 3;
            case "Submarines" -> 2;
            case "Ships" -> 1;
            default -> 0;
        };
    }

    private String getShipTypeBySize(int size) {
        return switch (size) {
            case 4 -> "Aircraft carriers";
            case 3 -> "Cruisers";
            case 2 -> "Submarines";
            case 1 -> "Ships";
            default -> null;
        };
    }
}