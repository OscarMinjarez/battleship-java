package org.itson.peertopeer.facade;

import java.io.IOException;
import org.itson.presentation.contracts.IBusinessObserver;

/**
 * Interfaz para definir las operaciones principales de la comunicación peer-to-peer
 * en el juego Battleship.
 */
public interface IBattleshipPeerToPeerFacade {

    /**
     * Inicia el servidor en un puerto específico para escuchar conexiones entrantes.
     * 
     * @param port Puerto en el que se iniciará el nodo.
     * @throws IOException Si ocurre un error al iniciar el nodo.
     */
    void run(int port) throws IOException;

    /**
     * Conecta el cliente a un servidor en el puerto especificado en la máquina local.
     * 
     * @param port Puerto al que se conectará el nodo.
     */
    void connect(int port);

    /**
     * Conecta el cliente a un servidor en un host y puerto específicos.
     * 
     * @param host Dirección del host al que se conectará el nodo.
     * @param port Puerto al que se conectará el nodo.
     */
    void connect(String host, int port);

    /**
     * Envía un objeto a través de la conexión peer-to-peer.
     * 
     * @param object Objeto que se desea enviar.
     * @throws IOException Si ocurre un error al enviar el objeto.
     */
    void writeObject(Object object) throws IOException;

    /**
     * Asigna un observador de negocio para procesar eventos o mensajes del nodo.
     * 
     * @param businessObserver Instancia de IBusinessObserver que procesará los eventos.
     */
    void setBusinessObserver(IBusinessObserver businessObserver);
}
