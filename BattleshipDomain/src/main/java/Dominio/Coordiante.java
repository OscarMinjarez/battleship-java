package Dominio;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class Coordiante {

    /**
     * Default constructor
     */
    public Coordiante() {
    }

    /**
     * 
     */
    private int x;

    /**
     * 
     */
    private int y;

    /** 
     * 
     *  
     */
    public int getX() {
        return x;
    }
    
    /** 
     * 
     *  
     */
    public void setX(int x) {
        this.x = x;
    }
    
    /** 
     * 
     *  
     */
    public int getY() {
        return y;
    }
    
    /** 
     * 
     *  
     */
    public void setY(int y) {
        this.y = y;
    }
    
    /** 
     * 
     *  
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.x;
        hash = 41 * hash + this.y;
        return hash;
    }
    
    /** 
     * 
     *  
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Coordiante other = (Coordiante) obj;
        if (this.x != other.x) {
            return false;
        }
        return this.y == other.y;
    }
    /** 
     * 
     *  
     */
    @Override
    public String toString() {
        return "Coordiante{" + "x=" + x + ", y=" + y + '}';
    }
    
}