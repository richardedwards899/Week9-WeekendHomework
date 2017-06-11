package shopping_basket;

import java.util.HashMap;

public class PriceCatelogue {

  private HashMap prices;

  public PriceCatelogue(){
    prices = new HashMap();
    setupPrices();
  }

  public int size(){
    return prices.size();
  }

  private void setupPrices(){
    prices.put("carton001", 299);
  }

}