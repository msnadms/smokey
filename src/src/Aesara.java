import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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

    }
}