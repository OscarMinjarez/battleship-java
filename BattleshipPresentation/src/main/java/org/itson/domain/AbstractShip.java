package org.itson.domain;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class AbstractShip implements Serializable {

    private Orientation orientation;
    private ShootingPoint[] position;
    private ShipState state;
    private Color color;
    private int size;
}
