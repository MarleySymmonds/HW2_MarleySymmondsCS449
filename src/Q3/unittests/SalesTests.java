package Q3.unittests;

import Q3.business.Item;
import Q3.business.Sale;
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
        item = new Item("apple", 2.00, 4);
        sale.addItem(item);
        setUpIsDone = true;
    }

    public void testGetDiscountNormal() throws Exception {
        assertEquals(4*0.10, sale.getDiscount("NORMAL", "TUESDAY"));
        assertFalse(sale.getDiscount("NORMAL", "TUESDAY") == 5 * 0.15);
    }

    public void testGetDiscountSeniorTuesday() throws Exception {
        assertEquals(4*0.20, sale.getDiscount("SENIOR", "TUESDAY"));
        assertFalse(sale.getDiscount("SENIOR", "TUESDAY") == 5 * 0.10);
    }

    public void testGetDiscountSeniorMonday() throws Exception {
        assertEquals(4*0.10, sale.getDiscount("SENIOR", "MONDAY"));
        assertFalse(sale.getDiscount("SENIOR", "MONDAY") == 5 * 0.25);
    }

    public void testGetDiscountPreferred() throws Exception {
        assertEquals(4*0.30, sale.getDiscount("PREFERRED", "TUESDAY"));
        assertFalse(sale.getDiscount("PREFERRED", "TUESDAY") == 4 * 0.20);
    }

    public void testGetDiscountWrongType() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            sale.getDiscount("NONE", "TUESDAY");
        });

        String expectedMessage = "Error: incorrect customer type";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    public void testGetSubtotal()
    {
        assertEquals(8.0, sale.getSubTotal());
    }

    public void testGetDiscountedSubtotalNormal() throws Exception {
        assertEquals(5.0, 5.0);
    }

    public void testGetDiscountedSubtotalSeniorTuesday() throws Exception {
        assertEquals(5.0, 5.0);
    }

    public void testGetDiscountedSubtotalSeniorMonday() throws Exception {
        assertEquals(5.0, 5.0);

    }

    public void testGetDiscountedSubtotalPreferred() throws Exception {
        assertEquals(5.0, 5.0);

    }

    public void testGetDiscountedSubtotalNone() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            sale.getDiscountedSubTotal("NONE", "TUESDAY");
        });

        String expectedMessage = "Error: incorrect customer type";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }


}
