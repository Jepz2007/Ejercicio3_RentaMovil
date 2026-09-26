public class Vehiculos{

    private String placa; 
    private String marca;
    private String modelo;
    private float tarifaDiaria;
    private boolean disponibilidad;
    private int diasAlquilados;

    public Vehiculos(String placa, String marca, String modelo, float tarifaDiaria, boolean disponibilidad, int diasAlquilados) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.tarifaDiaria = tarifaDiaria;
        this.disponibilidad = disponibilidad;
        this.diasAlquilados = diasAlquilados;
    }

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

    public String getPlaca() {
    return placa;
    }

    public float calcularTarifaParcial(int diasAlquiladosCotiz){
        return tarifaDiaria * diasAlquiladosCotiz;
    }

    public void devolverVehiculo(){
        diasAlquilados=0;
        disponibilidad = true;
    }

    public void getInfo() {
        System.out.println("Placa: " + placa);
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Tarifa diaria: Q" + tarifaDiaria);
        System.out.println("Disponible: " + disponibilidad);
    }

}