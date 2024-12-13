package controller.ejercicios;
import java.util.Scanner;

public class Agua {
    public static float redondear (float num) {
        //Redondea los decimales de floats
        float aux = num*100.00f;//Multiplica el número por 100 para manejar los decimales
        float aux1 = (float)((int)aux); // Convierte a entero para eliminar los decimales sobrantes
        return (aux1/100.00f);// Divide entre 100 para restaurar el formato original
     }
    public static boolean esNumeroValidoManual(String entrada) {
         // Verifica si una cadena de texto es un número válido (con un separador decimal opcional)
        if (entrada == null || entrada.isEmpty()) {
            return false;
            // Retorna falso si la cadena está vacía o es nula
        }
        boolean separadorDecimalEncontrado = false; // Indica si se encontró un separador decimal
        for (int i = 0; i < entrada.length(); i++) {
            char c = entrada.charAt(i);// Obtiene cada carácter de la cadena
            if (c == '.' || c == ',') {
                if (separadorDecimalEncontrado) {
                    return false; 
                    // Retorna falso si hay más de un separador decimal
                }
                separadorDecimalEncontrado = true;// Marca que se encontró un separador decimal 
            } else if (!Character.isDigit(c)) {
                return false; 
                 // Retorna falso si el carácter no es un dígito
                
            }
        }
        return true;
        // Retorna verdadero si cumple todas las condiciones
    }
    public static float calcularServicioAgua(float consumo) {
        // Calcula el costo del servicio de agua potable según el consumo en m³
        float servicio = 0;

        if (consumo <= 15) {
            servicio = 3.00f;// Tarifa fija para consumo menor o igual a 15 m³
        } else if (consumo <= 25) {
            servicio = 3.00f + (consumo - 15) * 0.10f;// Tarifa fija más un costo adicional por m³
        } else if (consumo <= 40) {
            servicio = 3.00f + (10 * 0.10f) + (consumo - 25) * 0.20f; // Agrega una tarifa intermedia
        } else if (consumo <= 60) {
            servicio = 3.00f + (10 * 0.10f) + (15 * 0.20f) + (consumo - 40) * 0.30f;// Tarifa por consumo elevado
        } else {
            servicio = 3.00f + (10 * 0.10f) + (15 * 0.20f) + (20 * 0.30f) + (consumo - 60) * 0.35f;// Tarifa máxima
        }

        return servicio;
    }
    public static void generarFactura(float servicioAgua, float descuento ){
         // Genera la factura con los detalles de los costos y total a pagar
        servicioAgua -= descuento;// Aplica el descuento al costo del servicio
        float alcantarillado = servicioAgua * 0.35f; // Calcula el impuesto de alcantarillado
        float basura = 0.75f; // Tasa fija por recolección de basura
        float procesamientoDatos = 0.50f; // Tasa fija por procesamiento de datos
        // Imprime los detalles de la factura
        float total = servicioAgua + alcantarillado + basura + procesamientoDatos;// Calcula el total
        System.out.println("Detalle de la planilla:");
        System.out.println("Consumo de agua potable: "+servicioAgua);
        System.out.println("Impuesto de alcantarillado: "+alcantarillado);
        System.out.println("Tasa por recolección de basura: "+basura);
        System.out.println("Tasa por procesamiento de datos: "+procesamientoDatos);
        System.out.println("Total a pagar: "+total);
        }
        // Método principal del programa
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);// Crea un Scanner para leer la entrada del usuario
        System.out.println("Ingrese su consumo de agua en m³:");
        String entrada = sc.nextLine();// Lee el consumo como texto
        // Verifica si la entrada es válida
        if(esNumeroValidoManual(entrada)){
        entrada = entrada.replace(',', '.');// Reemplaza las comas por puntos para el formato decimal
        float consumo = Float.parseFloat(entrada);  // Convierte la cadena en un número flotante
        if(consumo>0){
        System.out.println("¿Es contribuyente es de tercera edad? (si/no)");
        String terceraEdad = sc.nextLine();
        float porcentajeDiscapacidad = 0;// Inicializa el porcentaje de discapacidad
        float descuento = 0;// Inicializa el descuento
        float servicioAgua = calcularServicioAgua(consumo);// Calcula el costo del servicio
        if(terceraEdad.equalsIgnoreCase("si")){
            // Aplica descuento especial para tercera edad
            if (consumo <= 15) {
                descuento = servicioAgua * 0.50f;  // 50% de descuento si el consumo es bajo
            } else {
                descuento = 3.00f * 0.30f; // 30% de descuento sobre la tarifa base
            }
            redondear(consumo);
            generarFactura(servicioAgua, descuento);// Genera la factura
    }else if(terceraEdad.equalsIgnoreCase("no")){
    System.out.println("¿El contribuyente tiene discapacidad? (si/no)");
    String discapacidad = sc.nextLine();
    if (discapacidad.equalsIgnoreCase("si")) {
        System.out.println("Ingrese el porcentaje de discapacidad:");
        porcentajeDiscapacidad = sc.nextFloat();
    } 
     if (porcentajeDiscapacidad>0&&porcentajeDiscapacidad<100) {// Calcula el descuento basado en el porcentaje de discapacidad
        descuento = 3.00f * (porcentajeDiscapacidad / 100); 
        redondear(consumo);
        generarFactura(servicioAgua, descuento);// Genera la factura
    }else if(discapacidad.equalsIgnoreCase("no")){
        redondear(consumo);
        generarFactura(servicioAgua, descuento);// Genera la factura sin descuento
    }else{
        System.out.println("Por favor ingrese un dato valido");
    }
}else{
    System.out.println("Ingrese un dato valido");
}
    
}
}else{
    System.out.println("Ingrese un dato valido");
}
}
}