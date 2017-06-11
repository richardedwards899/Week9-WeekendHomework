import static org.junit.Assert.*;
import org.junit.*;
import shopping_basket.*;

public class ItemTest {

  //variables
  private Item item;

  @Before
  public void before(){
    item = new Item("product000", 100);
  }

  @Test
  public void testItemHasCode(){
    assertEquals("product000", item.id());
  }

}