package Program;

import java.sql.*;

public class Manager extends Employee {
    private String EmployeeID;
    private String FullName;
    private String EmailAddress;
    private String UserName;
    private String Password;

    Manager(String EmployeeID, String FullName, String EmailAddress, String UserName, String Password){
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

            String sql1 = "select * from manager where username = " + '"' + UserName + '"';
            Statement stmt = conn.createStatement();  
            ResultSet rs = stmt.executeQuery(sql1);

            Boolean presence = false;

            while(rs.next()) {  
                String sql2 = "select * from manager where password = " + '"' + Password + '"';
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
    
    public static String totalSalesReport(String Date){
        try{
            String myDriver = "com.mysql.cj.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/Alpha_Book_Store";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "");
            
            String sql ="select sum(price) as totalsold from receipt group by PurchaseDate having PurchaseDate = " + '"' + Date + '"';
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            double price = 0;

            while(rs.next()){
              price = rs.getDouble(1);
            }
            
            return "The total sale on this date is " + price;

        }
        catch (Exception e) {
            System.err.println("Got an exception!");
            e.printStackTrace();
            System.out.println(e); 
            return e.getMessage();
        }
        
    }
}
