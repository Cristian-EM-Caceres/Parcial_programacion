public class Main {
    public static void main(String[] args) {

        Library lib = new Library("Biblioteca Central");

        Book b1 = new Book("El Principito", "111", "Saint-Exupéry", 1943);
        Book b2 = new Book("IT", "222", "Stephen King", 1986);
        Book b3 = new Book("Clean Code", "333", "Robert Martin", 2008);

        lib.addBook(b1);
        lib.addBook(b2);
        lib.addBook(b3);

        // Préstamos
        b1.lend();
        b1.returnBook(); 
        b2.lend();
        

        // Usuarios en espera
        b1.lend();
        b1.lend();
        b1.returnBook();
        b1.returnBook(); 

        lib.getStatistics();

        System.out.println("Buscando 'Prin': " + lib.findBooksByTitle("Prin").size());
        System.out.println("Buscando por autor 'King': " +
                lib.findBooksByAuthor("King").size());
    }
}


