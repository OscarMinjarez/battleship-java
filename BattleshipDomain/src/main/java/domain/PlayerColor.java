package domain;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PlayerColor implements Serializable {

    private Color fake;
    private Color real;
}