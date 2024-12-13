package controller.ejercicios;
import java.util.Scanner;
enum Zona {
    AMERICA_DEL_NORTE,
    AMERICA_CENTRAL,
    AMERICA_DEL_SUR,
    EUROPA,
    ASIA,
    AFRICA,
    OCEANIA,
    RESTO_DEL_MUNDO;

    // Obtiene el precio por minuto según la zona
    public double getPrecioPorMinuto() {
        switch (this) {
            case AMERICA_DEL_NORTE: return 2.75;
            case AMERICA_CENTRAL: return 1.89;
            case AMERICA_DEL_SUR: return 1.60;
            case EUROPA: return 3.50;
            case ASIA: return 4.50;
            case AFRICA: return 3.10;
            case OCEANIA: return 3.00;
            case RESTO_DEL_MUNDO: return 6.00;
            default: return 0.0; // Valor por defecto
        }
    }

    // Busca una zona basada en la clave ingresada
    public static Zona buscarPorClave(int clave) {
        switch (clave) {
            case 1: return AMERICA_DEL_NORTE;
            case 2: return AMERICA_CENTRAL;
            case 3: return AMERICA_DEL_SUR;
            case 4: return EUROPA;
            case 5: return ASIA;
            case 6: return AFRICA;
            case 7: return OCEANIA;
            case 8: return RESTO_DEL_MUNDO;
            default: return null; // Retorna null si la clave no es válida
        }
    }
}

// Clase que calcula el costo de llamadas internacionales
public class Llamada {

    // Calcula la tarifa total basada en la zona y los minutos
    public static double tarifa(Zona zona, double minutos) {
        return zona.getPrecioPorMinuto() * minutos;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Menú para elegir la zona geográfica
        System.out.println("Escoja la zona geográfica del país de destino");
        System.out.println("Ingrese un número");
        System.out.println("1. América Del Norte");
        System.out.println("2. América Central");
        System.out.println("3. América del Sur");
        System.out.println("4. Europa");
        System.out.println("5. Asia");
        System.out.println("6. África");
        System.out.println("7. Oceanía");
        System.out.println("8. Resto del Mundo");

        int clave = sc.nextInt(); // Lee la clave ingresada
        Zona zona = Zona.buscarPorClave(clave); // Busca la zona correspondiente

        if (zona == null) {
            // Mensaje de error si la clave no es válida
            System.out.println("Clave de zona no válida. Por favor, intente de nuevo.");
            sc.close();
            return;
        }

        // Solicita la cantidad de minutos de la llamada
        System.out.println("Ingrese el número de minutos que desea hablar:");
        double minutos = sc.nextDouble();

        // Calcula el costo total de la llamada
        double total = tarifa(zona, minutos);

        // Imprime el detalle de la llamada y los costos
        System.out.printf("Zona: %s\n", zona.name().replace('_', ' '));
        System.out.printf("Clave: %d\n", clave);
        System.out.printf("Costo por minuto: $%.2f USD\n", zona.getPrecioPorMinuto());
        System.out.printf("Total por %.0f minutos: $%.2f USD\n", minutos, total);
    }
}