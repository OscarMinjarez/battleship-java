package domain;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Coordiante implements Serializable {

    private int x;
    private int y;
}
