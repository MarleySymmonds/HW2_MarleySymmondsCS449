package Q5.unittests;

import Q5.business.Item;
import Q5.business.Normal;
import Q5.business.Preferred;
import Q5.business.Senior;
import junit.framework.TestCase;
import org.junit.Before;

import static org.junit.Assert.assertThrows;

public class  SalesTests extends TestCase
{
    private Item item;
    private Senior senior;
    private Normal normal;
    private Preferred preferred;
    private static boolean setUpIsDone = false;

    @Before
    protected void setUp() throws Exception
    {
        if (setUpIsDone)
        {
            return;
        }
        senior = new Senior();
        normal = new Normal();
        preferred = new Preferred();
        item = new Item("apple", 2.00, 4);
        senior.addItem(item);
        setUpIsDone = true;
    }

    public void testGetDiscountNormal() throws Exception {
        assertEquals(3*0.05, normal.getDiscount("NORMAL", "TUESDAY"));
        assertFalse(normal.getDiscount("NORMAL", "TUESDAY") == 3 * 0.10);
    }

    public void testGetDiscountSeniorTuesday() throws Exception {
        assertEquals(3*0.10, senior.getDiscount("SENIOR", "TUESDAY"));
        assertFalse(senior.getDiscount("SENIOR", "TUESDAY") == 3 * 0.05);
    }

    public void testGetDiscountSeniorMonday() throws Exception {
        assertEquals(3*0.05, senior.getDiscount("SENIOR", "MONDAY"));
        assertFalse(senior.getDiscount("SENIOR", "MONDAY") == 3 * 0.10);
    }

    public void testGetDiscountPreferred() throws Exception {
        assertEquals(3*0.15, preferred.getDiscount("PREFERRED", "TUESDAY"));
        assertFalse(preferred.getDiscount("PREFERRED", "TUESDAY") == 3 * 0.10);
    }

    public void testGetDiscountWrongType() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            preferred.getDiscount("NONE", "TUESDAY");
        });

        String expectedMessage = "Error: incorrect customer type";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    public void testGetSubtotal()
    {
        assertEquals(3.0, senior.getSubTotal());
        assertFalse(senior.getSubTotal() == 4);
    }

    public void testGetDiscountedSubtotalNormal() throws Exception {
        assertTrue(normal.getDiscountedSubTotal("NORMAL", "TUESDAY") == 3- (3*0.05));
        assertFalse(normal.getSubTotal() == 4);
    }

    public void testGetDiscountedSubtotalSeniorTuesday() throws Exception {
        assertTrue(senior.getDiscountedSubTotal("SENIOR", "TUESDAY") == 3 - (3*0.10));
        assertFalse(senior.getSubTotal() == 4);
    }

    public void testGetDiscountedSubtotalSeniorMonday() throws Exception {
        assertTrue(senior.getDiscountedSubTotal("SENIOR", "MONDAY") == 3 - (3*0.05));
        assertFalse(senior.getSubTotal() == 4);
    }

    public void testGetDiscountedSubtotalPreferred() throws Exception {
        assertTrue(preferred.getDiscountedSubTotal("PREFERRED", "TUESDAY") == 3 - (3*0.15));
        assertFalse(preferred.getSubTotal() == 4);
    }

    public void testGetDiscountedSubtotalNone() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            senior.getDiscountedSubTotal("NONE", "TUESDAY");
        });

        String expectedMessage = "Error: incorrect customer type";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    public void testHalfOffDiscount() throws Exception
    {
        senior.addItem(new Item("candy", 3, 1));
        assertEquals(3.00, item.getItemTotal());
        senior.addItem(new Item("whipped cream", 4, 3));
        assertEquals(8.00, item.getItemTotal());
    }

}
