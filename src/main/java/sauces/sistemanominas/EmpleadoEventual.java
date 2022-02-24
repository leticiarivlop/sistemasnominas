/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sauces.sistemanominas;

/**
 *
 * @author daw1
 */
public class EmpleadoEventual extends Empleado{
    
    private float salarioHora;
    private int horas;

    /**
     *
     */
    public EmpleadoEventual() {
    }

    /**
     *
     * @param dni
     * @param nombre
     * @param salarioHora
     * @param horas
     */
    public EmpleadoEventual( Dni dni, String nombre,float salarioHora, int horas) {
        super(dni, nombre);
        this.salarioHora = salarioHora;
        this.horas = horas;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return super.toString()+","+salarioHora+","+horas; 
    }

    /**
     *
     * @return
     */
    public float getSalarioHora() {
        return salarioHora;
    }

    /**
     *
     * @param salarioHora
     */
    public void setSalarioHora(float salarioHora) {
        this.salarioHora = salarioHora;
    }

    /**
     *
     * @return
     */
    public int getHoras() {
        return horas;
    }

    /**
     *
     * @param horas
     */
    public void setHoras(int horas) {
        this.horas = horas;
    }

    /**
     *
     * @return
     */
    @Override
    public float ingresos() {
        return salarioHora*horas;
    }
    
    
}
