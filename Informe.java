package controller.ejercicios;

import java.util.Scanner;

public class Informe {
    // Método para verificar si un nombre es válido
    public static boolean esNombreValido(String nombre) {
        // Verificar si el nombre contiene números
        for (int i = 0; i < nombre.length(); i++) {
            if (Character.isDigit(nombre.charAt(i))) {
                return false; // Si contiene un número, no es válido
            }
        }
        return true; // Si no contiene números, es válido
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Crear un objeto Scanner para entrada de datos

        // Solicitar el nombre del empleado
        System.out.println("Ingrese nombre del empleado");
        String name = sc.nextLine();

        // Validar el nombre ingresado
        if (!esNombreValido(name)) {
            System.out.println("El nombre no puede contener números");
        } else {
            // Solicitar el apellido del empleado
            System.out.println("Ingrese apellido del empleado");
            String apellido = sc.nextLine();

            // Validar el apellido ingresado
            if (!esNombreValido(name)) {
                System.out.println("El nombre no puede contener números");
            } else {
                // Solicitar el número de autos vendidos
                System.out.println("Ingrese el numero de autos que ha vendido");
                int autos = sc.nextInt();

                int num = 0; // Contador para iterar el número de autos vendidos
                double totalauto = 0.0; // Acumulador del valor total de los autos
                double sueldo = 2500; // Sueldo base del empleado
                double comision = 0.0; // Acumulador de las comisiones por autos

                // Ciclo para procesar cada auto vendido
                while (num < autos) {
                    System.out.println("Ingrese el precio del auto");
                    int precioautos = sc.nextInt(); // Leer el precio del auto
                    totalauto = totalauto + precioautos; // Sumar al total de autos

                    // Verificar si el auto califica para comisión
                    if (precioautos > 10000) {
                        comision = comision + 250; // Incrementar la comisión
                    }
                    num = num + 1; // Incrementar el contador
                }

                double utilidad = (totalauto * 5) / 100; // Calcular la utilidad (5% del total de autos)
                double pago = comision + sueldo + utilidad; // Calcular el pago total

                // Imprimir el informe final
                System.out.println("----INFORME----");
                System.out.println("Empleado: " + name + " " + apellido);
                System.out.println("Numero de Autos Vendidos: " + autos);
                System.out.println("Valor Total de los Autos: " + totalauto + "$");
                System.out.println("Sueldo Mensual: " + sueldo + "$");
                System.out.println("Comisión: " + comision + "$");
                System.out.println("Utilidad: " + utilidad + "$");
                System.out.println("Pago Total: " + pago + "$");
            }
        }
    }
}
