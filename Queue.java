public class Queue {

    private LinkedList list;

    public Queue() {
        list = new LinkedList();
    }

    public void enqueue(Object value) {
        list.add(value);
    }

    public Object dequeue() {
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
}
