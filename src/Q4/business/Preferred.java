package Q4.business;

public class Preferred extends Sale
{
    private static double DISCOUNT_RATE_PREFERRED = 0.15;
    @Override
    public double getDiscountRate(String customerType, String dayOfTheWeek) throws Exception {
        if (customerType == "PREFERRED")
            return DISCOUNT_RATE_PREFERRED;
        else
        {
            throw new Exception("Error: incorrect customer type");
        }
    }
}
