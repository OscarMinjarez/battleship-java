package org.itson.domain;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Table implements Serializable {

    private ShootingPoint[] matriz;
    private AbstractShip[] ships;
}
