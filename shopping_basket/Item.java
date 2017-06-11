package shopping_basket;

public class Item {

  private String id;

  public Item(String productCode, int price){
    id = productCode;
  }

  public String id(){
    return id;
  }
}