package org.itson.presentation.factories;

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
     */
    void showGameScreen();
}
