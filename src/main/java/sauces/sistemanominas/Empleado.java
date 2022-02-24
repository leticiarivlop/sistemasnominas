/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sauces.sistemanominas;

import java.util.Objects;

/**
 *
 * @author daw1
 */
public abstract class Empleado implements Comparable<Empleado> {

    private Dni dni;
    private String nombre;

    /**
     *
     */
    public Empleado() {
    }

    /**
     *
     * @param dni
     * @param nombre
     */
    public Empleado(Dni dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return dni + "," + nombre;
    }

    /**
     *
     * @param empleado
     * @return
     */
    @Override
    public int compareTo(Empleado empleado) {
        return this.dni.compareTo(empleado.dni);
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.dni);
        return hash;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof Empleado) {
            final Empleado other = (Empleado) obj;
            if (this.dni.equals(other.dni)) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @return
     */
    public Dni getDni() {
        return dni;
    }

    /**
     *
     * @param dni
     */
    public void setDni(Dni dni) {
        this.dni = dni;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public abstract float ingresos();

}
