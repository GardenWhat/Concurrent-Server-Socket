import java.io.*;
import java.net.*;

public class ServerRequest extends Thread {
    private Socket socket;
    
   public ServerRequest(Socket socket) {
      this.socket = socket;
      }

   public void run() {
      try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            String command = reader.readLine();
            CommandProcessor commandProcessor = new CommandProcessor();
            String result = commandProcessor.process(command);

            System.out.println(result);
            writer.println(result);

            socket.close();
         } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
   }
}