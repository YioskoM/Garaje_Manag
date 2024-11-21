package evaluacion2_ejerciciopractico;

public class Auto extends Vehiculo {
    private boolean tieneRadio;
    private boolean tieneNavegador;
    
    public Auto(String marca, double precio, int cilindraje, boolean tieneRadio, boolean tieneNavegador) {
        super(marca, precio, cilindraje);
        this.tieneRadio = tieneRadio;
        this.tieneNavegador = tieneNavegador;
        ajustarImpuestoYCuota();
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
