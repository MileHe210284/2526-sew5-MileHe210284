package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream())
        );
    }

    public void receiveAndSend() throws IOException {
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println("Received: " + line);
            out.println(line);
        }
    }

    public void stop() throws IOException {
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}
