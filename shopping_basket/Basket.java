package shopping_basket;

import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

public class Basket {

  private HashMap<String, Integer> itemQuantities;
  private PriceCatelogue prices;

  public Basket(PriceCatelogue catelogue){
    itemQuantities = new HashMap<>();
    prices = catelogue;
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

  public void empty(){
    itemQuantities = new HashMap<>();
  }

  public int value(){
    int total = applyBOGOFpricing();
    return total;
  }

  private int bogof(int quantity){
    return (quantity / 2) + (quantity % 2);
  }

  private int applyBOGOFpricing(){
    int total = 0;
    Set keys = itemQuantities.keySet();
    Iterator iterator = keys.iterator();

    while (iterator.hasNext()){
      String key = (String) iterator.next();
      int quantity = bogof(itemQuantities.get(key).intValue());
      int price = prices.price(key);
      total += quantity * price;
    }
    return total;
  }

}