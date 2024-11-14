package domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player implements Serializable {

    private String name;
    private Table table;
    private PlayerColor colors;
    
    public Player(String name) {
        this.name = name;
    }
}
