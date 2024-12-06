package org.itson.domain;

import java.io.Serializable;
import lombok.Data;

@Data
public class Table implements Serializable {

    private ShootingPoint[] matriz;
    private AbstractShip[] ships;

    public Table() {
        this.matriz = new ShootingPoint[100];
        for (int i = 0; i < this.matriz.length; i++) {
            ShootingPoint shootingPoint = new ShootingPoint();
            matriz[i] = shootingPoint;
        }
        this.ships = new AbstractShip[10];
        for (int i = 0; i < this.ships.length; i++) {
            AbstractShip ship = new Ship();
            ships[i] = ship;
        }
    }

    public boolean shoot(int index) {
        ShootingPoint shootingPoint = this.matriz[index];
        shootingPoint.setImpact(true);
        for (AbstractShip ship : this.ships) {
            for (ShootingPoint point : ship.getPosition()) {
                if (
                        point.getCoordiante().getX() == shootingPoint.getCoordiante().getX() &&
                        point.getCoordiante().getY() == shootingPoint.getCoordiante().getY()
                        ) {
                    point.setImpact(true);
                    return true;
                }
            }
        }
        return false;
    }
}
