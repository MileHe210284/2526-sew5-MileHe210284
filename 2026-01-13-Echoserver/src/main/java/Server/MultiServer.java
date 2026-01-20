package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer {
    private ServerSocket serverSocket;

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        while(true){
            new Thread(new ClientHandler(serverSocket.accept())).start();
        }
    }

    public void stop() throws IOException {
        serverSocket.close();
    }
}
