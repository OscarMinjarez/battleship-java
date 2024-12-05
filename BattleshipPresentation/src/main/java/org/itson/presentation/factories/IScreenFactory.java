package org.itson.presentation.factories;

import org.itson.domain.Game;

 /** Interfaz para la fábrica de pantallas que define los métodos necesarios
 * para mostrar diferentes pantallas en la aplicación.
 */
public interface IScreenFactory {

    /**
     * Muestra la pantalla de espera.
     */
    void showStandbyScreen();

    /**
     * Muestra la pantalla de juego con la información de un juego específico.
     * 
     * @param game Instancia del juego que se mostrará en la pantalla.
     */
    void showGameScreen(Game game);
}
