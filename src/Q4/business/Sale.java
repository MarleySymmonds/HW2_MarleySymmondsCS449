package Q4.business;

import java.util.ArrayList;

public abstract class Sale
{

    private static double DISCOUNT_RATE_NORMAL = 0.05;

    private static double DISCOUNT_RATE_PREFERRED = 0.15;

    public static ArrayList<Item> itemList = new ArrayList<Item>();

    public void addItem(Item item)
    {
        itemList.add(item);
    }

    public abstract double getDiscountRate(String customerType, String dayOfTheWeek) throws Exception;

    public double getDiscount(String customerType, String dayOfTheWeek) throws Exception {
        return getSubTotal()*getDiscountRate(customerType, dayOfTheWeek);
    }

    public static double getSubTotal()
    {
        double subTotal = 0.0;
        for (Item item: itemList)
        {
            subTotal += item.getItemTotal();
        }
        return subTotal;
    }

    public double getDiscountedSubTotal(String customerType, String dayOfTheWeek) throws Exception {
        return getSubTotal() - getDiscount(customerType, dayOfTheWeek);
    }

}

