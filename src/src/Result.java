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