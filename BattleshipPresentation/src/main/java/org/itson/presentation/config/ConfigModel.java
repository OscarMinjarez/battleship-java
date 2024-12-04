
package org.itson.presentation.config;

import org.itson.domain.Player;

/**
 *
 * @author PabloCeasxr
 */
/**
 * La clase ConfigModel representa el modelo de configuración del juego.
 * Sigue el patrón Singleton para garantizar que solo exista una instancia global
 * durante la ejecución del programa. Administra la configuración del jugador y
 * permite su actualización, almacenamiento y verificación.
 */
/**
 * Modelo que almacena y gestiona la configuración inicial del juego.
 */
public class ConfigModel {

    private Player player;
    private static ConfigModel instance;

    private ConfigModel() {
    }

    public static ConfigModel getInstance() {
        if (instance == null) {
            instance = new ConfigModel();
        }
        return instance;
    }

    /**
     * Guarda la configuración del jugador.
     * @param player Jugador con la configuración seleccionada.
     */
    public void saveConfig(Player player) {
        this.player = player;
    }

    /**
     * Obtiene la configuración del jugador.
     * @return Jugador con su configuración.
     */
    public Player getConfig() {
        return this.player;
    }
}