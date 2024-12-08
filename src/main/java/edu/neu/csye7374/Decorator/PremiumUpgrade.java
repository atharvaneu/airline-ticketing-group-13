package edu.neu.csye7374.Decorator;
public class PremiumUpgrade extends FlightUpgrade{
    double premiumCharge = 99.99;
    public PremiumUpgrade(FlightUpgradeOptions upgradeOptions) {
        super(upgradeOptions);
    }

    public double getBasePrice() {
        return this.upgradeOptions.getBasePrice() + premiumCharge;
    }

    public String getUpgradeDescription() {
        return this.upgradeOptions.getUpgradeDescription() + " with Premium Upgrade";
    }

}
