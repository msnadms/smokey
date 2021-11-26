import java.io.*;
import java.net.*;
import java.util.Hashtable;
import java.util.Objects;
/**
* Pythagoras Server Database
* @author Mason Adams
* @version 1.0.0
* Named Pythagoras because its fucking crazy. Spawns server threads.
*
*/
public class Pythagoras {

    private final ServerSocket serverSocket;
    private final Hashtable<Integer, Account> accounts;
    private final File ACC_DATA;

    public Pythagoras() throws IOException, ClassNotFoundException {
        serverSocket = new ServerSocket(8008);
        accounts = new Hashtable<>();
        ACC_DATA = new File("u_data.pyth");
        readDatabase(ACC_DATA);
    }

    public void stopServer() throws IOException {
        serverSocket.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Pythagoras server = new Pythagoras();
        boolean cont = true;
        while (cont) {
            server.acceptClient();
        }
        server.stopServer();

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

    private void readDatabase(File file) throws IOException, ClassNotFoundException {

        ObjectInputStream ois = null;
        boolean created = file.createNewFile();
        Object readData;
        if (!created) {
            ois = new ObjectInputStream(new FileInputStream(file));
            while ((readData = Objects.requireNonNull(ois).readObject()) != null) {
                Account account = (Account) readData;
                accounts.put(account.getId(), account);
            }
            ois.close();
        }
    }

    private void writeDatabase(File file) throws IOException {
        ObjectOutputStream oos = null;
        boolean created = file.createNewFile();
        if (!created) {
            oos = new ObjectOutputStream(new FileOutputStream(file, false));
            for (Account acc : accounts.values()) {
                oos.writeObject(acc);
            }
            oos.close();
        }
    }



}
