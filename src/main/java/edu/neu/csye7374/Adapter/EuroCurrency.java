package edu.neu.csye7374.Adapter;

public class EuroCurrency implements FlightPriceCurrency {
    public double conversionRate = ConversionRate.EUR.getRate();

    @Override
    public void showcurrency(double price) {
        System.out.println("Flight Price in Euros:"+ price*conversionRate);
    }
}
