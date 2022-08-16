package Program;

import java.sql.*;

public class SearchSystem {
    public static String searchBookByName(String BookName){
        try{
            String myDriver = "com.mysql.cj.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/alpha_book_store";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "");

            String sql1 = "select * from book where BookName = " + '"' + BookName + '"'; 
            Statement stmt1 = conn.createStatement();  
            ResultSet rs1 = stmt1.executeQuery(sql1);

            String isbn = "";
            String shelf = null;
            String row = null;

            while(rs1.next()) {  
                isbn = rs1.getString(3);

                try{
                    String sql2 = "select * from booklocation where ISBN = " +  isbn; 
                    Statement stmt2 = conn.createStatement();  
                    ResultSet rs2 = stmt2.executeQuery(sql2);

                    while(rs2.next()) {  
                        shelf = rs2.getString(2);
                        row =rs2.getString(3);
                        }
                    }     

                catch (Exception e) {
                    System.err.println("Got an exception!");
                    e.printStackTrace();
                    System.out.println(e);
                    return e.getMessage(); 
                }


            }

            conn.close();
            
            if (shelf != null && row != null){ 
                return "The Book is on shelf number " + shelf + " and row number " + row; 
            }
            else{
                return "The Book is not found in this store.";
            }
            

        }
        catch (Exception e) {
            System.err.println("Got an exception!");
            e.printStackTrace();
            System.out.println(e);
            return e.getMessage(); 
        }
    }
       
}
