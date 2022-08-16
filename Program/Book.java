package Program;

public class Book {
  private String BookName;
  private String AuthorName;
  private int ISBN;
  private int Edition;
  private int YearOfPublication;
  private String Genre;
  private String Publisher;
  private int CurrentNumberOfBook;
  private double Price;

  Book(String BookName, String AuthorName, int ISBN, int Edition, int YearOfPublication, String Genre, String Publisher, int CurrentNumberOfBook, double Price){
    this.BookName = BookName;
    this.AuthorName = AuthorName;
    this.ISBN = ISBN;
    this.Edition = Edition;
    this.YearOfPublication = YearOfPublication;
    this.Genre = Genre;
    this.Publisher = Publisher;
    this.CurrentNumberOfBook = CurrentNumberOfBook;
    this.Price = Price;
    
  }

  public void setBookName(String BookName) {
    this.BookName = BookName;
  }

  public String getBookName() {
    return BookName;
  }

  public void setAuthorName(String AuthorName) {
    this.AuthorName = AuthorName;
  }

  public String getAuthorName() {
    return AuthorName;
  }

  public void setISBN(int ISBN) {
    this.ISBN = ISBN;
  }

  public int getISBN() {
    return ISBN;
  }

  public void setEdition(int Edition) {
    this.Edition = Edition;
  }

  public int getEdition() {
    return Edition;
  }

  public void setYearOfPublication(int YearOfPublication) {
    this.YearOfPublication = YearOfPublication;
  }

  public int getYearOfPublication() {
    return YearOfPublication;
  }

  public void setGenre(String Genre) {
    this.Genre = Genre;
  }

  public String getGenre() {
    return Genre;
  }

  public void setPublisher(String Publisher) {
    this.Publisher = Publisher;
  }

  public String getPublisher() {
    return Publisher;
  }

  public void setCurrentNumberOfBook(int CurrentNumberOfBook) {
    this.CurrentNumberOfBook = CurrentNumberOfBook;
  }

  public int getCurrentNumberOfBook() {
    return CurrentNumberOfBook;

  }

  public void setPrice(double Price) {
    this.Price = Price;
  }

  public double getPrice() {
    return Price;
  }
}