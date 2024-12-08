package edu.neu.csye7374.Decorator;


public class ExtraLegRoomUpgrade extends FlightUpgrade{
    double extraLegRoomCharge = 29.99;
    public ExtraLegRoomUpgrade(FlightUpgradeOptions upgradeOptions) {
        super(upgradeOptions);
    }

    public double basePrice() {
        return this.upgradeOptions.getBasePrice() + extraLegRoomCharge;
    }

    public String getUpgradeDescription() {
        return this.upgradeOptions.getUpgradeDescription() + " with Extra Leg Room Upgrade";
    }
}
