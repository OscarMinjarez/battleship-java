
package org.itson.presentation.config;

import org.itson.domain.Player;
import org.itson.presentation.config.ConfigModel;
import org.itson.presentation.config.IConfigObserver;

import org.itson.domain.Player;

/**
 * Model-View para manejar la configuración inicial del juego.
 * Actúa como intermediario entre FrmBattleship y ConfigModel.
 */
public class ConfigModelView {

    private static ConfigModelView instance;
    private ConfigModel configModel;

    private ConfigModelView() {
        configModel = ConfigModel.getInstance();
    }

    public static ConfigModelView getInstance() {
        if (instance == null) {
            instance = new ConfigModelView();
        }
        return instance;
    }

    /**
     * Guarda la configuración del jugador en el modelo.
     * @param player Jugador con la configuración seleccionada.
     */
    public void saveConfig(Player player) {
        configModel.saveConfig(player);
    }
}