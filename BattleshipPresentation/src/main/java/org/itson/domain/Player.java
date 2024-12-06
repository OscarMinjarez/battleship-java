package org.itson.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player implements Serializable{
    private String name;
    private PlayerColor colors;
    private Table table;
    private boolean isReady; 
    
    public Player() {
        this.table = new Table();
        this.colors = new PlayerColor();
    }
}