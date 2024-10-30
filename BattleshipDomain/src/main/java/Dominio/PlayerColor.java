package Dominio;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class PlayerColor {

    /**
     * Default constructor
     */
    public PlayerColor() {
    }

    /**
     * 
     */
    private Color fake;

    /**
     * 
     */
    private Color real;

    public Color getFake() {
        return fake;
    }

    public void setFake(Color fake) {
        this.fake = fake;
    }

    public Color getReal() {
        return real;
    }

    public void setReal(Color real) {
        this.real = real;
    }

    @Override
    public String toString() {
        return "PlayerColor{" + "fake=" + fake + ", real=" + real + '}';
    }
    
}