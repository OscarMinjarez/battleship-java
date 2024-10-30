package Dominio;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class Player {

    /**
     * Default constructor
     */
    public Player() {
    }

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private Table table;

    /**
     * 
     */
    private PlayerColor colors;

    /** 
     * 
     *  
     */
    public String getName() {
        return name;
    }
    
    /** 
     * 
     *  
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /** 
     * 
     *  
     */
    public Table getTable() {
        return table;
    }
    
    /** 
     * 
     *  
     */
    public void setTable(Table table) {
        this.table = table;
    }
    
    /** 
     * 
     *  
     */
    public PlayerColor getColors() {
        return colors;
    }
    
    /** 
     * 
     *  
     */
    public void setColors(PlayerColor colors) {
        this.colors = colors;
    }
    
    /** 
     * 
     *  
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.name);
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
        final Player other = (Player) obj;
        return Objects.equals(this.name, other.name);
    }

    /** 
     * 
     *  
     */
    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", table=" + table + ", colors=" + colors + '}';
    }
    
}