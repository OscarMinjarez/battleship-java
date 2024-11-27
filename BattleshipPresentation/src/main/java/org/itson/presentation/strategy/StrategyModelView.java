package org.itson.presentation.strategy;

import javax.swing.*;
import java.awt.*;

public class StrategyModelView {

    private static StrategyModelView instance;
    private final StrategyBusiness business;
    private final StrategyView view;

    private int currentShipSize = 0;
    private boolean horizontalOrientation = true;

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
            case "Horizontal" -> {
                horizontalOrientation = true;
                System.out.println("Escogiste orientacion Horizontal");
            }
            case "Vertical" -> {
                horizontalOrientation = false;
                System.out.println("Escogiste orientacion Vertical");
            }
            default -> {
                currentShipSize = getShipSize(actionCommand);
                System.out.println(actionCommand + " seleccionado con tamaño " + currentShipSize);
            }
        }
    }

    private void handleGridButtonClick(int index) {
        if (currentShipSize == 0) {
            System.out.println("Por favor selecciona un barco.");
            return;
        }

        JButton[] buttons = view.getGridButtons();
        if (!canPlaceShip(index, currentShipSize, horizontalOrientation, buttons)) {
            System.out.println("No hay espacio suficiente para colocar el barco.");
            return;
        }

        placeShip(index, currentShipSize, horizontalOrientation, buttons);
        business.placeShip(getShipTypeBySize(currentShipSize));
        view.updateShipsCountLabel(business.getShipsAvailable());
    }

    private boolean canPlaceShip(int startIndex, int shipSize, boolean horizontal, JButton[] buttons) {
        int row = startIndex / 10;
        for (int i = 0; i < shipSize; i++) {
            int index = horizontal ? startIndex + i : startIndex + i * 10;
            if (index >= buttons.length || buttons[index].getBackground() == Color.RED) {
                return false;
            }
            if (horizontal && index / 10 != row) {
                return false;
            }
        }
        return true;
    }

    private void placeShip(int startIndex, int shipSize, boolean horizontal, JButton[] buttons) {
        for (int i = 0; i < shipSize; i++) {
            int index = horizontal ? startIndex + i : startIndex + i * 10;
            buttons[index].setBackground(Color.RED);
        }
        System.out.println("Barco colocado en posición " + startIndex + " con orientación "
                + (horizontal ? "Horizontal" : "Vertical"));
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