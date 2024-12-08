package edu.neu.csye7374.Adapter;

public class INRCurrency implements FlightPriceCurrency {
    public double conversionRate = ConversionRate.INR.getRate();

    @Override
    public void showcurrency(double price) {
        System.out.println("Flight Price in Indian Rupees:"+ price*conversionRate);
    }
}
