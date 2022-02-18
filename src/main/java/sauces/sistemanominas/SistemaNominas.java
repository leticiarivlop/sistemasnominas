/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sauces.sistemanominas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author daw1
 */
public class SistemaNominas {

    private List<Empleado> empleados;

    public SistemaNominas() {
        empleados = new ArrayList<>();
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public boolean incluirEmpleado(Empleado empleado) {
        boolean salida = false;

        if (empleado != null && !empleados.contains(empleado)) {
            salida = empleados.add(empleado);
        }
        return salida;
    }

    public Empleado getEmpleado(String dni) {
        for (Empleado e : empleados) {
            if (e.getDni().equals(dni)) {
                return e;
            }
        }
        return null;
    }

    public boolean eliminarEmpleado(Empleado empleado) {
        if (empleado != null) {
            return empleados.remove(empleado);
        }
        return false;
    }

    public List<Empleado> listarEmpleados() {
        return new ArrayList<>(empleados);
    }

    public List<Empleado> listarEmpleadosPorSueldo() {
        List<Empleado> salida = new ArrayList<>(empleados);

        Collections.sort(salida, new ComparadorSueldo());

        return salida;
    }

    public float getTotalDepositos() {
        float acumulador = 0;
        for (Empleado c : empleados) {
            acumulador += c.ingresos();
        }
        return acumulador;
    }

}
