import java.util.*;

class Book {
    private int year;
    private String author;
    private String title;
    private String publisher;

    public Book(int year, String author, String title, String publisher) {
        this.year = year;
        this.author = author;
        this.title = title;
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }
}

public class BookSortingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Book> books = new ArrayList<>();

        // Добавьте ваши книги в список books
        books.add(new Book(1985, "Шекспир", "Ромео и Джульетта", "Литрес"));
        books.add(new Book(1990, "Пушкин", "Сказка о царе Салтане", "РусИздат"));
        books.add(new Book(1998, "Акунин", "Азазель", "Публионика"));
        books.add(new Book(2000, "Гримм", "Дюймовочка", "МирандаЛит"));
        // Добавьте еще книги...

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Выберите параметр сортировки:");
            System.out.println("1. По году публикации");
            System.out.println("2. По автору");
            System.out.println("3. По названию");
            System.out.println("4. По издательству");
            System.out.println("5. По имени в порядке возрастания, но убыванию по автору");
            System.out.println("6. Завершить");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Считываем символ новой строки после ввода числа

            switch (choice) {
                case 1:
                    Collections.sort(books, Comparator.comparing(Book::getYear));
                    break;

                case 2:
                    Collections.sort(books, Comparator.comparing(Book::getAuthor));
                    break;

                case 3:
                    Collections.sort(books, Comparator.comparing(Book::getTitle));
                    break;

                case 4:
                    Collections.sort(books, Comparator.comparing(Book::getPublisher));
                    break;

                case 5:
                    Collections.sort(books, Comparator.comparing(Book::getTitle)
                            .thenComparing(Comparator.comparing(Book::getAuthor).reversed()));
                    break;

                case 6:
                    isRunning = false;
                    break;

                default:
                    System.out.println("Выберите существующий параметр.");
            }

            if (isRunning) {
                System.out.println("Книги после сортировки:");
                for (Book book : books) {
                    System.out.println(book.getYear() + " " + book.getAuthor() + " " + book.getTitle() + " " + book.getPublisher());
                }
            }
        }
    }
}
