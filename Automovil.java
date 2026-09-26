enum tipoTransmisión{
    AUTOMATICO,
    MANUAL
}
public class Automovil extends Vehiculos {
    private int cantPasajeros;
    private tipoTransmisión transmisión;

    public Automovil(String placa, String marca, String modelo, float tarifaDiaria, boolean disponibilidad, int diasAlquilados, int cantPasajeros, tipoTransmisión transmisión){
        
        super(placa, marca, modelo, tarifaDiaria, disponibilidad, diasAlquilados);
        this.cantPasajeros = cantPasajeros;
        this.transmisión = transmisión;
    }
    
    public float calcularTarifaFinal(int diasAlquiladosCotiz){
        if (diasAlquiladosCotiz<=0 ){
            throw new IllegalArgumentException(
            "La cantidad de días debe ser mayor que cero."
        );
        } 
        float total = super.calcularTarifaParcial(diasAlquiladosCotiz);
        
        if (transmisión == tipoTransmisión.AUTOMATICO){
            total += (50*diasAlquiladosCotiz);
        }
        return total;
    }
    
}
