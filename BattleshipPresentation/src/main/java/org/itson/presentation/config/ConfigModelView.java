
package org.itson.presentation.config;

import Dominio.Player;
import org.itson.presentation.config.ConfigModel;
import org.itson.presentation.config.IConfigObserver;

/**
 *
 * @author PabloCeasxr
 */
public class ConfigModelView implements IConfigObserver {

    private static ConfigModelView instance;
    private ConfigModel configModel;
    private FrmBattleship frmBattleship;

    private ConfigModelView() {

    }

    public static ConfigModelView getInstance() {
        if (instance == null) {
            instance = new ConfigModelView();
        }

        return instance;
    }

    @Override
    public void update() {
    }

    public void saveConfig(Player player) {
        this.configModel.saveConfig(player);
    }

}
