package Server;

import java.io.IOException;

public class TestdriverServer {
    public static void main(String[] args) throws IOException {
        Server s = new Server();
        s.start(6666);
        s.receiveAndSend();
        s.stop();
    }
}
