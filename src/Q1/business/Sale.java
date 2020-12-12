package Q1.business;

import java.util.ArrayList;

public class Sale
{

    private static double DISCOUNT_RATE = 0.10;


    public static ArrayList<Item> itemList = new ArrayList<Item>();

    public void addItem(Item item)
    {
        itemList.add(item);
    }

    public static double getDiscountRate()
    {
        return DISCOUNT_RATE;
    }

    public double getDiscount() {
        return getSubTotal()*getDiscountRate();
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

    public double getDiscountedSubTotal() {
        return getSubTotal() - getDiscount();
    }

}

