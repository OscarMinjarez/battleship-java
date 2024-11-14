
package org.itson.presentation.config;

import domain.Player;

/**
 *
 * @author PabloCeasxr
 */
public class ConfigModel {

    private Player player;
    private static ConfigModel instance;
    private IConfigObserver iConfigObserver;

    private ConfigModel() {

    }

    public void update() {
    }

    public static ConfigModel getInstance() {
        if (instance == null) {
            return instance = new ConfigModel();
        }
        return instance;

    }

    public void saveConfig(Player player) {
    }

    public boolean veifyConfig(Player player) {
        return true;
    }

}
