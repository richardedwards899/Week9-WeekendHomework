import static org.junit.Assert.*;
import org.junit.*;
import shopping_basket.*;

public class BasketTest {

  //variables
  private Basket basket;
  private PriceCatelogue catelogue;
  private Item item;
  private Item item2;

  @Before
  public void before(){
    catelogue = new PriceCatelogue();
    basket = new Basket(catelogue);
    item = new Item("product000", 100);
    item2 = new Item("product001", 1075);
  }

  @Test
  public void testCanAddSingleItemToBasket(){
    basket.add(item);
    assertEquals(1, basket.products());
  }

  @Test
  public void testCanTwoMatchingItemsToBasket(){
    basket.add(item);
    basket.add(item);
    assertEquals(1, basket.products());
    assertEquals(2, basket.quantity("product000"));
  }

  @Test
  public void testCanRemoveSingleItemFromBasket(){
    basket.add(item);
    basket.remove(item);
    assertEquals(0, basket.products());
    assertEquals(0, basket.quantity("product000"));
  }

  @Test
  public void testCantHaveNegativeCount(){
    basket.add(item);
    basket.remove(item);
    basket.remove(item);
    assertEquals(0, basket.products());
    assertEquals(0, basket.quantity("product000"));
  }

  @Test
  public void canEmptyBasket(){
    basket.add(item);
    basket.empty();
    assertEquals(0, basket.products());
  }

  @Test
  public void canCalculateValueOfBasket__OneItem(){
    basket.add(item);
    assertEquals(100, basket.value());
  }

  @Test
  public void canCalculateValueOfBasket__TwoItems(){
    basket.add(item);
    basket.add(item);
    assertEquals(200, basket.value());
  }

  @Test
  public void canFindValueOfBasket__TwoDifferentItems(){
    basket.add(item);
    basket.add(item2);
    assertEquals(1175, basket.value());
  }

  @Test
  public void canFindValueOfBasket__MultipleDifferentItems(){
    basket.add(item);
    basket.add(item2);
    basket.add(item);
    basket.add(item2);

    assertEquals(2350, basket.value());
  }
}