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
    prices.put("product000", 100);
    prices.put("product001", 1075);
    prices.put("product002", 95);
    prices.put("product003", 375);
    prices.put("product004", 599);
    prices.put("product005", 749);
    prices.put("product006", 1299);
    prices.put("product007", 13099);
    prices.put("product008", 499);
    prices.put("product009", 399);
  }
}