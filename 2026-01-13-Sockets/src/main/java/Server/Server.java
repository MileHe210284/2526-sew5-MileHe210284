package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

;

public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private Person person;

    public void run(int port) throws IOException {

        serverSocket = new ServerSocket( port);
        clientSocket = serverSocket.accept();
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream())
        );
    }

    public void setPerson(Person person){
        this.person = person;

    }


    public void receiveAndSend() throws IOException {
        //echoserver
        String line;
        while( (line = in.readLine()) != null){

            System.out.println("received: "+line);

            String s[] = line.split(" ");
        }
    }
    private void handleSet(String s[]){
        if(s.length < 3){
            out.println("false");
            return;
        }
          if(s[0].equalsIgnoreCase("Set")){
            //set message
            if(s[1].equalsIgnoreCase("name")){
                person = new Person(s[2], person.role());
                out.println("true");
            }
            else if(s[1].equalsIgnoreCase("role")){
                person = new Person(person.name(), s[2]);
                out.println("true");
            }
            else{
                out.println("false");
            }
        }
        else{
            System.out.println("unknown message");
            out.println("unknown message");
        }
    }

    private void handleGet(String s[]){
        if(s.length < 2){
            out.println("false");
            return;
        }
        if(s[0].equalsIgnoreCase("Get")){
            //get message
            if(s[1].equalsIgnoreCase("name")){
                out.println(person.name());
            }
            else if(s[1].equalsIgnoreCase("role")){
                out.println(person.role());
            }
            else{
                out.println("unknown get command");
            }
        }
    }


    public void stop() throws IOException {

            out.close();
            in.close();
            clientSocket.close();
            serverSocket.close();

    }

}
