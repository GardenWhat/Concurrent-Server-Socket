import java.io.*;
import java.net.*;
import java.util.Scanner;

class Main extends Thread{

public static void main(String[]args){
    System.out.println("Enter a port number");
    Scanner portNumber = new Scanner(System.in);
    int port = Integer.parseInt(portNumber.next());

    // tries to open a server with the given port number
    try (ServerSocket server = new ServerSocket(port)) {

        System.out.println("Server is listening on port " + port);

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected");

            new ServerRequest(socket).start();
        }

    } catch (IOException e) {
        System.out.println("\nexception happened - here's what I know: ");
        e.printStackTrace();
        System.exit(-1);
    }
   }
}
