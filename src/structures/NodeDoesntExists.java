package structures;

public class NodeDoesntExists extends Exception {
    public static final String MESSAGE = "Node doesn't exists with key: ";

    public NodeDoesntExists() {
        super(MESSAGE);
    }
}
