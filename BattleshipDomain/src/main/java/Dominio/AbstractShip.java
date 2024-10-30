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
    
    /** 
     * 
     *  
     */
    public Orientation getOrientation() {
        return orientation;
    }
    
    /** 
     * 
     *  
     */
    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }
    
    /** 
     * 
     *  
     */
    public ShootingPoint[] getPosition() {
        return position;
    }

    /** 
     * 
     *  
     */
    public void setPosition(ShootingPoint[] position) {
        this.position = position;
    }
    
    /** 
     * 
     *  
     */
    public ShipState getState() {
        return state;
    }
    
    /** 
     * 
     *  
     */
    public void setState(ShipState state) {
        this.state = state;
    }
    
    /** 
     * 
     *  
     */
    public Color getColor() {
        return color;
    }
    
    /** 
     * 
     *  
     */
    public void setColor(Color color) {
        this.color = color;
    }
    
    /** 
     * 
     *  
     */
    public int getSize() {
        return size;
    }

    /** 
     * 
     *  
     */
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "AbstractShip{" + "orientation=" + orientation + ", position=" + position + ", state=" + state + ", color=" + color + ", size=" + size + '}';
    }

}