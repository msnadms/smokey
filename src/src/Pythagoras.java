import java.io.*;
import java.net.*;
/*
* Pythagoras Server
* @author Mason Adams
* @version 1
* Named Pythagoras because its fucking crazy
*
*/
public class Pythagoras {

    private final ServerSocket serverSocket;

    public Pythagoras() throws IOException {

        serverSocket = new ServerSocket(8008);

    }

    public void stopServer() throws IOException {
        serverSocket.close();
    }

    public static void main(String[] args) throws IOException {

        Pythagoras server = new Pythagoras();
        boolean cont = true;
        while (cont) {
            server.acceptClient();
        }

    }


    public void acceptClient() {
        Aesara clientThread;
        Socket socket;

        try {
            socket = serverSocket.accept();
            clientThread = new Aesara(new ObjectInputStream(socket.getInputStream()),
                    new ObjectOutputStream(socket.getOutputStream()), this);
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return;
        }

        Thread thread = new Thread(clientThread);
        thread.start();
    }






}
