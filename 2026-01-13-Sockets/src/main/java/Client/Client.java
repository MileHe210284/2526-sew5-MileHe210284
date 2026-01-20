package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;



public class Client {
    Socket socket;
    PrintWriter out;
    BufferedReader in;

    public void startConnection(String ip, int port) throws IOException {
        socket = new Socket( ip , port);
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
    }
    public String sendAndReadMessage(String message) throws IOException {
            System.out.println("client.Client send:  " + message);
            out.println(message);
            String answer = in.readLine();
            System.out.println("client.Client received: " + answer);

        return answer;
    }

    public void sendGetNameMessage() throws IOException {
        String answer = sendAndReadMessage("Get name");

        if(answer.equalsIgnoreCase("false")){
            System.out.println("Error calling get name!");
        }
        else{
            System.out.println("received name: " +answer);
        }
    }

    public void setNameMessage() throws IOException {

        String answer2 = sendAndReadMessage("Set name Abdullah");

        System.out.println("Set name: "+answer2);

    }
    public void stop() throws IOException {

          out.close();
          in.close();
          socket.close();

    }
}
