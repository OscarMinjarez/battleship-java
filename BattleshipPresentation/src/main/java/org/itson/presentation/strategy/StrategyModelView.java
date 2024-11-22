
package org.itson.presentation.strategy;

import domain.Ship;
import java.awt.Color;
import java.awt.List;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JButton;
import org.itson.presentation.strategy.IStrategyObserver;
import org.itson.presentation.strategy.StrategyModel;
import org.itson.presentation.strategy.StrategyView;



/**
 *
 * @author PabloCeasxr
 */
public class StrategyModelView implements IStrategyObserver {
    private StrategyModel strategyModel;
    private final java.util.List<IStrategyObserver> observers;

    public StrategyModelView(StrategyModel strategyModel) {
        this.strategyModel = strategyModel;
        this.strategyModel.addObserver(this); // El ViewModel observa al Modelo
        observers = new ArrayList<>();
    }

    public void addObserver(IStrategyObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(IStrategyObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (IStrategyObserver observer : observers) {
            observer.update();
        }
    }

    public Map<String, Integer> getShipsAvailable() {
        return strategyModel.getShipsAvailable();
    }

    public boolean canPlaceShip(int startIndex, int shipSize, boolean horizontalOrientation, JButton[] gridButtons) {
        int row = startIndex / 10;

        for (int i = 0; i < shipSize; i++) {
            int checkIndex = horizontalOrientation ? startIndex + i : startIndex + i * 10;

            if (checkIndex >= gridButtons.length) {
                return false;
            }

            int checkRow = checkIndex / 10;

            if (horizontalOrientation && checkRow != row) {
                return false;
            }

            if (gridButtons[checkIndex].getBackground() == Color.RED) {
                return false;
            }
        }
        return true;
    }

    public void placeShip(int startIndex, int shipSize, boolean horizontalOrientation, JButton[] gridButtons) {
        for (int i = 0; i < shipSize; i++) {
            int paintIndex = horizontalOrientation ? startIndex + i : startIndex + i * 10;
            gridButtons[paintIndex].setBackground(Color.RED);
        }
        notifyObservers(); // Notificar a los observadores (Vista) sobre los cambios
    }

    public void handleShipPlacement(String shipType) {
        strategyModel.placeShip(shipType);
    }

    @Override
    public void update() {
        notifyObservers(); // Propagar la notificación a los observadores (Vista)
    }
}