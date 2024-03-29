import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 * Aesara is a thread class spawned by Pythagoras,
 * just like real life.
 * @author Mason Adams
 * @version 1.0.0
 * Communicates between associated clients and database
 */
public class Aesara implements Runnable {

    ObjectInputStream ois;
    ObjectOutputStream oos;
    Pythagoras master;

    public Aesara(ObjectInputStream ois, ObjectOutputStream oos, Pythagoras server) {
        this.ois = ois;
        this.oos = oos;
        master = server;
    }

    public void run() {

        Protocol protocol;

        try {
            while ((protocol = (Protocol) ois.readObject()) != null) {
                switch (protocol) {
                    case SIGNUP:
                        break;
                    case LOGIN:
                        break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }




    }
}