package org.itson.presentation;

import org.itson.presentation.strategy.StrategyModelView;
import org.itson.presentation.strategy.StrategyView;
import org.itson.presentation.strategy.*;
public class BattleshipPresentation {

    public static void main(String[] args) {
        System.out.println("Starting Battleship Game!");

        // Inicializa la vista
        java.awt.EventQueue.invokeLater(() -> {
            StrategyView view = StrategyView.getInstance();
            view.setVisible(true);
        });

        // Inicializa el modelo y la lógica del juego
        StrategyModelView viewModel = StrategyModelView.getInstance();

        // Ejemplo: Colocar un barco en la cuadrícula
        
        System.out.println("Game setup complete. Enjoy!");
    }
}
