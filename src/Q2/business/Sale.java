package Q2.business;

import java.util.ArrayList;

public class Sale
{

    private static double DISCOUNT_RATE_NORMAL = 0.10;
    private static double DISCOUNT_RATE_SENIOR = 0.15;
    private static double DISCOUNT_RATE_PREFERRED = 0.20;

    public static ArrayList<Item> itemList = new ArrayList<Item>();

    public void addItem(Item item)
    {
        itemList.add(item);
    }

    public static double getDiscountRate(String customerType) throws Exception
    {
        switch (customerType)
        {
            case "NORMAL":
                return DISCOUNT_RATE_NORMAL;

            case "PREFERRED":
                return DISCOUNT_RATE_PREFERRED;

            case "SENIOR":
                return DISCOUNT_RATE_SENIOR;

            default:
                throw new Exception("Error: incorrect customer type");
        }
    }

    public double getDiscount(String customerType) throws Exception {
        return getSubTotal()*getDiscountRate(customerType);
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

    public double getDiscountedSubTotal(String customerType) throws Exception {
        return getSubTotal() - getDiscount(customerType);
    }

}

