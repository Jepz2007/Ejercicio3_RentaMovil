package model;

public abstract class Vehiculos {

    private String placa; 
    private String marca;
    private String modelo;
    private float tarifaDiaria;
    private boolean disponibilidad;
    private int diasAlquilados;

    public Vehiculos(String placa, String marca, String modelo, float tarifaDiaria, boolean disponibilidad, int diasAlquilados) {
        if (placa == null || placa.trim().isEmpty()) {
            throw new IllegalArgumentException("La placa no puede estar vacía.");
        }
        if (marca == null || marca.trim().isEmpty()) {
            throw new IllegalArgumentException("La marca no puede estar vacía.");
        }
        if (modelo == null || modelo.trim().isEmpty()) {
            throw new IllegalArgumentException("El modelo no puede estar vacío.");
        }
        if (tarifaDiaria <= 0) {
            throw new IllegalArgumentException("La tarifa diaria debe ser mayor que cero.");
        }
        if (diasAlquilados < 0) {
            throw new IllegalArgumentException("Los días alquilados no pueden ser negativos.");
        }
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
        if (diasAlquilados < 0) {
            throw new IllegalArgumentException("Los días alquilados no pueden ser negativos.");
        }
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

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public float getTarifaDiaria() {
        return tarifaDiaria;
    }

    public float calcularTarifaParcial(int diasAlquiladosCotiz){
        if (diasAlquiladosCotiz <= 0) {
            throw new IllegalArgumentException("La cantidad de días debe ser mayor que cero.");
        }
        return tarifaDiaria * diasAlquiladosCotiz;
    }

    public abstract float calcularTarifaFinal(int diasAlquiladosCotiz);

    public void devolverVehiculo(){
        diasAlquilados=0;
        disponibilidad = true;
    }

    public void getInfo() {
        System.out.println("Placa: " + placa);
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.printf("Tarifa diaria: Q%.2f%n", tarifaDiaria);
        System.out.println("Estado: " + (disponibilidad ? "Disponible" : "Alquilado"));
        System.out.println("Días alquilados: " + diasAlquilados);
    }

}
