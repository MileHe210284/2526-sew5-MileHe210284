package Client;

import java.io.IOException;

public class TestdriverClient {
    public static void main(String[] args) throws IOException {
        Client c = new Client();
        c.startConnection("localhost", 6666);

        c.stopConnection();
    }
}
