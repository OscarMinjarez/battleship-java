package org.itson.presentation.strategy;

import java.util.Map;
import lombok.Setter;
import org.itson.presentation.contracts.IBusinessObserver;
import org.itson.presentation.contracts.IModelObserver;

public class StrategyBusiness implements IBusinessObserver {

    private static StrategyBusiness instance;
    private final StrategyModel model;

    @Setter
    private IModelObserver modelObserver;

    private StrategyBusiness() {
        this.model = StrategyModel.getInstance();
    }

    public static StrategyBusiness getInstance() {
        if (instance == null) {
            instance = new StrategyBusiness();
        }
        return instance;
    }

    public Map<String, Integer> getShipsAvailable() {
    return model.getShipsAvailable();
}
    public void placeShip(String shipType) {
        if (model.isShipAvailable(shipType)) {
            model.placeShip(shipType);
            notifyModelUpdate();
        } else {
            System.out.println("No more ships of this type available.");
        }
    }

   public boolean isShipAvailable(String shipType) {
    return model.isShipAvailable(shipType);
}

    

    private void notifyModelUpdate() {
        if (modelObserver != null) {
            modelObserver.notify(model.getShipsAvailable());
        }
    }

    @Override
    public void notify(Object object) {
        if (object instanceof Map<?, ?> shipsAvailable && modelObserver != null) {
            modelObserver.notify(shipsAvailable);
        }
    }
}
