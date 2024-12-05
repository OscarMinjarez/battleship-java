package org.itson.domain;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Coordinate implements Serializable {

    private int x;
    private int y;
}
