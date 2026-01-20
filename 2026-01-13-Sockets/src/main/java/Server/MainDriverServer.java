package Server;

import java.io.IOException;

public class MainDriverServer {
    public static void main(String[] args) throws IOException {

    Server server = new Server();
    server.run(6666);
    server.setPerson(new Person("Hamza", "Admin"));
    server.receiveAndSend();


    server.stop();

    }
}
