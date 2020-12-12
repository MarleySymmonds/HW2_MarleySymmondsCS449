package Q5.business;

public class Item {
    private static String title;
    private static double origUnitPrice;
    private static int quantity;

    public Item(String name, double unitPrice, int number)
    {
        title = name;
        origUnitPrice = unitPrice;
        quantity = number;
    }

    public double getItemTotal()
    {
        if (quantity > 1)
            return origUnitPrice + (0.5 * origUnitPrice * (quantity - 1));
        else
            return origUnitPrice;
    }
}
