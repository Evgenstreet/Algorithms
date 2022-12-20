package third_task;

public class Chain {
    private int element;
    private int value;
    private Chain next;

    Chain(int element, int value) {
        this.element = element;
        this.value = value;
        this.next = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getElement() {
        return element;
    }

    public Chain getNext() {
        return next;
    }

    public void setNext(Chain next) {
        this.next = next;
    }
}
