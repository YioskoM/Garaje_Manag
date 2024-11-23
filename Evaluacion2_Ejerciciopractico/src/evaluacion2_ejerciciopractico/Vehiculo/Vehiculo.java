/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package evaluacion2_ejerciciopractico.Vehiculo;

/**
 *
 * @author Karen
 */
public class Vehiculo {
   public String placa ;
   public String marca ;
   public double precio;
   public int cilindraje;
   public String matricula;
   public double impuestoCirculacion;
   public double cuotaMesGaraje;
   
    // Constante de clase para la cuota mensual por defecto
    public static final double CUOTA_GARAJE_POR_DEFECTO = 100;
   
    //construtor 
    public Vehiculo(String placa, String marca, double precio, int cilindraje, String matricula,
            double impuestoCirculacion, double cuotaMesGaraje) {
        this.placa = placa;
        this.marca = marca;
        this.precio = precio;
        this.cilindraje = cilindraje;
        this.matricula = matricula;
        this.impuestoCirculacion = impuestoCirculacion;
        this.cuotaMesGaraje = CUOTA_GARAJE_POR_DEFECTO;
        calcularImpuestoCirculacion(); // Calcula el impuesto de circulación
    }
   

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getImpuestoCirculacion() {
        return impuestoCirculacion;
    }

    public void setImpuestoCirculacion(double impuestoCirculacion) {
        this.impuestoCirculacion = impuestoCirculacion;
    }
    
    public double getcuotaMesGaraje() {
        return cuotaMesGaraje;
    }
   
    public void setcuotaMesGaraje(double cuotaMesGaraje){
        if (cuotaMesGaraje>0) {
            this.cuotaMesGaraje = cuotaMesGaraje;
        }
        else {
            System.out.println("No se pueden ingresar valores negativos");
        }
    }
    
    public void calcularImpuestoCirculacion(){
        this.impuestoCirculacion = this.precio*0.02;
    }
    public boolean matricular(String matricula) {
        if (matricula.length() == 6) {
            this.matricula = matricula;
            return true;
        } else {
            System.out.println("La matrícula debe tener exactamente 6 caracteres.");
            return false;
        }
    }
}


