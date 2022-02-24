/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sauces.sistemanominas;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author daw1
 */
public class Dni implements Comparable<Dni> {

    private String numero;
    private char letra;

    /**
     *
     */
    public Dni() {

    }

    /**
     *
     * @param numero
     * @param letra
     * @throws DniException
     */
    public Dni(String numero, char letra) throws DniException {
        if (!esValido(numero + letra)) {
            throw new DniException("Formato incorrecto de DNI");
        }
        this.numero = numero;
        this.letra = letra;
    }

    /**
     *
     * @param dni
     * @throws DniException
     */
    public Dni(String dni) throws DniException {
        if (!esValido(dni)) {
            throw new DniException("Formato incorrecto de DNI");
        }
        this.numero = dni.substring(0, 7);
        this.letra = dni.charAt(8);
    }

    /**
     *
     * @return
     */
    public String getNumero() {
        return numero;
    }

    /**
     *
     * @return
     */
    public char getLetra() {
        return letra;
    }

    /**
     *
     * @param dni
     */
    public void setDni(String dni) {

    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.numero);
        hash = 53 * hash + this.letra;
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
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dni other = (Dni) obj;
        if (this.letra != other.letra) {
            return false;
        }
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Dni o) {
        return this.numero.compareTo(o.numero);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return numero + letra;
    }

    /**
     *
     * @param dni
     * @return
     */
    public static boolean esValido(String dni) {
        boolean correcto = false;
        int resto;
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        String patron = "([0-9]{8})([A-Z])";
        Pattern p = Pattern.compile(patron);
        Matcher m = p.matcher(dni);
        if (m.matches()) {
            resto = Integer.parseInt(m.group(1)) % 23;
            if (letras.charAt(resto) == m.group(2).charAt(0)) {
                correcto = true;
            }

        }
        return correcto;
    }

    /**
     *
     * @param dni
     * @return
     * @throws DniException
     */
    public static Dni valueof(String dni) throws DniException {
        return new Dni(dni);
    }
}
