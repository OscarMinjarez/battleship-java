package org.itson.presentation;

import org.itson.presentation.strategy.StrategyModelView;
import org.itson.presentation.strategy.StrategyView;

public class BattleshipPresentation {

    public static void main(String[] args) {
        System.out.println("Starting Battleship Game!");

        // Inicializa la vista y el modelo
        StrategyModelView viewModel = StrategyModelView.getInstance();

        java.awt.EventQueue.invokeLater(() -> {
            StrategyView view = StrategyView.getInstance();
            view.setVisible(true);
        });

        System.out.println("Game setup complete. Enjoy!");
    }
}
