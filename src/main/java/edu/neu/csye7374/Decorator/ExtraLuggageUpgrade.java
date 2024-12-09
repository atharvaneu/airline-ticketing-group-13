package edu.neu.csye7374.Decorator;
public class ExtraLuggageUpgrade extends FlightUpgrade{
    double extraLuggageChargeValue = 49.99;
    public ExtraLuggageUpgrade(FlightUpgradeOptions upgradeOptions) {
        super(upgradeOptions);
    }

    public double getBasePrice() {
        return this.upgradeOptions.getBasePrice() + extraLuggageChargeValue;
    }

    public String getUpgradeDescription() {
        return this.upgradeOptions.getUpgradeDescription() + " with Extra Luggage Upgrade";
    }

}
