package Q2.unittests;

import Q2.business.Item;
import junit.framework.TestCase;

public class ItemTests extends TestCase
{
    private Item item;

    protected void setUp() throws Exception
    {
        super.setUp();
        item = new Item("apple", 2.00, 4);
    }

    public void testGetItemTotal()
    {
        assertEquals(8.0, item.getItemTotal());
    }


}
