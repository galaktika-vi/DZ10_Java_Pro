import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Child> children = new ArrayList<>();
        children.add(new Child(130));
        children.add(new Child(120));
        children.add(new Child(140));
        children.add(new Child(110));

        while (true) {
            System.out.println("Выберите задачу для выполнения:");
            System.out.println("1. Сортировка детей по росту (Comparable)");
            System.out.println("2. Создание и сортировка списка объявлений (AdComparator)");
            System.out.println("3. Поиск максимального и минимального объявления");
            System.out.println("4. Создание и сортировка списка авторов книг (AuthorComparator)");
            System.out.println("5. Завершить");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:

                    Collections.sort(children);
                    System.out.println("Дети после сортировки:");
                    for (Child child : children) {
                        System.out.println(child.getHeight());
                    }
                    break;

                case 2:

                    List<Ad> ads = new ArrayList<>();
                    ads.add(new Ad(2000, "Название1", "Автор1", "Описание1", 2023));
                    ads.add(new Ad(1995, "Название2", "Автор2", "Описание2", 2021));
                    // Добавьте еще объявлений...

                    Collections.sort(ads, new AdComparator());
                    System.out.println("Объявления после сортировки:");
                    for (Ad ad : ads) {
                        System.out.println(ad.getYear() + " " + ad.getName() + " " + ad.getAuthor() + " " + ad.getDescription());
                    }
                    break;

                case 3:

                    List<Ad> adsList = new ArrayList<>();
                    adsList.add(new Ad(2000, "Название1", "Автор1", "Описание1", 2023));
                    adsList.add(new Ad(1995, "Название2", "Автор2", "Описание2", 2021));


                    Ad minAd = Collections.min(adsList, new AdComparator());
                    Ad maxAd = Collections.max(adsList, new AdComparator());

                    System.out.println("Минимальное объявление: " + minAd.getYear() + " " + minAd.getName());
                    System.out.println("Максимальное объявление: " + maxAd.getYear() + " " + maxAd.getName());
                    break;

                case 4:

                    List<Author> authors = new ArrayList<>();
                    authors.add(new Author("Имя1", "Фамилия1", 1980));
                    authors.add(new Author("Имя2", "Фамилия2", 1975));
                    authors.add(new Author("Имя3", "Фамилия3", 1985));

                    Collections.sort(authors, new AuthorComparator());

                    System.out.println("Авторы после сортировки:");
                    for (Author author : authors) {
                        System.out.println(author.getBirthYear() + " " + author.getLastName());
                    }
                    break;

                case 5:

                    System.out.println("Программа завершена.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Выберите существующую задачу.");
            }
        }
    }
}


class Child implements Comparable<Child> {
    private int height;

    public Child(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public int compareTo(Child other) {
        // Сортируем по убыванию роста
        return Integer.compare(other.height, this.height);
    }
}


class Ad {
    private int price;
    private String name;
    private String description;
    private String author;
    private int year;

    public Ad(int price, String name, String author, String description, int year) {
        this.price = price;
        this.name = name;
        this.author = author;
        this.description = description;
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public int getYear() {
        return year;
    }
}


class AdComparator implements Comparator<Ad> {
    @Override
    public int compare(Ad ad1, Ad ad2) {

        if (ad1.getYear() != ad2.getYear()) {
            return Integer.compare(ad1.getYear(), ad2.getYear());
        } else if (!ad1.getName().equals(ad2.getName())) {
            return ad1.getName().compareTo(ad2.getName());
        } else if (!ad1.getAuthor().equals(ad2.getAuthor())) {
            return ad1.getAuthor().compareTo(ad2.getAuthor());
        } else {
            return ad1.getDescription().compareTo(ad2.getDescription());
        }
    }
}


class Author {
    private String firstName;
    private String lastName;
    private int birthYear;

    public Author(String firstName, String lastName, int birthYear) {
        this.firstName = firstName;
        this    .lastName = lastName;
        this.birthYear = birthYear;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }
}


class AuthorComparator implements Comparator<Author> {
    @Override
    public int compare(Author author1, Author author2) {
        
        if (author1.getBirthYear() != author2.getBirthYear()) {
            return Integer.compare(author1.getBirthYear(), author2.getBirthYear());
        } else {
            return author1.getLastName().compareTo(author2.getLastName());
        }
    }
}

