package org.itson.domain;

import java.io.Serializable;
import lombok.Data;

@Data
public abstract class AbstractShip implements Serializable {

    private Orientation orientation;
    private ShootingPoint[] position;
    private ShipState state;
    private Color color;
    private int size;
    
    public AbstractShip() {
        this.position = new ShootingPoint[1];
        this.position[0] = new ShootingPoint(true, new Coordinate(3, 3), true);
    }
}
