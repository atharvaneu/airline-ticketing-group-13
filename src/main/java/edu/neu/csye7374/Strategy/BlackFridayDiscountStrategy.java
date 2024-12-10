package edu.neu.csye7374.Strategy;

public class BlackFridayDiscountStrategy implements DiscountStrategyAPI {
    public static final double Black_friday_Discount_Percent=0.1;

    @Override
    public double CalculateDiscount (double price) {
        double final_price= price-(Black_friday_Discount_Percent*price);
        return final_price;
    }

    @Override
    public String toString(){
        String s="Black Friday Discount - 10%";
        return s;
    }
}
