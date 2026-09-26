package model;
import java.util.ArrayList;
import java.util.List;

public class RegistroVehiculos {

    private List<Automovil> registroAuto;
    private List<Motocicleta> registroMoto;
    private List<Camioneta> registroCamioneta;
    private List<Float> registroIngresos;

    public RegistroVehiculos() {
        registroAuto = new ArrayList<>();
        registroMoto = new ArrayList<>();
        registroCamioneta = new ArrayList<>();
        registroIngresos = new ArrayList<>();
    }

    public boolean registrarVehiculo(Vehiculos vehiculo) {
        if (vehiculo == null || buscarVehiculo(vehiculo.getPlaca()) != null) {
            return false;
        }

        if (vehiculo instanceof Automovil) {
            registroAuto.add((Automovil) vehiculo);
        } else if (vehiculo instanceof Motocicleta) {
            registroMoto.add((Motocicleta) vehiculo);
        } else if (vehiculo instanceof Camioneta) {
            registroCamioneta.add((Camioneta) vehiculo);
        } else {
            return false;
        }
        return true;
    }

    public Vehiculos buscarVehiculo(String placa) {
        if (placa == null) {
            return null;
        }
        for (Vehiculos vehiculo : obtenerTodos()) {
            if (vehiculo.getPlaca().equalsIgnoreCase(placa.trim())) {
                return vehiculo;
            }
        }
        return null;
    }

    public List<Vehiculos> obtenerTodos() {
        List<Vehiculos> todos = new ArrayList<>();
        todos.addAll(registroAuto);
        todos.addAll(registroMoto);
        todos.addAll(registroCamioneta);
        return todos;
    }

    public void registrarIngreso(float ingreso) {
        if (ingreso > 0) {
            registroIngresos.add(ingreso);
        }
    }

    public int cantidadRegistros(){
        return registroAuto.size() + registroMoto.size() + registroCamioneta.size();
    }

    public int cantidadAutomoviles() {
        return registroAuto.size();
    }

    public int cantidadMotocicletas() {
        return registroMoto.size();
    }

    public int cantidadCamionetas() {
        return registroCamioneta.size();
    }

    public int cantidadDisponibles(List<? extends Vehiculos> vehiculos) {
        int disponibles = 0;
        for (Vehiculos vehiculo : vehiculos) {
            if (vehiculo.isDisponibilidad()) {
                disponibles++;
            }
        }
        return disponibles;
    }

    public int automovilesDisponibles() {
        return cantidadDisponibles(registroAuto);
    }

    public int motocicletasDisponibles() {
        return cantidadDisponibles(registroMoto);
    }

    public int camionetasDisponibles() {
        return cantidadDisponibles(registroCamioneta);
    }

    public float totalIngresos(){
        float total = 0;
        for (float ingreso : registroIngresos) {
            total += ingreso;
        }
        return total;
    }
}
