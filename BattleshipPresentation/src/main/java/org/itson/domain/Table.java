package org.itson.domain;

import java.io.Serializable;
import lombok.Data;

@Data
public class Table implements Serializable {

    private ShootingPoint[] matriz;
    private AbstractShip[] ships;

    public Table() {
        this.matriz = new ShootingPoint[100];
    }
    
    
    public boolean shoot(int index){
        ShootingPoint shootingPoint = this.matriz[index]; 
        shootingPoint.setImpact(true);
        for(AbstractShip ship : this.ships){
            for(ShootingPoint point : ship.getPosition()){
                if(point.getCoordiante() == shootingPoint.getCoordiante()){
                    point.setImpact(true);
                    return true;
                }
            }
       }
       return false;
    }
}
