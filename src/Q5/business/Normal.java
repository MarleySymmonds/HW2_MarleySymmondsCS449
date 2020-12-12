package Q5.business;

public class Normal extends Sale
{
    private static double DISCOUNT_RATE_NORMAL = 0.05;
    @Override
    public double getDiscountRate(String customerType, String dayOfTheWeek) throws Exception {
        if (customerType == "NORMAL")
            return DISCOUNT_RATE_NORMAL;
        else
        {
            throw new Exception("Error: incorrect customer type");
        }
    }
}
