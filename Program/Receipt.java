package Program;

public class Receipt {
    private String ReceiptID;
    private int ISBN;
    private double Price;
    private String PurchaseDate;
  
    Receipt(String ReceiptID, int ISBN, double Price, String PurchaseDate){
      this.ReceiptID = ReceiptID;
      this.ISBN = ISBN;
      this.Price = Price;
      this.PurchaseDate = PurchaseDate;
    }
    public void setReceiptID(String ReceiptID){
      this.ReceiptID = ReceiptID;
    }
    public String getReceiptID(){
      return ReceiptID;
    }
    public void setISBN(int ISBN){
      this.ISBN = ISBN;
    }
    public int getISBN(){
      return ISBN;
    }
    public void setPrice(double Price){
      this.Price = Price;
    }
    public double getPrice(){
      return Price;
    }
    public void setPurchaseDate(String PurchaseDate){
      this.PurchaseDate = PurchaseDate;
    }
    public String getPurchaseDate(){
      return PurchaseDate;
    }
}