package edu.neu.csye7374.Strategy;

public class NewUserPromoStrategy implements DiscountStrategyAPI {
    public static final double New_User_Promo_Reduce_Price=150.00;

    @Override
    public double CalculateDiscount (double price) {
        double final_price= price-New_User_Promo_Reduce_Price;
        return final_price;
    }

    @Override
    public String toString(){
        String s="New User Promo - $150 off";
        return s;
    }
}