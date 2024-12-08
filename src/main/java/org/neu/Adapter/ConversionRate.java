package org.neu.Adapter;

public enum ConversionRate {
    EUR("Euro", 0.92),
    GBP("British Pound", 0.79),
    INR("Indian Rupee", 83.2),
    JPY("Japanese Yen", 148.5),
    AUD("Australian Dollar", 1.57);

    ConversionRate(String currencyType, double rateToUSD) {
        this.currencyType = currencyType;
        this.rateToUSD = rateToUSD;
    }

    public final String currencyType;
    public final double rateToUSD;

    public double getRate() {
        return rateToUSD;
    }
}
