package model;
public class Motocicleta extends Vehiculos {
    private int cilindraje;

    public Motocicleta(String placa, String marca, String modelo, float tarifaDiaria, boolean disponibilidad, int diasAlquilados, int cilindraje){
        super(placa, marca, modelo, tarifaDiaria, disponibilidad, diasAlquilados);
        if (cilindraje <= 0) {
            throw new IllegalArgumentException("El cilindraje debe ser mayor que cero.");
        }
        this.cilindraje = cilindraje;
    }

    public float calcularTarifaFinal(int diasAlquiladosCotiz){
        float total = super.calcularTarifaParcial(diasAlquiladosCotiz);
        if (cilindraje > 250) {
            total += 75;
        }
        return total;
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Cilindraje: " + cilindraje + " cc");
    }
}
