package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientHandler implements Runnable{
    private static int coutner =0;
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public void start(int port) throws IOException {

    }

    public ClientHandler(Socket socket){
        coutner++;
        this.socket = socket;
        System.out.println("client # "+ coutner+ " connected");
    }

    @Override
    public void run() {
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );
            String line;
            while (true) {
                try {
                    if (!((line = in.readLine()) != null)) break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Received: " + line);
                out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally{
            out.close();
            try {
                in.close();
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
