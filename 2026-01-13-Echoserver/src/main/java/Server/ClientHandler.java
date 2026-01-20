package Client;

import java.net.Socket;

public class ClientHandler implements Runnable{
    private static int coutner =0;
    private Socket socket;

    public ClientHandler(Socket socket){
        coutner++;
        this.socket = socket;
        System.out.println("client # "+ coutner+ " connected");
    }

    @Override
    public void run() {

    }
}
