package org.itson.peertopeer;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;
import org.itson.peertopeer.model.BattleshipPeerMessage;
import org.itson.peertopeer.client.BattleshipPeerClient;
import org.itson.peertopeer.server.BattleshipPeerServer;
import org.itson.presentation.contracts.IBusinessObserver;

/**
 * BattleshipPeerNode es una clase Singleton que actúa como un nodo para el
 * sistema de comunicación peer-to-peer (P2P). Esta clase maneja tanto las
 * conexiones de servidor como las de cliente y es responsable de enviar y
 * recibir mensajes entre nodos.
 */
public class BattleshipPeerNode implements IServerObserver {

    // Instancia única de la clase para garantizar el patrón Singleton.
    // Cliente para manejar la conexión P2P.
    // Observador encargado de manejar la lógica de negocio al recibir mensajes.
    private static BattleshipPeerNode instance;
    private BattleshipPeerClient peerClient;
    private IBusinessObserver businessObserver;

    /**
     * Constructor privado para evitar la creación de múltiples instancias. Se
     * utiliza el patrón Singleton.
     */
    private BattleshipPeerNode() {

    }

    /**
     * Método estático para obtener la instancia única de BattleshipPeerNode. Si
     * no existe una instancia, la crea.
     *
     * @return La instancia única de BattleshipPeerNode.
     */
    public static BattleshipPeerNode getInstance() {
        if (BattleshipPeerNode.instance == null) {
            BattleshipPeerNode.instance = new BattleshipPeerNode();
        }
        return BattleshipPeerNode.instance;
    }

    /**
     * Inicia un servidor en un puerto específico y lo ejecuta en un nuevo hilo.
     *
     * @param port El puerto en el que el servidor debe ejecutarse.
     * @throws IOException Si ocurre un error al iniciar el servidor.
     */
    public void run(int port) throws IOException {
        new Thread(() -> {
            try {
                BattleshipPeerServer server = new BattleshipPeerServer(port);
                server.setServerObserver(this);
                server.runServer();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }).start();
    }

    /**
     * Conecta este nodo a otro nodo usando un puerto específico.
     *
     * @param port El puerto del nodo al que se desea conectar.
     */
    public void connect(int port) {
        try {
            this.peerClient = new BattleshipPeerClient(port);
            this.peerClient.setServerObserver(this);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Conecta este nodo a otro nodo utilizando una dirección y un puerto
     * específicos.
     *
     * @param host La dirección del nodo al que se desea conectar.
     * @param port El puerto del nodo al que se desea conectar.
     */
    public void connect(String host, int port) {
        try {
            this.peerClient = new BattleshipPeerClient(host, port);
            this.peerClient.setServerObserver(this);
            Map<String, Object> data = new HashMap<>();
            data.put("status", "connected");
            data.put("host", host);
            data.put("port", port);
            data.put("timestamp", System.currentTimeMillis());
            this.businessObserver.notify(new BattleshipPeerMessage(data));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            Map<String, Object> errorData = new HashMap<>();
            errorData.put("status", "error");
            errorData.put("message", e.getMessage());
            this.businessObserver.notify(new BattleshipPeerMessage(errorData));
        }
    }

    /**
     * Envía un objeto al nodo remoto a través del cliente.
     *
     * @param object El objeto que se desea enviar.
     * @throws IOException Si ocurre un error al enviar el objeto.
     */
    public void writeObject(Object object) throws IOException {
        this.peerClient.writeObject(object);
    }

    /**
     * Método de la interfaz IServerObserver para manejar los objetos recibidos.
     * Llama al observador de negocio para notificar sobre el mensaje recibido.
     *
     * @param object El objeto recibido del nodo remoto.
     */
    @Override
    public void send(Object object) {
        this.businessObserver.notify(object);
    }

    /**
     * Establece el observador de negocio para manejar eventos relacionados con
     * los mensajes recibidos.
     *
     * @param businessObserver El observador de negocio.
     */
    public void setBusinessObserver(IBusinessObserver businessObserver) {
        this.businessObserver = businessObserver;
    }

    /**
     * Cierra la conexión del cliente de manera segura.
     */
    public void close() {
        try {
            this.peerClient.close();
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
