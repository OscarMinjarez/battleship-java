
package org.itson.battleshippresentation.modelView;

import Dominio.Player;
import org.itson.battleshippresentation.model.ConfigModel;
import org.itson.battleshippresentation.model.IConfigObserver;
import org.itson.battleshippresentation.view.FrmBattleship;

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
