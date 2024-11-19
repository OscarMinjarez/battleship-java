package org.itson.peertopeer.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandler {

    private Socket socket;
    private ObjectInputStream input;
    private ObjectOutputStream output;

    public ClientHandler(Socket socket) throws IOException {
        this.socket = socket;
        this.output = new ObjectOutputStream(this.socket.getOutputStream());
        this.input = new ObjectInputStream(this.socket.getInputStream());
    }

    public Object readObject() throws IOException, ClassNotFoundException {
        return this.input.readObject();
    }

    public void writeObject(Object object) throws IOException {
        this.output.writeObject(object);
    }

    public void close() {
        try {
            this.   socket.close();
        } catch (IOException e) {
            System.err.println("Error closing client socket: " + e.getMessage());
        }
    }
}