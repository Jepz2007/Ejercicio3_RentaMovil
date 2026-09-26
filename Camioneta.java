public class Camioneta extends Vehiculos{
    
    private float capacidadMax;


    public Camioneta(String placa, String marca, String modelo, float tarifaDiaria, boolean disponibilidad, int diasAlquilados, int capacidadMax){
        
        super(placa, marca, modelo, tarifaDiaria, disponibilidad, diasAlquilados);
        this.capacidadMax = capacidadMax;
    }
    
    public float calcularTarifaFinal(int diasAlquiladosCotiz){
        if (diasAlquiladosCotiz<=0 ){
            throw new IllegalArgumentException(
            "La cantidad de días debe ser mayor que cero."
        );
        } 
        float parcial = super.calcularTarifaParcial(diasAlquiladosCotiz);
        float recargo = diasAlquiladosCotiz * capacidadMax * 100;
        
        return parcial + recargo;
    }
}