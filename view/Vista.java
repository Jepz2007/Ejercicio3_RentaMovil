package view;
import java.util.Scanner;
import model.Vehiculos;

public class Vista {
    private Scanner scanner;

    public Vista() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("\n||| RentaMovil |||");
        System.out.println("1. Registrar vehículo");
        System.out.println("2. Consultar flota");
        System.out.println("3. Cotizar alquiler");
        System.out.println("4. Confirmar alquiler");
        System.out.println("5. Registrar devolución");
        System.out.println("6. Mostrar reporte general");
        System.out.println("0. Salir");
    }

    public int solicitarEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine().trim();
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                mostrarMensaje("Ingrese un número entero válido.");
            }
        }
    }

    public int solicitarEnteroPositivo(String mensaje) {
        while (true) {
            int valor = solicitarEntero(mensaje);
            if (valor > 0) {
                return valor;
            }
            mostrarMensaje("El valor debe ser mayor que cero.");
        }
    }

    public float solicitarDecimalPositivo(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine().trim();
            try {
                float valor = Float.parseFloat(entrada);
                if (valor > 0) {
                    return valor;
                }
                mostrarMensaje("El valor debe ser mayor que cero.");
            } catch (NumberFormatException e) {
                mostrarMensaje("Ingrese un número válido.");
            }
        }
    }

    public String solicitarTexto(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = scanner.nextLine().trim();
            if (!texto.isEmpty()) {
                return texto;
            }
            mostrarMensaje("El dato no puede estar vacío.");
        }
    }

    public boolean solicitarConfirmacion(String mensaje) {
        while (true) {
            String respuesta = solicitarTexto(mensaje + " (S/N): ");
            if (respuesta.equalsIgnoreCase("S")) {
                return true;
            }
            if (respuesta.equalsIgnoreCase("N")) {
                return false;
            }
            mostrarMensaje("Ingrese S para confirmar o N para cancelar.");
        }
    }

    public void mostrarVehiculo(Vehiculos vehiculo) {
        System.out.println();
        vehiculo.getInfo();
    }

    public void mostrarCotizacion(Vehiculos vehiculo, int dias, float total) {
        mostrarVehiculo(vehiculo);
        System.out.println("Días de la cotización: " + dias);
        System.out.printf("Costo total: Q%.2f%n", total);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
