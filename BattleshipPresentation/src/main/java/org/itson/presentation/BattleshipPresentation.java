package org.itson.presentation;

import org.itson.presentation.config.FrmBattleship;
import org.itson.presentation.strategy.StrategyModelView;
import org.itson.presentation.strategy.StrategyView;

public class BattleshipPresentation {

    public static void main(String[] args) {
        System.out.println("Starting Battleship Game!");

        // Ejecuta la inicialización de la pantalla de configuración en el hilo de despacho de eventos de AWT.
        java.awt.EventQueue.invokeLater(() -> {
            FrmBattleship configView = FrmBattleship.getInstance();
            configView.setVisible(true); // Mostrar la pantalla de configuración.
        });

        // Mensaje final indicando que la configuración inicial está lista.
        System.out.println("Configuration screen launched. Ready to play!");
    }
}