package Program;

import java.sql.*;

public class Cashier extends Employee {

    private String EmployeeID;
    private String FullName;
    private String EmailAddress;
    private String UserName;
    private String Password;

    Cashier(String EmployeeID, String FullName, String EmailAddress, String UserName, String Password){
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
            String myUrl = "jdbc:mysql://localhost:3306/Alpha_Book_Store";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "");

            String sql1 = "select * from cashier where username = " + '"' + UserName + '"';
            Statement stmt = conn.createStatement();  
            ResultSet rs = stmt.executeQuery(sql1);

            Boolean presence = false;

            while(rs.next()) {  
                String sql2 = "select * from cashier where password = " + '"' + Password + '"';
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

    public static String viewPrice(int ISBN){

        try{
            String myDriver = "com.mysql.cj.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/Alpha_Book_Store";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "");

            String sql1 = "select * from book where ISBN = " + ISBN;
            Statement stmt = conn.createStatement();  
            ResultSet rs = stmt.executeQuery(sql1);

            double price = 0;

            while(rs.next()) {  
                price = rs.getInt(9);
            }

            conn.close();

            return "The price of this book is " + price;
        }

        catch (Exception e) {
            System.err.println("Got an exception!");
            e.printStackTrace();
            System.out.println(e); 
            return e.getMessage();
        }
        
    }  

    public static void createReceipt(String ReceiptID, int ISBN, double Price, String PurchaseDate){
        Receipt receipt = new Receipt(ReceiptID, ISBN, Price, PurchaseDate);
        try{
          String myDriver = "com.mysql.cj.jdbc.Driver";
          String myUrl = "jdbc:mysql://localhost:3306/Alpha_Book_Store";
          Class.forName(myDriver);
          Connection conn = DriverManager.getConnection(myUrl, "root", "");

          String sql = " insert into receipt" + " values (?, ?, ?, ?)";

          PreparedStatement preparedStmt = conn.prepareStatement(sql);
          preparedStmt.setString (1, receipt.getReceiptID());
          preparedStmt.setInt    (2, receipt.getISBN());
          preparedStmt.setDouble (3, receipt.getPrice());
          preparedStmt.setString (4, receipt.getPurchaseDate());
          preparedStmt.execute();

          conn.close();
          }
          catch (Exception e) {
            System.err.println("Got an exception!");
            e.printStackTrace();
            System.out.println(e); 
          }

    }
}