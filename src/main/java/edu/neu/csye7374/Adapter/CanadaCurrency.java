/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye7374.Adapter;

/**
 *
 * @author asequ
 */

public class CanadaCurrency implements FlightPriceCurrency {
    public double conversionRate = 1.37;

    @Override
    public void showcurrency(double price) {
        System.out.println("Flight Price in Canadian Dollars:" + price * conversionRate);
    }

}
