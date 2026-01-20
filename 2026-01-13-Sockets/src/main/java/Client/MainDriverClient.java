package Client;

import java.io.IOException;

public class MainDriverClient {
    public static void main(String[] args) throws IOException {
        Client client = new Client();

        client.startConnection("localhost", 6666);

        client.sendGetNameMessage();


        client.stop();
    }
}
