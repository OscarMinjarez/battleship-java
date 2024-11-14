
package org.itson.presentation.config;

import domain.Player;
import org.itson.presentation.config.ConfigModel;
import org.itson.presentation.config.IConfigObserver;

public class ConfigModelView implements IConfigObserver {

    private static ConfigModelView instance;
    private ConfigModel configModel;
    private FrmBattleship frmBattleship;

    private ConfigModelView() {

    }

    public static ConfigModelView getInstance() {
        if (ConfigModelView.instance == null) {
            ConfigModelView.instance = new ConfigModelView();
        }
        return ConfigModelView.instance;
    }

    @Override
    public void update() {
    }

    public void saveConfig(Player player) {
        this.configModel.saveConfig(player);
    }
}
