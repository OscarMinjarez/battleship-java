
package org.itson.presentation.strategy;

import Dominio.Player;
import Dominio.Ship;

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

    public void putShipOnTable(Ship ship) {

    }

    private boolean verifyPosition() {
        return true;
    }

    

}
