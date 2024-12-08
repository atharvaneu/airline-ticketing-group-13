package org.neu.Adapter;

public class JapanCurrency implements FlightCurrency {
    public double conversionRate = ConversionRate.JPY.getRate();

    @Override
    public void showcurrency(double price) {
        System.out.println("Flight Price in Japanese Yen:" + price * conversionRate);
    }

}
