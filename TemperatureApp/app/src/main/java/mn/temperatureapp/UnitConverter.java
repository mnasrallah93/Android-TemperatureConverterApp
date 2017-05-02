//Mohamed Nasrallah
//CIS 436 - Mobile Application Development
//University of Michigan - Dearborn
//Prof. John P. Baugh
//Project 1 - Temperature Converter
// LAST UPDATED: 2/17/2017

package mn.temperatureapp;

/**
 * Created by mnasr on 2/15/2017.
 */

public class UnitConverter {
    public static double Celsius2Fahrenheit(double c) {
        return 32+c*9/5;
    }

    public static double Fahrenheit2Celsius(double f){

        return (f-32)*5/9;
    }

}
