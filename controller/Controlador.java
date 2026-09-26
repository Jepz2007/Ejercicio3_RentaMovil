package controller;
import model.*;
import view.Vista;

public class Controlador {
    private RegistroVehiculos registroVehiculos;
    private Vista vista;

    public Controlador(RegistroVehiculos registroVehiculos, Vista vista) {
        this.registroVehiculos = registroVehiculos;
        this.vista = vista;
    }

    public void iniciar() {
        int opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.solicitarEntero("Seleccione una opción: ");
            switch (opcion) {
                case 1:
                    registrarVehiculo();
                    break;
                case 2:
                    consultarFlota();
                    break;
                case 3:
                    cotizarAlquiler();
                    break;
                case 4:
                    confirmarAlquiler();
                    break;
                case 5:
                    registrarDevolucion();
                    break;
                case 6:
                    mostrarReporteGeneral();
                    break;
                case 0:
                    vista.mostrarMensaje("Programa finalizado.");
                    break;
                default:
                    vista.mostrarMensaje("La opción seleccionada no existe.");
            }
        } while (opcion != 0);
    }

    public void registrarVehiculo() {
        vista.mostrarMensaje("1. Automóvil\n2. Motocicleta\n3. Camioneta");
        int tipo = vista.solicitarEntero("Seleccione el tipo de vehículo: ");
        if (tipo < 1 || tipo > 3) {
            vista.mostrarMensaje("El tipo de vehículo no existe.");
            return;
        }

        String placa = vista.solicitarTexto("Placa: ");
        if (registroVehiculos.buscarVehiculo(placa) != null) {
            vista.mostrarMensaje("No se puede registrar: la placa ya existe.");
            return;
        }

        String marca = vista.solicitarTexto("Marca: ");
        String modelo = vista.solicitarTexto("Modelo: ");
        float tarifa = vista.solicitarDecimalPositivo("Tarifa diaria: Q");
        Vehiculos nuevo;

        if (tipo == 1) {
            int pasajeros = vista.solicitarEnteroPositivo("Cantidad de pasajeros: ");
            int opcionTransmision;
            do {
                opcionTransmision = vista.solicitarEntero("Transmisión (1. Automático, 2. Manual): ");
                if (opcionTransmision != 1 && opcionTransmision != 2) {
                    vista.mostrarMensaje("Seleccione 1 o 2.");
                }
            } while (opcionTransmision != 1 && opcionTransmision != 2);
            TipoTransmision transmision = opcionTransmision == 1
                    ? TipoTransmision.AUTOMATICO : TipoTransmision.MANUAL;
            nuevo = new Automovil(placa, marca, modelo, tarifa, true, 0, pasajeros, transmision);
        } else if (tipo == 2) {
            int cilindraje = vista.solicitarEnteroPositivo("Cilindraje: ");
            nuevo = new Motocicleta(placa, marca, modelo, tarifa, true, 0, cilindraje);
        } else {
            float capacidad = vista.solicitarDecimalPositivo("Capacidad máxima en toneladas: ");
            nuevo = new Camioneta(placa, marca, modelo, tarifa, true, 0, capacidad);
        }

        registroVehiculos.registrarVehiculo(nuevo);
        vista.mostrarMensaje("Vehículo registrado correctamente.");
    }

    public void consultarFlota() {
        if (registroVehiculos.cantidadRegistros() == 0) {
            vista.mostrarMensaje("No hay vehículos registrados.");
            return;
        }
        for (Vehiculos vehiculo : registroVehiculos.obtenerTodos()) {
            vista.mostrarVehiculo(vehiculo);
        }
    }

    public void cotizarAlquiler() {
        Vehiculos vehiculo = solicitarVehiculoPorPlaca();
        if (vehiculo == null) {
            return;
        }
        int dias = vista.solicitarEnteroPositivo("Cantidad de días: ");
        float total = vehiculo.calcularTarifaFinal(dias);
        vista.mostrarCotizacion(vehiculo, dias, total);
        if (!vehiculo.isDisponibilidad()) {
            vista.mostrarMensaje("El vehículo está alquilado; esta información es solamente una cotización.");
        }
    }

    public void confirmarAlquiler() {
        Vehiculos vehiculo = solicitarVehiculoPorPlaca();
        if (vehiculo == null) {
            return;
        }
        if (!vehiculo.isDisponibilidad()) {
            vista.mostrarMensaje("No se puede alquilar: el vehículo está ocupado.");
            return;
        }

        int dias = vista.solicitarEnteroPositivo("Cantidad de días: ");
        float total = vehiculo.calcularTarifaFinal(dias);
        vista.mostrarCotizacion(vehiculo, dias, total);
        if (!vista.solicitarConfirmacion("¿Desea confirmar el alquiler?")) {
            vista.mostrarMensaje("Alquiler cancelado; no se modificó la información.");
            return;
        }

        vehiculo.setDisponibilidad(false);
        vehiculo.setDiasAlquilados(dias);
        registroVehiculos.registrarIngreso(total);
        vista.mostrarMensaje("Alquiler confirmado correctamente.");
    }

    public void registrarDevolucion() {
        Vehiculos vehiculo = solicitarVehiculoPorPlaca();
        if (vehiculo == null) {
            return;
        }
        if (vehiculo.isDisponibilidad()) {
            vista.mostrarMensaje("No se puede devolver: el vehículo ya está disponible.");
            return;
        }
        vehiculo.devolverVehiculo();
        vista.mostrarMensaje("Devolución registrada correctamente.");
    }

    public void mostrarReporteGeneral() {
        int autosDisponibles = registroVehiculos.automovilesDisponibles();
        int motosDisponibles = registroVehiculos.motocicletasDisponibles();
        int camionetasDisponibles = registroVehiculos.camionetasDisponibles();

        vista.mostrarMensaje("\n=== Reporte general ===");
        vista.mostrarMensaje("Total de vehículos: " + registroVehiculos.cantidadRegistros());
        mostrarCategoria("Automóviles", registroVehiculos.cantidadAutomoviles(), autosDisponibles);
        mostrarCategoria("Motocicletas", registroVehiculos.cantidadMotocicletas(), motosDisponibles);
        mostrarCategoria("Camionetas", registroVehiculos.cantidadCamionetas(), camionetasDisponibles);
        vista.mostrarMensaje(String.format("Ingresos acumulados: Q%.2f", registroVehiculos.totalIngresos()));
    }

    private Vehiculos solicitarVehiculoPorPlaca() {
        String placa = vista.solicitarTexto("Placa del vehículo: ");
        Vehiculos vehiculo = registroVehiculos.buscarVehiculo(placa);
        if (vehiculo == null) {
            vista.mostrarMensaje("No existe un vehículo con esa placa.");
        }
        return vehiculo;
    }

    private void mostrarCategoria(String nombre, int total, int disponibles) {
        vista.mostrarMensaje(nombre + ": " + total + " registrados, "
                + disponibles + " disponibles y " + (total - disponibles) + " alquilados.");
    }
}
