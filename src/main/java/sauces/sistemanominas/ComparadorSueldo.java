/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sauces.sistemanominas;

import java.util.Comparator;

/**
 *
 * @author daw1
 */
public class ComparadorSueldo implements Comparator<Empleado> {

    /**
     *
     * @param e1
     * @param e2
     * @return
     */
    @Override
    public int compare(Empleado e1, Empleado e2) {
        int salida = 0;
        float sueldo1, sueldo2;
        sueldo1 = e1.ingresos();
        sueldo2 = e2.ingresos();
        
        if (sueldo1 < sueldo2) {
            salida = -1;
        } else {
            if (sueldo1 > sueldo2) {
                salida = 1;
            }
        }
        return salida;
    }

}
