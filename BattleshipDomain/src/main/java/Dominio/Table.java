package Dominio;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class Table {

    /**
     * Arreglo de objetos ShootingPoint.
     */
    private ShootingPoint[] matriz;

    /**
     * Arreglo de objetos AbstractShip.
     */
    private AbstractShip[] ships;

    /**
     * Constructor por defecto.
     */
    public Table(ShootingPoint[] matriz, AbstractShip[] ships) {
        this.matriz = matriz;
        this.ships = ships;
    }

    /** 
     * 
     *  
     */
    public ShootingPoint[] getMatriz() {
        return matriz;
    }

    /** 
     * 
     *  
     */
    public void setMatriz(ShootingPoint[] matriz) {
        this.matriz = matriz;
    }

    /** 
     * 
     *  
     */
    public AbstractShip[] getShips() {
        return ships;
    }

    /** 
     * 
     *  
     */
    public void setShips(AbstractShip[] ships) {
        this.ships = ships;
    }
    
    

    /** 
     * 
     *  
     */
    @Override
    public String toString() {
        return "Table{" + "matriz=" + matriz + ", ships=" + ships + '}';
    }

      
}