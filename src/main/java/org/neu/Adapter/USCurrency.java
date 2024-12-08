package org.neu.Adapter;

public class USCurrency implements Currency {

    @Override
    public void showPriceCurrency(double price) {
        System.out.println("Flight Price in US Dollars:"+ price);
    }




}
