
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
public class ConfigModel {

    private Player player;
    private static ConfigModel instance;
    private IConfigObserver iConfigObserver;

     /**
     * Constructor privado para evitar la creación de múltiples instancias.
     * El patrón Singleton hace q pueda ser instanciada desde dentro.
     */
    private ConfigModel() {

    }
/**
     * Método para actualizar la configuración. 
     */
    public void update() {
    }

    /**
     * Método estático para obtener la instancia única de ConfigModel.
     * Si no existe, se crea una nueva instancia.
     *
     * @return La instancia única de ConfigModel.
     */
    public static ConfigModel getInstance() {
        if (instance == null) {
            return instance = new ConfigModel();
        }
        return instance;

    }

    public void saveConfig(Player player) {
    }
    /**
     * Verifica si la configuración de un jugador es válida.
     *
     * @param player El objeto Player cuya configuración será verificada.
     * @return `true` si la configuración es válida, `false` en caso contrario.
     * Actualmente, siempre retorna `true`, pero debería contener lógica de validación.
     */
    public boolean veifyConfig(Player player) {
        return true;
    }

}
