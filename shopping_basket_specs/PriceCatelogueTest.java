import static org.junit.Assert.*;
import org.junit.*;
import shopping_basket.*;

public class PriceCatelogueTest {

  //variables
  private PriceCatelogue pricer;

  @Before
  public void before(){
    pricer = new PriceCatelogue();
  }

  @Test
  public void testPricerHasOneItem(){
    assertEquals(10, pricer.size());
  }

  @Test
  public void testPriceReturned(){
    assertEquals(100, pricer.price("product000"));  
  }

  @Test
  public void testLastPriceReturned(){
    assertEquals(399, pricer.price("product009"));  
  }






}