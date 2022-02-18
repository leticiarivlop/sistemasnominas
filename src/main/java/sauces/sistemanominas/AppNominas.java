/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sauces.sistemanominas;

import java.util.Scanner;

/**
 *
 * @author daw1
 */
public class AppNominas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    SistemaNominas sn = new SistemaNominas();
        int opcion;
        Scanner teclado = new Scanner(System.in);
        String dni, nombre;
        float salario, salarioHora;
        int horas;
        Empleado e;

        do {
            System.out.println("1. Crear empelado fijo");
            System.out.println("2. Crear empleado eventual");
            System.out.println("3. Consultar empleado");
            System.out.println("4. Eliminar empleado");
            System.out.println("5. Listar empleados (DNI)");
            System.out.println("6. Listar empleados (SUELDO)");
            System.out.println("7. Consultar total salarios");
            System.out.println("0. Salir");
            System.out.println("Introduzca opcion");
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Introduzca el DNI: ");
                    dni = teclado.nextLine();
                    System.out.println("Introduzca el nombre: ");
                    nombre = teclado.nextLine();
                    System.out.println("Introduzca el salario: ");
                    salario = teclado.nextFloat();
                    if (sn.incluirEmpleado(new EmpleadoFijo(dni, nombre, salario))) {
                        System.out.println("Empleado incluido en el sistema");
                    } else {
                        System.out.println("No se ha podido incluir el empleado en el sistema");
                    }
                    break;
                case 2:
                    System.out.println("Introduzca el DNI: ");
                    dni = teclado.nextLine();
                    System.out.println("Introduzca el nombre: ");
                    nombre = teclado.nextLine();
                    System.out.println("Introduzca el salario: ");
                    salarioHora = teclado.nextFloat();
                    System.out.println("Introduzca número de horas");
                    horas = teclado.nextInt();
                    teclado.nextLine();
                    if (sn.incluirEmpleado(new EmpleadoEventual(dni, nombre, salarioHora, horas))) {
                        System.out.println("Empleado incluido en el sistema");
                    } else {
                        System.out.println("No se ha podido incluir el empleado en el sistema");
                    }
                    break;
                case 3:
                    System.out.println("Introduce el DNI del empleado: ");
                    dni = teclado.nextLine();
                    e = sn.getEmpleado(dni);
                    if (e != null) {
                        System.out.println(e);
                    }
                    break;
                case 4:
                    System.out.println("Introduce el DNI del empleado: ");
                    dni = teclado.nextLine();
                    e = sn.getEmpleado(dni);
                    if (e != null) {
                        System.out.println("Empleado a eliminar" + e);
                        System.out.println("Si/No");
                        String seguro = teclado.nextLine();
                        if (seguro.equals("SI")) {
                            if (sn.eliminarEmpleado(e)) {
                                System.out.println("Empleado eliminado");
                            } else {
                                System.out.println("Empleado no se a podido eliminar");
                            }
                        }
                    } else {
                        System.out.println("Empleado no existe");
                    }
                case 5:
                    for (Empleado e1 : sn.listarEmpleados()) {
                        System.out.println(e1);
                    }
                    break;
                case 6:
                    for (Empleado e1 : sn.listarEmpleadosPorSueldo()) {
                        System.out.println(e1);
                    }
                    break;
                case 7:
                    System.out.println("Total salarios" + sn.getTotalDepositos());

                    break;
                case 0:
                    break;
                default:
            }
        } while (opcion != 0);

    }

}
