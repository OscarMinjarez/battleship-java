package Dominio;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class ShootingPoint {

    /**
     * Default constructor
     */
    public ShootingPoint() {
    }

    /**
     * 
     */
    private boolean impact;

    /**
     * 
     */
    private Coordiante coordiante;

    /** 
     * 
     *  
     */
    public boolean isImpact() {
        return impact;
    }

    /** 
     * 
     *  
     */
    public void setImpact(boolean impact) {
        this.impact = impact;
    }

    /** 
     * 
     *  
     */
    public Coordiante getCoordiante() {
        return coordiante;
    }

    /** 
     * 
     *  
     */
    public void setCoordiante(Coordiante coordiante) {
        this.coordiante = coordiante;
    }

    /** 
     * 
     *  
     */
    @Override
    public String toString() {
        return "ShootingPoint{" + "impact=" + impact + ", coordiante=" + coordiante + '}';
    }

}