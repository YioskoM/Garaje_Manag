/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package evaluacion2_ejerciciopractico.Vehiculo;

/**
 *
 * @author Karen
 */

 public class Moto extends Vehiculo {
    private boolean tieneSidecar;

    public Moto(String placa, String marca, double precio, int cilindraje, String matricula, double impuestoCirculacion,
            double cuotaMesGaraje, boolean tieneSidecar) {
        super(placa, marca, precio, cilindraje, matricula, impuestoCirculacion, cuotaMesGaraje);
        this.tieneSidecar = tieneSidecar;
        ajustarImpuestoYCuota();
    }

    public boolean isTieneSidecar() {
        return tieneSidecar;
    }

    public void setTieneSidecar(boolean tieneSidecar) {
        this.tieneSidecar = tieneSidecar;
        ajustarImpuestoYCuota();
    }

    private void ajustarImpuestoYCuota() {
        // Calcula el impuesto base
        calcularImpuestoCirculacion();
        if (tieneSidecar) {
            // Aumenta el impuesto en un 10%
            this.impuestoCirculacion += this.impuestoCirculacion * 0.10;
            // Aumenta la cuota mensual en un 50%
            this.cuotaMesGaraje += this.cuotaMesGaraje * 0.50;
        }
    }
}