package Q3.business;

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
        return origUnitPrice * quantity;
    }
}
