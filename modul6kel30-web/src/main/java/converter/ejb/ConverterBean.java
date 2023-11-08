/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package converter.ejb;

import java.text.DecimalFormat;
import jakarta.ejb.Stateless;
import jakarta.ejb.LocalBean;

@Stateless
@LocalBean
public class ConverterBean implements ConverterBeanLocal {

    private DecimalFormat twoDigits = new DecimalFormat("0.00");

    public String ftok(double f) {
        String result = twoDigits.format(((f - 32) * 5.0 / 9.0
                + 273.15) * 100 / 100.0);
        return result;
    }

    public String ktof(double k) {
        String result = twoDigits.format(((k - 273.15) * 9.0 / 5.0
                + 32) * 100 / 100.0);
        return result;
    }
}
