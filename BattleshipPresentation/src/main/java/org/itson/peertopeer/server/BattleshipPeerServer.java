package org.itson.peertopeer.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.itson.peertopeer.model.BattleshipPeerMessage;
import org.itson.peertopeer.IServerObserver;

/**
 * Clase que representa un servidor para la comunicación peer-to-peer en el juego Battleship.
 * Gestiona conexiones entrantes de clientes, envía y recibe mensajes entre los nodos.
 */
public class BattleshipPeerServer {
    
    private ServerSocket serverSocket;
    private CopyOnWriteArrayList<ClientHandler> clients;
    
    private IServerObserver serverObserver;

    /**
     * Constructor que inicializa el servidor en un puerto específico.
     * 
     * @param port Puerto donde se ejecutará el servidor.
     * @throws IOException Si ocurre un error al iniciar el servidor.
     */
    public BattleshipPeerServer(int port) throws IOException {
        this.clients = new CopyOnWriteArrayList<>();
        this.serverSocket = new ServerSocket(port);
    }
    
    /**
     * Establece el observador del servidor para manejar eventos y mensajes recibidos.
     * 
     * @param serverObserver Instancia de IServerObserver.
     */
    public void setServerObserver(IServerObserver serverObserver) {
        this.serverObserver = serverObserver;
    }

    /**
     * Inicia el servidor para aceptar conexiones de clientes y manejar mensajes entrantes.
     */
    public void runServer() {
        new Thread(() -> {
            Map<String, Object> data = new HashMap<>();
            data.put("port", this.serverSocket.getLocalPort());
            System.out.println("Port from server..." + this.serverSocket.getLocalPort());
            this.serverObserver.send(
                    new BattleshipPeerMessage(
                            data
                    )
            );
        }).start();
        while (true) {
            try {
                Socket socket = this.serverSocket.accept();
                Map<String, Object> data = new HashMap<>();
                data.put("client", socket);
                new Thread(() -> {
                    System.out.println("Client connected..." + socket.getInetAddress() + ":" + socket.getLocalPort());
                    this.serverObserver.send(
                            new BattleshipPeerMessage(
                                    data
                            )
                    );
                }).start();
                ClientHandler clientHandler = new ClientHandler(socket);
                this.clients.add(clientHandler);
                new Thread(clientHandler).start();
            } catch (IOException e) {
                System.out.println("Error accepting connection: " + e.getMessage());
            }
        }
    }

    /**
     * Envía un mensaje a todos los clientes conectados.
     * 
     * @param message Mensaje que se desea enviar.
     */
    public void broadcast(Object message) {
        for (ClientHandler client : this.clients) {
            client.sendMessage(message);
        }
    }

    /**
     * Clase interna que maneja la conexión con un cliente específico.
     */
    private class ClientHandler implements Runnable {

        private Socket socket;
        private ObjectOutputStream output;
        private ObjectInputStream input;

        /**
         * Constructor que inicializa un manejador para un cliente.
         * 
         * @param socket Socket de la conexión del cliente.
         * @throws IOException Si ocurre un error al inicializar los flujos de entrada/salida.
         */
        public ClientHandler(Socket socket) throws IOException {
            this.socket = socket;
            this.output = new ObjectOutputStream(this.socket.getOutputStream());
            this.input = new ObjectInputStream(this.socket.getInputStream());
        }

        /**
         * Hilo que gestiona la recepción de mensajes del cliente.
         */
        @Override
        public void run() {
            try {
                Object message;
                while ((message = this.input.readObject()) != null) {
                    broadcast(message);
                }
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Connection error: " + e.getMessage());
            } finally {
                try {
                    this.socket.close();
                } catch (IOException e) {
                    System.out.println("Error closing socket: " + e.getMessage());
                }
                clients.remove(this);
            }
        }

        /**
         * Envía un mensaje al cliente conectado.
         * 
         * @param message Mensaje que se desea enviar.
         */
        public void sendMessage(Object message) {
            try {
                this.output.writeObject(message);
            } catch (IOException e) {
                System.out.println("Error sending message: " + e.getMessage());
            }
        }
    }
}
