package  evaluacion2_ejerciciopractico.Vehiculo;

public class Auto extends Vehiculo {
    private boolean tieneRadio;
    private boolean tieneNavegador;

    public Auto(boolean tieneNavegador, boolean tieneRadio, String placa, String marca, double precio, int cilindraje, String matricula, double impuestoCirculacion, double cuotaMesGaraje, String tipo) {
        super(placa, marca, precio, cilindraje, matricula, impuestoCirculacion, cuotaMesGaraje, tipo);
        this.tieneNavegador = tieneNavegador;
        this.tieneRadio = tieneRadio;
    }


    public boolean isTieneRadio() {
        return tieneRadio;
    }

    public void setTieneRadio(boolean tieneRadio) {
        this.tieneRadio = tieneRadio;
        ajustarImpuestoYCuota();
    }

    public boolean isTieneNavegador() {
        return tieneNavegador;
    }

    public void setTieneNavegador(boolean tieneNavegador) {
        this.tieneNavegador = tieneNavegador;
        ajustarImpuestoYCuota();
    }
    private void ajustarImpuestoYCuota() {
        // Calcula el impuesto base
        calcularImpuestoCirculacion();

        // Aumenta el impuesto si tiene radio y/o navegador
        if (tieneRadio) {
            this.impuestoCirculacion += this.precio * 0.01;
        }
        if (tieneNavegador) {
            this.impuestoCirculacion += this.precio * 0.02;
        }

        // Aumenta la cuota mensual si el cilindraje es mayor a 2499
        if (this.cilindraje > 2499) {
            this.cuotaMesGaraje += this.cuotaMesGaraje * 0.20;
        }
    }
    
}
