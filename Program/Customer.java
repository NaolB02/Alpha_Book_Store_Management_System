package Program;

public class Customer {
  public Customer(){}

  public static String requestBookByName(String BookName){
    return SearchSystem.searchBookByName(BookName);
  }
}
