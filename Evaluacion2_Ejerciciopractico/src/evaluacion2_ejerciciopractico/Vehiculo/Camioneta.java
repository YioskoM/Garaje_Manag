package evaluacion2_ejerciciopractico.Vehiculo;

public class Camioneta extends Vehiculo {
    private String tipoServicio; // "SUV", "Pickup", "Carga", "Otro"
    private int numeroPasajeros;
    private boolean tieneRemolque;

    // Constructor
    public Camioneta(String placa, String marca, double precio, int cilindraje, String matricula,
            double impuestoCirculacion, double cuotaMesGaraje, String tipoServicio, int numeroPasajeros,
            boolean tieneRemolque) {
        super(placa, marca, precio, cilindraje, matricula, impuestoCirculacion, cuotaMesGaraje);
        this.tipoServicio = tipoServicio;
        this.numeroPasajeros = numeroPasajeros;
        this.tieneRemolque = tieneRemolque;

        validarNumeroPasajeros(); // Validar número de pasajeros según tipo de servicio
        calcularImpuestoCirculacion(); // Impuesto específico
        ajustarCuotaMensual(); // Ajustar cuota mensual específica
    }

    private void validarNumeroPasajeros() {
        if (tipoServicio.equals("Pickup") || tipoServicio.equals("Carga")) {
            if (numeroPasajeros > 2) {
                throw new IllegalArgumentException(
                        "El número de pasajeros para 'Pickup' o 'Carga' no puede ser mayor a 2.");
            }
        } else if (numeroPasajeros > 5) {
            throw new IllegalArgumentException("El número de pasajeros no puede exceder 5.");
        }
    }

    @Override
    public void calcularImpuestoCirculacion() {
        setImpuestoCirculacion(getPrecio() * 0.05); // 5% del precio
    }

    private void ajustarCuotaMensual() {
        double cuota = getcuotaMesGaraje();

        // Incremento por tipo de servicio
        switch (tipoServicio) {
            case "Pickup":
            case "Carga":
            case "Otro":
                cuota *= 1.45; // Incremento del 45%
                break;
            case "SUV":
                cuota *= 1.10; // Incremento del 10%
                break;
        }

        // Incremento por número de pasajeros
        if (numeroPasajeros > 2) {
            cuota *= 1.60; // Incremento del 60%
        } else {
            cuota *= 1.50; // Incremento del 50%
        }

        // Incremento por remolque
        if (tieneRemolque) {
            cuota *= 1.10; // Incremento del 10%
        }

        setcuotaMesGaraje(cuota);
    }

    // Getters
    public String getTipoServicio() {
        return tipoServicio;
    }

    public int getNumeroPasajeros() {
        return numeroPasajeros;
    }

    public boolean isTieneRemolque() {
        return tieneRemolque;
    }
}
