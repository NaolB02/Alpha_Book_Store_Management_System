package Program;
  
public class BookLocation {
    private int ISBN;
    private int ShelfNumber;
    private int RowNumber;

    BookLocation(int ISBN, int ShelfNumber, int RowNumber){
      this.ISBN =ISBN;
      this.ShelfNumber = ShelfNumber;
      this.RowNumber = RowNumber;
    }
    public void setISBN(int ISBN){
      this.ISBN = ISBN;
    }
    public int getISBN(){
      return ISBN;
    }
    public void setShelfNumber(int ShelfNumber){
      this.ShelfNumber = ShelfNumber;

    }
    public int getShelfNumber(){
      return ShelfNumber;

    }
    public void setRowNumber(int RowNumber){
      this.RowNumber = RowNumber;

    }
    public int getRowNumber(){
      return RowNumber;

    }

    
}
