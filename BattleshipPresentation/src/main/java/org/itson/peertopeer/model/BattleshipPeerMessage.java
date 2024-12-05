package org.itson.peertopeer.model;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * Clase que representa un mensaje.
 * Almacena un mapa con datos clave-valor que describen el mensaje.
 */
public class BattleshipPeerMessage {

    private Map<String, Object> message;
}
