public class Vehiculos{

    private String placa; 
    private String marca;
    private String modelo;
    private float tarifaDiaria;
    private boolean disponibilidad;
    private int diasAlquilados;

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public void setDiasAlquilados(int diasAlquilados) {
        this.diasAlquilados = diasAlquilados;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }
    
    public int getDiasAlquilados() {
        return diasAlquilados;
    }

    public float calcularTarifaParcial(){
        float tarifaParcial = tarifaDiaria*diasAlquilados;
        return tarifaParcial;
    }

    public void devolverVehiculo(){
        diasAlquilados=0;
        disponibilidad = true;
    }

    



}