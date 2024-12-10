package edu.neu.csye7374.Strategy;

public class EmployeeDiscountStrategy implements DiscountStrategyAPI {
    public static final double Employee_Discount_Percent=0.5;

    @Override
    public double CalculateDiscount (double price) {
        double final_price= price-(Employee_Discount_Percent*price);
        return final_price;
    }

    @Override
    public String toString(){
        String s="Employee Discount - 50%";
        return s;

    }
}
