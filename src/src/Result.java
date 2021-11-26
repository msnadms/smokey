/**
 * Result tuple class
 * @author Mason Adams
 * @version 1.0.0
 * Pairs any object sent between server and client to a protocol
 *
 */
public class Result<T> {

    private final T receivedObject;
    private final Protocol protocol;

    public Result(T ro, Protocol p) {
        this.receivedObject = ro;
        this.protocol = p;
    }

    public T getReceivedObject() {
        return receivedObject;
    }

    public Protocol getProtocol() {
        return protocol;
    }

}