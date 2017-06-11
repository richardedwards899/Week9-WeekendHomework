package shopping_basket;

import java.util.HashMap;

public class PriceCatelogue {

  private HashMap<String,Integer> prices;

  public PriceCatelogue(){
    prices = new HashMap<>();
    setupPrices();
  }

  public int size(){
    return prices.size();
  }

  public int price(String itemCode){
    return prices.get(itemCode).intValue();
  }

  private void setupPrices(){
    prices.put("carton001", 299);
  }

}