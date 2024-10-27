
package org.itson.battleshippresentation.model;

import Dominio.Player;

/**
 *
 * @author PabloCeasxr
 */
public class StrategyModel {

    private Player player;
    private static StrategyModel instance;
    private IStrategyObserver iStrategyObserver;

    private StrategyModel() {

    }

    public void update() {
    }
    public static StrategyModel getInstance() {
        if (instance == null) {
            instance = new StrategyModel();
        }
        return instance;
    }

    public void setPlayerReady(boolean value) {

    }

    public void putShipOnTable(int ship) {

    }

    private boolean verifyPosition() {
        return true;
    }

    

}
