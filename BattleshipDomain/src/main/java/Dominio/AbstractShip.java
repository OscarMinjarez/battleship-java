package Dominio;

import java.io.*;
import java.util.*;

/**
 * 
 */
public abstract class AbstractShip {

    /**
     * Default constructor
     */
    public AbstractShip() {
    }

    /**
     * 
     */
    private Orientation orientation;

    /**
     * 
     */
    private ShootingPoint[] position;

    /**
     * 
     */
    private ShipState state;

    /**
     * 
     */
    private Color color;

    /**
     * 
     */
    private int size;

}