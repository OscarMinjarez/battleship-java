package org.itson.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player implements Serializable{
     private String name;
    private PlayerColor colors;
    private Table table;
    private boolean isReady; 
    

  
   
}