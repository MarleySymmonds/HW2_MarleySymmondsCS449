package Q3.business;

import java.util.ArrayList;

public class Sale
{

    private static double DISCOUNT_RATE_NORMAL = 0.05;
    private static double DISCOUNT_RATE_SENIOR = 0.10;
    private static double DISCOUNT_RATE_PREFERRED = 0.15;

    public static ArrayList<Item> itemList = new ArrayList<Item>();

    public void addItem(Item item)
    {
        itemList.add(item);
    }

    public static double getDiscountRate(String customerType, String dayOfTheWeek) throws Exception
    {
        switch (customerType)
        {
            case "NORMAL":
                return DISCOUNT_RATE_NORMAL;

            case "PREFERRED":
                return DISCOUNT_RATE_PREFERRED;

            case "SENIOR":
                if (dayOfTheWeek == "TUESDAY")
                    return DISCOUNT_RATE_SENIOR;
                return DISCOUNT_RATE_NORMAL;

            default:
                throw new Exception("Error: incorrect customer type");
        }
    }

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

