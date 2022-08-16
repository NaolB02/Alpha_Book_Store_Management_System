package Program;

public abstract class Employee {
    private String EmployeeID;
    private String FullName;
    private String EmailAddress;
    private String UserName;
    private String Password;

    Employee(String EmployeeID, String FullName, String EmailAddress, String UserName, String Password){
      this.EmployeeID = EmployeeID;
      this.FullName = FullName;
      this.EmailAddress = EmailAddress;
      this.UserName = UserName;
      this.Password = Password;
    }
    public abstract void setEmployeeID(String EmployeeID);

    public abstract String getEmployeeID();

    public abstract void setFullName(String FullName);

    public abstract String getFullName();

    public abstract void setEmailAddress(String EmailAddress);

    public abstract String getEmailAddress();

    public abstract void setUserName(String UserName);

    public abstract String getUserName();

    public abstract void setPassword(String Password);

    public abstract String getPassword();
    
    public static Boolean login(){
      return false;
    }


}
