public class Stack {

    private LinkedList list;

    public Stack() {
        list = new LinkedList();
    }

    public void push(Object value) {
        // push
        Node newNode = new Node(value);
        newNode.next = list.getHead();

        try {
            java.lang.reflect.Field headField = LinkedList.class.getDeclaredField("head");
            headField.setAccessible(true);
            headField.set(list, newNode);

            java.lang.reflect.Field sizeField = LinkedList.class.getDeclaredField("size");
            sizeField.setAccessible(true);
            int size = (int) sizeField.get(list);
            sizeField.set(list, size + 1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object pop() {
        if (list.isEmpty()) return null;

        Object value = list.getHead().data;

        try {
            java.lang.reflect.Field headField = LinkedList.class.getDeclaredField("head");
            java.lang.reflect.Field sizeField = LinkedList.class.getDeclaredField("size");

            headField.setAccessible(true);
            sizeField.setAccessible(true);

            Node newHead = list.getHead().next;
            headField.set(list, newHead);
            int size = (int) sizeField.get(list);
            sizeField.set(list, size - 1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
    public Object peek() {
        if (list.isEmpty()) return null;
        return list.getHead().data;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
