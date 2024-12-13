package controller.ejercicios;

import java.util.Scanner;

public class Secuencia {
    // Método para leer un número entero desde el teclado
    public static int leerNumeroEntero(Scanner sc) {
        int numero = 0;
        boolean valido = false;

        // Ciclo para asegurar que se ingrese un número válido
        while (!valido) {
            if (sc.hasNextInt()) {
                numero = sc.nextInt(); // Si es un número entero, lo lee
                valido = true; // La entrada es válida, salimos del bucle
            } else {
                System.out.println("Por favor, ingrese un número entero.");
                sc.next(); // Limpiar el buffer de la entrada no válida
            }
        }
        return numero;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Creación del objeto Scanner para entrada de datos
        System.out.println("Ingrese el numero de terminos de la serie");
        int num_serie = leerNumeroEntero(sc); // Lee el número de términos de la serie
        String resp = "La serie es:\n"; // Variable para almacenar el texto de la serie
        String serie = "Serie:"; // Representación de la serie
        double respuesta = 0; // Variable para acumular el resultado de la serie

        // Verifica si el número de términos ingresado es mayor a 0
        if (num_serie > 0) {
            for (int i = 1; i <= num_serie; i++) {
                int numerador = fiboancci(i); // Calcula el término Fibonacci para el numerador
                int denominador = impar(i); // Calcula el término impar para el denominador
                int exponente = exponente(i); // Calcula el exponente de cada término
                String signo;

                // Determina el signo del término actual
                if (i == 1) {
                    signo = ""; // El primer término no tiene signo
                } else if (i % 2 == 0) {
                    signo = "+"; // Términos en posiciones pares tienen signo positivo
                } else {
                    signo = "-"; // Términos en posiciones impares tienen signo negativo
                }

                // Construye la representación de la serie
                serie += signo + "(" + numerador + "/" + denominador + ")^" + exponente;

                // Calcula el término actual de la serie
                double term = Math.pow((double) numerador / denominador, exponente);
                if (signo.equals("-")) {
                    respuesta -= term; // Resta el término si el signo es negativo
                } else {
                    respuesta += term; // Suma el término si el signo es positivo
                }
            }

            // Agrega la serie al texto de respuesta
            resp += serie;

            // Imprime la serie y el resultado final
            System.out.println(resp);
            System.out.println("El resultado es: " + respuesta);
        } else {
            // Mensaje de error si el número de términos ingresado es menor o igual a 0
            System.out.println("Ingrese un numero mayor 0");
        }
    }

    // Método para calcular el enésimo término de la secuencia de Fibonacci
    public static int fiboancci(int numero) {
        int fibcc = 0; // Inicializa el primer término de Fibonacci
        int b = 1; // Inicializa el segundo término de Fibonacci
        int c = 0; // Variable para almacenar el término actual

        // Ciclo para calcular el enésimo término
        for (int i = 1; i <= numero; i++) {
            c = fibcc + b; // Calcula el término actual como la suma de los dos anteriores
            fibcc = b; // Actualiza el término anterior
            b = c; // Actualiza el término actual
        }
        return fibcc; // Devuelve el término de Fibonacci calculado
    }

    // Método para calcular el enésimo número impar
    public static int impar(int numero) {
        int imp = 1; // Inicializa el primer número impar

        // Ciclo para calcular el enésimo número impar
        if (numero > 1) {
            for (int i = 1; i < numero; i++) {
                imp += 2; // Incrementa el número impar en 2
            }
        }
        return imp; // Devuelve el número impar calculado
    }

    // Método para calcular el exponente de un término
    public static int exponente(int numero) {
        int exp;
        exp = numero * 2; // Calcula el exponente como el doble del número
        return exp; // Devuelve el exponente calculado
    }
}

