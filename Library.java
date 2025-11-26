public class Library {

    private String name;
    private LinkedList books;

    public Library(String name) {
        this.name = name;
        this.books = new LinkedList();
    }

    public boolean addBook(Book book) {
        if (book == null) return false;
        return books.add(book);
    }

    public boolean removeBook(Book book) {
        if (book == null) return false;
        return books.remove(book);
    }

    public Book findBookByIsbn(String isbn) {
        Node temp = books.getHead();

        while (temp != null) {
            Book b = (Book) temp.getData();
            if (b.getIsbn().equalsIgnoreCase(isbn)) return b;

            temp = temp.getNext();
        }
        return null;
    }

    public LinkedList findBooksByTitle(String title) {
        LinkedList found = new LinkedList();
        Node temp = books.getHead();

        while (temp != null) {
            Book b = (Book) temp.data;
            if (b.getTitle().toLowerCase().contains(title.toLowerCase())) {
                found.add(b);
            }
            temp = temp.next;
        }
        return found;
    }

    public LinkedList findBooksByAuthor(String author) {
        LinkedList found = new LinkedList();
        Node temp = books.getHead();

        while (temp != null) {
            Book b = (Book) temp.data;
            if (b.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                found.add(b);
            }
            temp = temp.next;
        }
        return found;
    }

    public LinkedList getAvailableBooks() {
        LinkedList available = new LinkedList();
        Node temp = books.getHead();

        while (temp != null) {
            Book b = (Book) temp.data;
            if (b.isAvailable()) {
                available.add(b);
            }
            temp = temp.next;
        }
        return available;
    }

    public LinkedList getLoanedBooks() {
        LinkedList loaned = new LinkedList();
        Node temp = books.getHead();

        while (temp != null) {
            Book b = (Book) temp.data;
            if (!b.isAvailable()) {
                loaned.add(b);
            }
            temp = temp.next;
        }
        return loaned;
    }

    public String getStatistics() {
        int total = books.size();
        int available = getAvailableBooks().size();
        int loaned = getLoanedBooks().size();

        return "Estadísticas de la Biblioteca:\n" +
                "- Total libros: " + total + "\n" +
                "- Disponibles: " + available + "\n" +
                "- Prestados: " + loaned + "\n";
    }
}
