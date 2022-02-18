/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sauces.sistemanominas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author daw1
 */
public class SistemaNominas{
    private Set<Empleado> empleados;

    public SistemaNominas() {
        empleados=new TreeSet<>();
    }

    public Set<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(TreeSet<Empleado> empleados) {
        this.empleados = empleados;
    }
    
    public boolean incluirEmpleado(Empleado empleado){
        boolean salida=false;
        
        if(empleado!=null && !empleados.contains(empleado)){
            salida=empleados.add(empleado);
        }
        return salida;
    }

    public Empleado getEmpleado(String dni){
        for(Empleado e: empleados){
            if(e.getDni().equals(dni)){
                return e;
            }
        }
        return null;
    }

    public boolean eliminarEmpleado(Empleado empleado){
        if(empleado!=null){
            return empleados.remove(empleado);
        }
        return false;
    }
    
    public List<Empleado> listarEmpleados(){
        return new ArrayList<>(empleados);
    }
    
    public List<Empleado> listarEmpleadosPorSueldo(){
        List<Empleado> salida=new ArrayList<>(empleados);
        
        Collections.sort(salida, new ComparadorSueldo());
        
        return salida;
    }
    public float getTotalDepositos(){
        float acumulador=0;
        for(Empleado c : empleados){
            acumulador+=c.ingresos();
        }
        return acumulador;
    }
 
}

