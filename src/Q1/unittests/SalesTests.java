package Q1.unittests;

import Q1.business.Item;
import Q1.business.Sale;
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

    public void testGetDiscount() {
        assertEquals(4*0.2, sale.getDiscount());
    }


    public void testGetSubtotal()
    {
        assertEquals(8.0, sale.getSubTotal());
        assertFalse(sale.getSubTotal() == 4);
    }

    public void testGetDiscountedSubtotal() {
        assertEquals(7.2, sale.getDiscountedSubTotal());
    }

}
