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

  public int quantity(String productCode){
    return itemQuantities.get(productCode);
  }

  public void add(Buyable buyable){
    String productCode = buyable.id();

    if (!itemQuantities.containsKey(productCode)){
      itemQuantities.put(productCode, 1);
    }
    else {
      itemQuantities.put(productCode, quantity(productCode)+1);
    }
  }

}