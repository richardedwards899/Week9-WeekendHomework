package shopping_basket;

import java.util.HashMap;

public class Basket {

  private HashMap<String, Integer> itemQuantities;

  public Basket(PriceCatelogue catelogue){
    itemQuantities = new HashMap<>();
  }

  public int size(){
    return itemQuantities.size();
  }

  public void add(Buyable buyable){
    String productCode = buyable.id();

    itemQuantities.put(productCode, 1);
    // if (!itemQuantities.containsKey(productCode)){

    // }
    // else {

    // }
  }

}