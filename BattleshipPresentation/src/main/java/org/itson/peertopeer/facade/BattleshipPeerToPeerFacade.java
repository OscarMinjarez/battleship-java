package org.itson.peertopeer.facade;

import java.io.IOException;
import org.itson.peertopeer.BattleshipPeerNode;
import org.itson.presentation.contracts.IBusinessObserver;

/**
 * Facade para gestionar la comunicación peer-to-peer en el juego Battleship.
 * Proporciona una interfaz simplificada para interactuar con el nodo principal del sistema.
 */
public class BattleshipPeerToPeerFacade implements IBattleshipPeerToPeerFacade {

    private final BattleshipPeerNode node;

    /**
     * Constructor que inicializa el facade y obtiene la instancia del nodo principal.
     */
    public BattleshipPeerToPeerFacade() {
        this.node = BattleshipPeerNode.getInstance();
    }

    /**
     * Inicia el nodo en un puerto específico para escuchar conexiones entrantes.
     * 
     * @param port Puerto en el que se iniciará el nodo.
     * @throws IOException Si ocurre un error al iniciar el nodo.
     */
    @Override
    public void run(int port) throws IOException {
        this.node.run(port);
    }

    /**
     * Conecta el nodo a otro nodo en el puerto especificado en la máquina local.
     * 
     * @param port Puerto al que se conectará el nodo.
     */
    @Override
    public void connect(int port) {
        this.node.connect(port);
    }

    /**
     * Conecta el nodo a otro nodo en un host y puerto específicos.
     * 
     * @param host Dirección del host al que se conectará el nodo.
     * @param port Puerto al que se conectará el nodo.
     */
    @Override
    public void connect(String host, int port) {
        this.node.connect(host, port);
    }

    /**
     * Envía un objeto a través de la conexión peer-to-peer.
     * 
     * @param object Objeto que se desea enviar.
     * @throws IOException Si ocurre un error al enviar el objeto.
     */
    @Override
    public void writeObject(Object object) throws IOException {
        this.node.writeObject(object);
    }

    /**
     * Asigna un observador de negocio para procesar eventos o mensajes del nodo.
     * 
     * @param businessObserver Instancia de IBusinessObserver que procesará los eventos.
     */
    @Override
    public void setBusinessObserver(IBusinessObserver businessObserver) {
        this.node.setBusinessObserver(businessObserver);
    }
}