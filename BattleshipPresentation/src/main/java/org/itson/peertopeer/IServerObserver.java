package org.itson.peertopeer;

public interface IServerObserver {
    
    /**
     * Método para manejar el envío de un objeto desde el servidor.
     * Este método es llamado cuando el servidor recibe un objeto y
     * necesita notificar al observador sobre dicho evento.
     *
     * @param object El objeto recibido que debe enviarse a otro componente.
     */

    void send(Object object);
}
