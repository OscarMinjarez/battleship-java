package org.itson.presentation.factories;

import org.itson.domain.Game;
import org.itson.presentation.connection.ConnectionViewModel;
import org.itson.presentation.game.GameModelView;
import org.itson.presentation.standby.StandbyViewModel;

/**
 * Clase que implementa el patrón Singleton para gestionar la creación y visualización de pantallas en la aplicación.
 * Proporciona métodos para mostrar diferentes pantallas, como la pantalla de espera y la pantalla de juego.
 */
public class ScreenFactory implements IScreenFactory {

    private static ScreenFactory instance;

    private ScreenFactory() {

    }
    
    /**
     * Obtiene la instancia única de la fábrica de pantallas.
     * Si no existe, la crea.
     * 
     * @return Instancia única de ScreenFactory.
     */

    public static ScreenFactory getInstance() {
        if (ScreenFactory.instance == null) {
            ScreenFactory.instance = new ScreenFactory();
        }
        return ScreenFactory.instance;
    }
    
    /**
     * Muestra la pantalla de espera utilizando el modelo de vista correspondiente.
     */

    @Override
    public void showStandbyScreen() {
        StandbyViewModel standbyViewModel = StandbyViewModel.getInstance();
        standbyViewModel.showStandbyScreen();
    }
    
    /**
     * Muestra la pantalla de juego utilizando el modelo de vista correspondiente.
     * 
     */

    @Override
    public void showGameScreen() {
        GameModelView gameModelView = GameModelView.getInstance();
        gameModelView.showGameScreen();
    }

    @Override
    public void showConnectionScreen() {
        ConnectionViewModel connectionVM = ConnectionViewModel.getInstance();
        connectionVM.showConnectionScreen();
    }
}
