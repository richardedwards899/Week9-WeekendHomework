package shopping_basket;

import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

public class Basket {

  private HashMap<String, Integer> itemQuantities;
  private PriceCatelogue prices;
  private int discountThreshold;
  private double discount;
  private boolean loyaltyCardHolder;
  private double loyaltyDiscount;

  public Basket(PriceCatelogue catelogue, boolean loyal){
    itemQuantities = new HashMap<>();
    prices = catelogue;
    loyaltyCardHolder = loyal;
    setConstants();
  }

  private void setConstants(){
    discountThreshold = 2000; //£20
    discount = 0.10;
    loyaltyDiscount = 0.02;
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
    total = applyDiscount(total);
    total = applyLoyaltyDiscount(total);
    return total;
  }

  private int applyLoyaltyDiscount(int amount){
    if (loyaltyCardHolder){
      return (int) (amount * (1 - loyaltyDiscount));
    }
    else return amount;
  }

  private int applyDiscount(int amount){
    if (amount > discountThreshold){
      return (int) (amount * (1 - discount));
    }
    else return amount;
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