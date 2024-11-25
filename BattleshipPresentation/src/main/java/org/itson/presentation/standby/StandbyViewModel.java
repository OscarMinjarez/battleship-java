package org.itson.presentation.standby;

public class StandbyViewModel implements IStandbyObserver {
    
    private static StandbyViewModel instance;
    private StandbyModel standbyModel;
    private StandbyView standbyView;
    
    private StandbyViewModel() {
        this.standbyView = StandbyView.getInstance();
        this.standbyModel = StandbyModel.getInstance();
        this.standbyModel.setStandbyObserver(this);
    }
    
    public static StandbyViewModel getInstance() {
        if (StandbyViewModel.instance == null) {
            StandbyViewModel.instance = new StandbyViewModel();
        }
        return StandbyViewModel.instance;
    }
    
    public void showStandbyScreen() {
        this.standbyView.showStandbyScreen();
    }
    
    @Override
    public void update(Object object) {
        this.standbyView.update(object);
    }
}
