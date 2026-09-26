package model;

public class Automovil extends Vehiculos {
    private int cantPasajeros;
    private TipoTransmision transmision;

    public Automovil(String placa, String marca, String modelo, float tarifaDiaria, boolean disponibilidad, int diasAlquilados, int cantPasajeros, TipoTransmision transmision){
        super(placa, marca, modelo, tarifaDiaria, disponibilidad, diasAlquilados);
        if (cantPasajeros <= 0) {
            throw new IllegalArgumentException("La cantidad de pasajeros debe ser mayor que cero.");
        }
        if (transmision == null) {
            throw new IllegalArgumentException("El tipo de transmisión es obligatorio.");
        }
        this.cantPasajeros = cantPasajeros;
        this.transmision = transmision;
    }
    
    public float calcularTarifaFinal(int diasAlquiladosCotiz){
        if (diasAlquiladosCotiz<=0 ){
            throw new IllegalArgumentException(
            "La cantidad de días debe ser mayor que cero."
        );
        } 
        float total = super.calcularTarifaParcial(diasAlquiladosCotiz);
        
        if (transmision == TipoTransmision.AUTOMATICO){
            total += (50*diasAlquiladosCotiz);
        }
        return total;
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Cantidad de pasajeros: " + cantPasajeros);
        System.out.println("Transmisión: " + transmision);
    }
}
