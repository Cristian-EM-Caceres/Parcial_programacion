//implementacion de lista doblemente enlazada
public class LinkedList {
    private Node head;
    private int size;
    public LinkedList() {
        head = null;
        size = 0;
    }

    public int size() { return size; }

    public boolean isEmpty() { return head == null; }

    public Node getHead() { return head; }

    public boolean add(Object value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newNode;
        }
        size++;
        return true;
    }

    public Object get(int index) {
        if (index < 0 || index >= size) return null;

        Node temp = head;
        int count = 0;
        while (temp != null) {
            if (count == index) return temp.data;
            temp = temp.next;
            count++;
        }
        return null;
    }

    public boolean remove(Object value) {
        if (head == null) return false;

        if (head.data.equals(value)) {
            head = head.next;
            size--;
            return true;
        }

        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data.equals(value)) {
                temp.next = temp.next.next;
                size--;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
}
