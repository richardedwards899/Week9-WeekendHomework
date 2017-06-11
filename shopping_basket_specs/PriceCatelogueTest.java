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
    assertEquals(1, pricer.size());
  }

  @Test
  public void testPriceReturned(){
    assertEquals(299, pricer.price("carton001"));  
  }






}