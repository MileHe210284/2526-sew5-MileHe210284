package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private Socket clientSocket;
    private BufferedReader in;
    private PrintWriter out;

    public void startConnection(String host, int port) throws IOException {
        clientSocket = new Socket(host, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public String sendAndReadMessage(String message) throws IOException {
        if(clientSocket != null) {
            System.out.println("sends: " + message);
            out.println(message);
            String answer = in.readLine();
            System.out.println("received: " + answer);
            return answer;
        }
        return null;
    }

    public void stopConnection() throws IOException {
        out.close();
        in.close();
        clientSocket.close();
    }

}
