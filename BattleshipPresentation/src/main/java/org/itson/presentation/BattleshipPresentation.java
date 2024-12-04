package org.itson.presentation;

import org.itson.presentation.strategy.StrategyModelView;
import org.itson.presentation.strategy.StrategyView;

public class BattleshipPresentation {

    public static void main(String[] args) {
        System.out.println("Starting Battleship Game!");

        /**
     * Método principal que se ejecuta al iniciar la aplicación.
       // Inicializa el modelo y la vista mediante el patrón Singleton.
     * @param args Los argumentos de línea de comandos (no se utilizan en este caso).
     */
        // Ejecuta la inicialización de la vista en el hilo de despacho de eventos de AWT.
        StrategyModelView viewModel = StrategyModelView.getInstance();

        java.awt.EventQueue.invokeLater(() -> {
            StrategyView view = StrategyView.getInstance();
            view.setVisible(true);
        });
      // Mensaje final indicando que la configuración está completa.
        System.out.println("Game setup complete. Enjoy!");
    }
}
