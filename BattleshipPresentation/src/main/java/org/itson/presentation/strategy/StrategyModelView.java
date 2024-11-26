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
    }

    public static StrategyModelView getInstance() {
        if (instance == null) {
            instance = new StrategyModelView();
        }
        return instance;
    }

    /**
     * Inicializa el panel lateral con botones para seleccionar barcos y
     * orientación.
     */
    public void initCustomButtonRow() {
        JPanel customButtonRowPanel = new JPanel();
        customButtonRowPanel.setLayout(new BoxLayout(customButtonRowPanel, BoxLayout.Y_AXIS));

        String[] buttonNames = {"Aircraft carriers", "Cruisers", "Submarines", "Ships"};
        int[] shipSizes = {4, 3, 2, 1};

        for (int i = 0; i < buttonNames.length; i++) {
            String name = buttonNames[i];
            int size = shipSizes[i];
            JButton button = new JButton(name);
            button.addActionListener(e -> {
                currentShipSize = size;
                System.out.println(name + " seleccionado con tamaño " + size);
            });
            customButtonRowPanel.add(button);
        }

        JButton horizontalButton = new JButton("Horizontal");
        horizontalButton.addActionListener(e -> {
            horizontalOrientation = true;
            System.out.println("Orientacion seleccionada: Horizontal");
        });
        customButtonRowPanel.add(horizontalButton);

        JButton verticalButton = new JButton("Vertical");
        verticalButton.addActionListener(e -> {
            horizontalOrientation = false;
            System.out.println("Orientacion seleccionada: Vertical");
        });
        customButtonRowPanel.add(verticalButton);

        view.addCustomButtonPanel(customButtonRowPanel);
    }

    private void paintShip(int startIndex, String shipType, boolean horizontal, JButton[] buttons) {
        int size = getShipSize(shipType); // Obtén el tamaño del barco según su tipo

        for (int i = 0; i < size; i++) {
            int index = horizontal ? startIndex + i : startIndex + i * 10;
            buttons[index].setBackground(Color.RED); // Pinta las celdas ocupadas
        }
    }

    /**
     * Maneja el clic en un botón de la cuadrícula.
     */
    public void handleGridButtonClick(int index) {
        if (currentShipSize == 0) {
            System.out.println("Por favor selecciona un barco.");
            return;
        }

        JButton[] buttons = view.getGridButtons();
        // Verifica si el barco puede ser colocado
        if (!canPlaceShip(index, currentShipSize, horizontalOrientation, buttons)) {
            System.out.println("No hay espacio suficiente para colocar el barco.");
            return;
        }

        // Coloca el barco
        placeShip(index, currentShipSize, horizontalOrientation, buttons);

        // Actualiza el modelo de negocio
        business.placeShip(getShipTypeBySize(currentShipSize));

        // Actualiza la vista con la información de barcos restantes
        view.updateShipsCountLabel(business.getShipsAvailable());
    }

    public void placeShip(int startIndex, int currentShipSize, boolean horizontalOrientation, JButton[] buttons) {
        // Pintar el barco en la cuadrícula
        for (int i = 0; i < currentShipSize; i++) {
            int index = horizontalOrientation ? startIndex + i : startIndex + i * 10;
            buttons[index].setBackground(Color.RED); // Pinta las celdas ocupadas
        }

        System.out.println("Barco colocado en posición " + startIndex + " con orientación "
                + (horizontalOrientation ? "Horizontal" : "Vertical"));
    }

    /**
     * Verifica si un barco puede ser colocado en la cuadrícula.
     */
    private boolean canPlaceShip(int startIndex, int shipSize, boolean horizontal, JButton[] buttons) {
        int row = startIndex / 10;
        for (int i = 0; i < shipSize; i++) {
            int index = horizontal ? startIndex + i : startIndex + i * 10;

            // Verifica límites de la cuadrícula
            if (index >= buttons.length || buttons[index].getBackground() == Color.RED) {
                return false;
            }
            if (horizontal && index / 10 != row) {
                return false; // Se sale de la fila
            }
        }
        return true;
    }

    /**
     * Pinta un barco en la cuadrícula.
     */
    public void placeShip(String shipType, int startIndex, boolean horizontal) {
        JButton[] buttons = view.getGridButtons();

        // Verifica si se puede colocar el barco
        if (!canPlaceShip(startIndex, getShipSize(shipType), horizontal, buttons)) {
            System.out.println("No hay espacio suficiente para colocar el barco.");
            return;
        }

        // Pinta el barco
        paintShip(startIndex, shipType, horizontal, buttons);

        // Lógica del negocio
        business.placeShip(shipType);

        // Actualiza la interfaz
        view.updateShipsCountLabel(business.getShipsAvailable());
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
                0; // Devuelve 0 si el tipo de barco no coincide
        };
    }

    /**
     * Obtiene el tipo de barco según su tamaño.
     */
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
                null; // Devuelve null si el tamaño no coincide
        };
    }
}
