import model.*;
import view.Vista;
import controller.Controlador;

class Main {
    public static void main(String[] args) {
        RegistroVehiculos registro = new RegistroVehiculos();

        registro.registrarVehiculo(new Automovil(
                "AUT-101", "Toyota", "Corolla", 250, true, 0, 5, TipoTransmision.AUTOMATICO));
        registro.registrarVehiculo(new Automovil(
                "AUT-102", "Honda", "Civic", 225, true, 0, 5, TipoTransmision.MANUAL));
        registro.registrarVehiculo(new Motocicleta(
                "MOT-201", "Honda", "CB190R", 125, true, 0, 184));
        registro.registrarVehiculo(new Motocicleta(
                "MOT-202", "Kawasaki", "Ninja 400", 200, true, 0, 399));
        registro.registrarVehiculo(new Camioneta(
                "CAM-301", "Toyota", "Hilux", 200, true, 0, 1.5f));
        registro.registrarVehiculo(new Camioneta(
                "CAM-302", "Ford", "Ranger", 275, true, 0, 2.0f));

        Vista vista = new Vista();
        Controlador controlador = new Controlador(registro, vista);
        controlador.iniciar();
    }
}
