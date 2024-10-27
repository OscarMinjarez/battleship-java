
package org.itson.battleshippresentation.modelView;

import Dominio.Player;
import org.itson.battleshippresentation.model.ConfigModel;
import org.itson.battleshippresentation.model.IConfigObserver;

/**
 *
 * @author PabloCeasxr
 */
public class ConfigModelView implements IConfigObserver {

    private static ConfigModelView instance;
    private ConfigModel configModel;

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
