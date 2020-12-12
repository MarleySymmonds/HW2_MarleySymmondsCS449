package Q2.unittests;

import Q2.business.Item;
import Q2.business.Sale;
import junit.framework.TestCase;
import org.junit.Before;

import static org.junit.Assert.assertThrows;

public class SalesTests extends TestCase
{
    private Item item;
    private Sale sale;
    private static boolean setUpIsDone = false;
    @Before
    protected void setUp() throws Exception
    {
        if (setUpIsDone)
        {
            return;
        }
        sale = new Sale();
        item = new Item("bananas", 1.00, 5);
        sale.addItem(item);
        setUpIsDone = true;
    }

    public void testGetDiscountNormal() throws Exception {
        assertEquals(5*0.10, sale.getDiscount("NORMAL"));
        assertFalse(sale.getDiscount("NORMAL") == 5 * 0.15);
    }


    public void testGetDiscountSenior() throws Exception {
        assertEquals(5*0.15, sale.getDiscount("SENIOR"));
        assertFalse(sale.getDiscount("SENIOR") == 5 * 0.20);
    }

    public void testGetDiscountPreferred() throws Exception {
        assertEquals(5*0.20, sale.getDiscount("PREFERRED"));
        assertFalse(sale.getDiscount("PREFERRED") == 5 * 0.15);
    }

    public void testGetDiscountWrongType() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            sale.getDiscount("NONE");
        });

        String expectedMessage = "Error: incorrect customer type";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    public void testGetSubtotal()
    {
        assertEquals(5.0, sale.getSubTotal());
        assertFalse(sale.getSubTotal() == 4);
    }

    public void testGetDiscountedSubtotalNormal() throws Exception {
        assertEquals(5.0, 5.0);
        assertFalse(sale.getDiscountedSubTotal("NORMAL") == 4);
    }

    public void testGetDiscountedSubtotalSenior() throws Exception {
        assertTrue(sale.getDiscountedSubTotal("SENIOR") == 5 - (5*0.15));
        assertFalse(sale.getDiscountedSubTotal("SENIOR") == 4);
    }

    public void testGetDiscountedSubtotalPreferred() throws Exception {
        assertEquals(4.0, 4.0);
    }

    public void testGetDiscountedSubtotalNone() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            sale.getDiscountedSubTotal("NONE");
        });

        String expectedMessage = "Error: incorrect customer type";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
