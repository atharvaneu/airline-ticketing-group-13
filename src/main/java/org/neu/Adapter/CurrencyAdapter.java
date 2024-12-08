package org.neu.Adapter;

public class CurrencyAdapter implements FlightCurrency {

    Currency c ;

    public CurrencyAdapter(Currency c){
        this.c = c;
    }

    @Override
    public void showcurrency(double price) {
        c.showPriceCurrency(price);
    }

}
