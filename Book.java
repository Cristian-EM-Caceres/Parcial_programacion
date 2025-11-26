public class Book {

    private String title;
    private String isbn;
    private String author;
    private int publicationYear;
    private boolean available;
    private int timesLoaned;

    public Book(String title, String isbn, String author, int year) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.publicationYear = year;
        this.available = true;
        this.timesLoaned = 0;
    }

    public void lend() {
        if (available) {
            available = false;
            timesLoaned++;
        }
    }

    public void returnBook() {
        available = true;
    }

    public boolean isAvailable() { return available; }
    public String getTitle() { return title; }
    public String getIsbn() { return isbn; }
    public String getAuthor() { return author; }
    public int getPublicationYear() { return publicationYear; }
    public int getTimesLoaned() { return timesLoaned; }

    public void setTitle(String t) { title = t; }
    public void setAuthor(String a) { author = a; }
    public void setPublicationYear(int y) { publicationYear = y; }
}
