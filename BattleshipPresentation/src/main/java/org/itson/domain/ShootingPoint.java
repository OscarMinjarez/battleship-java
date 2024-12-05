package org.itson.domain;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ShootingPoint implements Serializable {

    private boolean impact;
    private Coordinate coordiante;
    private boolean containsShip;
}
