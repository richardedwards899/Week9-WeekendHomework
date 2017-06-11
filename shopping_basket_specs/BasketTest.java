import static org.junit.Assert.*;
import org.junit.*;
import shopping_basket.*;

public class BasketTest {

  //variables
  private Basket basket;
  private PriceCatelogue catelogue;
  private Item item;

  @Before
  public void before(){
    catelogue = new PriceCatelogue();
    basket = new Basket(catelogue);
    item = new Item("product000", 100);
  }

  @Test
  public void testCanAddSingleItemToBasket(){
    basket.add(item);
    assertEquals(1, basket.size());
  }

}