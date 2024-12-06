package org.itson.peertopeer.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import org.itson.peertopeer.IServerObserver;

/**
 * Clase que representa un cliente en un sistema peer-to-peer para el juego Battleship.
 * Se encarga de gestionar la comunicación con el servidor a través de sockets.
 */
public class BattleshipPeerClient implements AutoCloseable {

    private Socket socket;
    private ObjectOutputStream output;
    private ObjectInputStream input;

    private IServerObserver serverObserver;

    /**
     * Constructor que inicializa el cliente utilizando la dirección IP local.
     * 
     * @param port Puerto al que se conecta el cliente.
     * @throws IOException Si ocurre un error al establecer la conexión.
     */
    public BattleshipPeerClient(int port) throws IOException {
        InetAddress ip = InetAddress.getLocalHost();
        this.socket = new Socket(ip, port);
        System.out.println("Client started in: " + ip + ":" + port);
        this.output = new ObjectOutputStream(this.socket.getOutputStream());
        this.input = new ObjectInputStream(this.socket.getInputStream());
        this.start();
    }

    /**
     * Constructor que inicializa el cliente utilizando un host específico.
     * 
     * @param host Dirección del host al que se conecta el cliente.
     * @param port Puerto al que se conecta el cliente.
     * @throws IOException Si ocurre un error al establecer la conexión.
     */
    public BattleshipPeerClient(String host, int port) throws IOException {
        this.socket = new Socket(host, port);
        System.out.println("Client connected in: " + host + ":" + port);
        this.output = new ObjectOutputStream(this.socket.getOutputStream());
        this.input = new ObjectInputStream(this.socket.getInputStream());
        this.start();
    }

    /**
     * Asigna un observador del servidor para procesar los mensajes recibidos.
     * 
     * @param serverObserver Instancia de IServerObserver.
     */
    public void setServerObserver(IServerObserver serverObserver) {
        this.serverObserver = serverObserver;
    }

    /**
     * Envía un objeto al servidor a través del flujo de salida.
     * 
     * @param object Objeto que se desea enviar.
     * @throws IOException Si ocurre un error al escribir en el flujo de salida.
     */
    public void writeObject(Object object) throws IOException {
        if (this.output == null) {
            this.output = new ObjectOutputStream(this.socket.getOutputStream());
        }
        this.output.writeObject(object);
    }

    /**
     * Inicia un hilo para escuchar y procesar los mensajes del servidor de manera continua.
     */
    private void start() {
        new Thread(() -> {
            try {
                Object object;
                while ((object = this.input.readObject()) != null) {
                    this.serverObserver.send(object);
                }
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Connection error: " + e.getMessage());
            }
        }).start();
    }

    /**
     * Cierra la conexión del socket y libera los recursos asociados.
     * 
     * @throws IOException Si ocurre un error al cerrar el socket.
     */
    @Override
    public void close() throws IOException {
        this.socket.close();
    }
}
