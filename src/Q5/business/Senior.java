package Q5.business;

public class Senior extends Sale
{
    private static double DISCOUNT_RATE_NORMAL = 0.05;
    private static double DISCOUNT_RATE_SENIOR = 0.10;
    @Override
    public double getDiscountRate(String customerType, String dayOfTheWeek) throws Exception {
        if (customerType == "SENIOR")
        {
            if (dayOfTheWeek == "TUESDAY")
                return DISCOUNT_RATE_SENIOR;
            return DISCOUNT_RATE_NORMAL;
        }
        else
        {
            throw new Exception("Error: incorrect customer type");
        }
    }
}
