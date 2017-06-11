package shopping_basket;

import java.util.HashMap;

public class Basket {

  private HashMap<String, Integer> itemQuantities;

  public Basket(PriceCatelogue catelogue){
    itemQuantities = new HashMap<>();
  }

  public int products(){
    return itemQuantities.size();
  }

  public int quantity(String productCode){

    if (itemQuantities.containsKey(productCode)){
      return itemQuantities.get(productCode);
    }
    else return 0; 
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

  public void remove(Buyable buyable){
    String productCode = buyable.id();

    if (itemQuantities.containsKey(productCode)){
      if (quantity(productCode) > 0){
        itemQuantities.put(productCode, quantity(productCode)-1);
      }
      if (quantity(productCode) == 0){
        itemQuantities.remove(productCode);
      }
    }
  }

}