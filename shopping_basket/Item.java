package shopping_basket;

public class Item implements Buyable {

  private String id;
  private int price;

  public Item(String productCode, int price){
    id = productCode;
    this.price = price;
  }

  public String id(){
    return id;
  }

  public int price(){
    return price;
  }
}