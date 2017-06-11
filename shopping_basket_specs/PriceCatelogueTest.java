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
  public void testPricerHasTenItems(){
    assertEquals(10, pricer.size());
  }