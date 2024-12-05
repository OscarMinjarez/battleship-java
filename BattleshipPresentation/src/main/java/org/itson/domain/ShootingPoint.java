package org.itson.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ShootingPoint implements Serializable {

    private boolean impact;
    private Coordinate coordiante;
    private boolean containsShip;
    
    public ShootingPoint() {
        this.coordiante = new Coordinate(3, 3);
    }
}
