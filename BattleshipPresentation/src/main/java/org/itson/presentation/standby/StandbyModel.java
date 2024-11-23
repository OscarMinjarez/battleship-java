package org.itson.presentation.standby;

public class StandbyModel {
    
    private static StandbyModel instance;
    private IStandbyObserver standbyObserver;
    
    private StandbyModel() {
        
    }
    
    public static StandbyModel getInstance() {
        if (StandbyModel.instance == null) {
            StandbyModel.instance = new StandbyModel();
        }
        return StandbyModel.instance;
    }
    
    public void setStandbyObserver(IStandbyObserver standbyObserver) {
        this.standbyObserver = standbyObserver;
    }
    
    public void update() {
        
    }
}
