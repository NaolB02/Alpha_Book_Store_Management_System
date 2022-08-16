package Program;

import java.sql.*;

public class BookManager extends Employee {
    private String EmployeeID;
    private String FullName;
    private String EmailAddress;
    private String UserName;
    private String Password;

    BookManager(String EmployeeID, String FullName, String EmailAddress, String UserName, String Password){
       super(EmployeeID, FullName, EmailAddress, UserName, Password);
    }
    public void setEmployeeID(String EmployeeID){
      this.EmployeeID = EmployeeID;
    }
    public String getEmployeeID(){
      return EmployeeID;
    }
    public void setFullName(String FullName){
      this.FullName = FullName;
    }
    public String getFullName(){
      return FullName;
    }
    public void setEmailAddress(String EmailAddress){
      this.EmailAddress = EmailAddress;
    }
    public String getEmailAddress(){
      return EmailAddress;
    }
    public void setUserName(String UserName){
      this.UserName = UserName;
    }
    public String getUserName(){
      return UserName;
    }public void setPassword(String Password){
      this.Password = Password;
    }
    public String getPassword(){
      return Password;
    }
    public static Boolean login(String UserName, String Password){
      
      try{
            String myDriver = "com.mysql.cj.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/alpha_book_store";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "");

            String sql1 = "select * from bookmanager where username = " + '"' + UserName + '"';
            Statement stmt = conn.createStatement();  
            ResultSet rs = stmt.executeQuery(sql1);

            Boolean presence = false;

            while(rs.next()) {  
                String sql2 = "select * from bookmanager where password = " + '"' + Password + '"';
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(sql2);

                while(rs2.next()){
                  presence = true;               
              }
            }

            conn.close(); 
            return presence;  
        }

        catch (Exception e) {
            System.err.println("Got an exception!");
            e.printStackTrace();
            System.out.println(e); 
            return false;
        }
    }

  public static void addNewBook(String BookName, String AuthorName, int ISBN, int Edition, int YearOfPublication, 
  String Genre, String Publisher, int CurrentNumberOfBook, double Price, int ShelfNumber, int RowNumber){

    Book abook = new Book(BookName, AuthorName, ISBN, Edition, YearOfPublication, Genre, Publisher, CurrentNumberOfBook, Price);
    try{
      String myDriver = "com.mysql.cj.jdbc.Driver";
      String myUrl = "jdbc:mysql://localhost:3306/Alpha_Book_Store";
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "root", "");

      String sql = " insert into book" + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

      PreparedStatement preparedStmt = conn.prepareStatement(sql);
      preparedStmt.setString (1, abook.getBookName());
      preparedStmt.setString (2, abook.getAuthorName());
      preparedStmt.setInt    (3, abook.getISBN());
      preparedStmt.setInt    (4, abook.getEdition());
      preparedStmt.setInt    (5, abook.getYearOfPublication());
      preparedStmt.setString (6, abook.getGenre());
      preparedStmt.setString (7, abook.getPublisher());
      preparedStmt.setInt    (8, abook.getCurrentNumberOfBook());
      preparedStmt.setDouble (9, abook.getPrice());

      preparedStmt.execute();

      addBookLocation(abook.getISBN(), ShelfNumber, RowNumber);

      conn.close();
      }
      catch (Exception e) {
        System.err.println("Got an exception!");
        e.printStackTrace();
        System.out.println(e); 
        }
  }

  public static void addExistingBook(int ISBN){
    try{
      String myDriver = "com.mysql.cj.jdbc.Driver";
      String myUrl = "jdbc:mysql://localhost:3306/Alpha_Book_Store";
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "root", "");

      String sql1 = "update book set CurrentNumberOfBook = CurrentNumberOfBook + 1 where ISBN = " + ISBN;
      PreparedStatement stmt = conn.prepareStatement(sql1);
      stmt.execute();

      conn.close();
    }

    catch (Exception e) {
        System.err.println("Got an exception!");
        e.printStackTrace();
        System.out.println(e); 
    }
    
  }

  public static void removeBook(int ISBN){
    try{
      String myDriver = "com.mysql.cj.jdbc.Driver";
      String myUrl = "jdbc:mysql://localhost:3306/Alpha_Book_Store";
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "root", "");

      String sql1 = "select * from book where ISBN = " + ISBN;
      Statement stmt = conn.createStatement();  
      ResultSet rs = stmt.executeQuery(sql1);

      while(rs.next()) {  
        int curnum = rs.getInt(8);

        if (curnum == 1){
          String sql2 = "delete from book where ISBN = " + ISBN;
          PreparedStatement stmt2 = conn.prepareStatement(sql2);
          stmt2.execute();

          removeBookLocation(ISBN);
         
        }
        else if(curnum > 1){
          String sql3 = "update book set CurrentNumberOfBook = CurrentNumberOfBook - 1 where ISBN = " + ISBN;
          PreparedStatement stmt2 = conn.prepareStatement(sql3);
          stmt2.execute();
        }
      }

      conn.close();
    }

    catch (Exception e) {
        System.err.println("Got an exception!");
        e.printStackTrace();
        System.out.println(e); 
    }
    
   }

  public static void addBookLocation(int ISBN, int ShelfNumber, int RowNumber){

    BookLocation bookLocation = new BookLocation(ISBN, ShelfNumber, RowNumber);
    try{
          String myDriver = "com.mysql.cj.jdbc.Driver";
          String myUrl = "jdbc:mysql://localhost:3306/Alpha_Book_Store";
          Class.forName(myDriver);
          Connection conn = DriverManager.getConnection(myUrl, "root", "");

          String sql = " insert into booklocation" + " values (?, ?, ?)";

          PreparedStatement preparedStmt = conn.prepareStatement(sql);
          preparedStmt.setInt    (1, bookLocation.getISBN());
          preparedStmt.setInt    (2, bookLocation.getShelfNumber());
          preparedStmt.setInt    (3, bookLocation.getRowNumber());
          preparedStmt.execute();

          conn.close();
          }
          catch (Exception e) {
            System.err.println("Got an exception!");
            e.printStackTrace();
            System.out.println(e); 
          }


  }
  public static void removeBookLocation(int ISBN){
    try{
      String myDriver = "com.mysql.cj.jdbc.Driver";
      String myUrl = "jdbc:mysql://localhost:3306/Alpha_Book_Store";
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "root", "");

      String sql1 = "delete from booklocation where ISBN = " + ISBN;
      PreparedStatement stmt = conn.prepareStatement(sql1);
      stmt.execute();

      conn.close();
    }

    catch (Exception e) {
        System.err.println("Got an exception!");
        e.printStackTrace();
        System.out.println(e); 
    }
  }
}

