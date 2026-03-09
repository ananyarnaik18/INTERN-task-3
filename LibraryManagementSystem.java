import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int bookId;
    String bookName;
    String authorName;
    boolean issued;

    Book(int id, String name, String author) {
        this.bookId = id;
        this.bookName = name;
        this.authorName = author;
        this.issued = false;
    }
}

public class LibraryManagementSystem {

    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addBook();
                    break;

                case 2:
                    viewBooks();
                    break;

                case 3:
                    issueBook();
                    break;

                case 4:
                    returnBook();
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void addBook() {

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Book Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        books.add(new Book(id, name, author));

        System.out.println("Book added successfully!");
    }

    static void viewBooks() {

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("\nList of Books:");

        for (Book b : books) {

            System.out.println("ID: " + b.bookId +
                    " | Name: " + b.bookName +
                    " | Author: " + b.authorName +
                    " | Status: " + (b.issued ? "Issued" : "Available"));
        }
    }

    static void issueBook() {

        System.out.print("Enter Book ID to issue: ");
        int id = sc.nextInt();

        for (Book b : books) {

            if (b.bookId == id) {

                if (!b.issued) {
                    b.issued = true;
                    System.out.println("Book issued successfully.");
                } else {
                    System.out.println("Book already issued.");
                }

                return;
            }
        }

        System.out.println("Book not found.");
    }

    static void returnBook() {

        System.out.print("Enter Book ID to return: ");
        int id = sc.nextInt();

        for (Book b : books) {

            if (b.bookId == id) {

                if (b.issued) {
                    b.issued = false;
                    System.out.println("Book returned successfully.");
                } else {
                    System.out.println("Book was not issued.");
                }

                return;
            }
        }

        System.out.println("Book not found.");
    }
}