package pattern.prototype;


import java.util.ArrayList;

class Book {
    private String author;
    private String title;

    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String toString() {
        return "(" + author + ", " + title + ")";
    }
}

/**
 * clone() 메소드를 오버라이드 하고 싶다면 Cloneable 를 implements 해야한다.
 * Cloneable 이라고 해놔야 이 객체가 clone 해도 되는 객체라는 것을 명시하는 것이다.
 */
class BookShelf implements Cloneable{
    private ArrayList<Book> shelf;

    public BookShelf() {
        shelf = new ArrayList<Book>();
    }

    public void addBook(Book book) {
        shelf.add(book);
    }

    public ArrayList<Book> getShelf() {
        return shelf;
    }

    public void setShelf(ArrayList<Book> shelf) {
        this.shelf = shelf;
    }

    public String toString() {
        return shelf.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // 가장 상위 객체인 Object 의 clone 메소드를 호출한다.
        BookShelf another = new BookShelf();
        for(Book book: shelf) {
            another.addBook(new Book(book.getAuthor(), book.getTitle()));
        }
        return another;
    }
}
public class PrototypeTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        BookShelf bookShelf = new BookShelf();

        bookShelf.addBook(new Book("조정래", "태백산맥"));
        bookShelf.addBook(new Book("박완서", "나목"));
        bookShelf.addBook(new Book("박경리", "토지"));

        System.out.println(bookShelf.toString());

        BookShelf another = (BookShelf) bookShelf.clone();

        System.out.println(another.toString());

        bookShelf.getShelf().get(0).setAuthor("조정래");
        bookShelf.getShelf().get(0).setTitle("한강");

        System.out.println(bookShelf);
        System.out.println(another);
    }
}
