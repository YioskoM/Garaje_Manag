package evaluacion2_ejerciciopractico.Vehiculo;

public class Camion extends Vehiculo {
    private int numeroEjes;
    private String tipoCamion; // "sencillo" o "doble"
    private double capacidadCarga; // En toneladas

    // Constructor
    public Camion(String placa, String marca, double precio, int cilindraje, String matricula,
    double impuestoCirculacion, double cuotaMesGaraje, int numeroEjes, String tipoCamion,
    double capacidadCarga) {
    super(placa, marca, precio, cilindraje, matricula, impuestoCirculacion, cuotaMesGaraje);
    this.numeroEjes = numeroEjes;
    this.tipoCamion = tipoCamion.toLowerCase();
    this.capacidadCarga = capacidadCarga;

    if(this.tipoCamion.equals("sencillo"))

    {
        if (numeroEjes != 2) {
            System.out.println("Un camión sencillo debe tener exactamente 2 ejes. Se establecerá a 2 ejes.");
            this.numeroEjes = 2;
        } else {
            this.numeroEjes = numeroEjes;
        }
    }else if(this.tipoCamion.equals("doble"))
    {
        if (numeroEjes >= 3 && numeroEjes <= 6) {
            this.numeroEjes = numeroEjes;
        } else {
            System.out.println("Un camión doble debe tener entre 3 y 6 ejes. Se establecerá a 3 ejes por defecto.");
            this.numeroEjes = 3;
        }
    }else
    {
        System.out.println(
                "Tipo de camión no válido. Debe ser 'sencillo' o 'doble'. Lo tomare como 'sencillo' con 2 ejes.");
        this.tipoCamion = "sencillo";
        this.numeroEjes = 2;
    }

    // Calculamos el impuesto de circulación
    calcularImpuestoCirculacion();

    // Ajustamos la cuota mensual del garaje
    ajustarCuotaGaraje();

    }

    @Override
    public void calcularImpuestoCirculacion() {
    // 9% del precio
    double impuestoBase = getPrecio() * 0.09;

    // Calcular incremento por capacidad de carga
    int incrementos = (int)(capacidadCarga / 5); // Cada 5 toneladas
    double incremento = impuestoBase * 0.10 * incrementos; // 10% por cada 5 toneladas

    double impuestoTotal = impuestoBase + incremento;
    setImpuestoCirculacion(impuestoTotal);
    }

    public void ajustarCuotaGaraje() {
        double cuotaBase = getcuotaMesGaraje();
        if (tipoCamion.equals("sencillo")) {
            cuotaBase += cuotaBase * 0.75; // Aumenta 75%
        } else if (tipoCamion.equals("doble")) {
            cuotaBase += cuotaBase * 1.25; // Aumenta 125%
        }
        setcuotaMesGaraje(cuotaBase);
    }

    // Geterr and setter
    public int getNumeroEjes() {
        return numeroEjes;
    }

    public void setNumeroEjes(int numeroEjes) {
        this.numeroEjes = numeroEjes;
    }

    public String getTipoCamion() {
        return tipoCamion;
    }

    public void setTipoCamion(String tipoCamion) {
        this.tipoCamion = tipoCamion.toLowerCase();
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    public void setImpuestoCirculacion(double impuestoCirculacion) {
        this.impuestoCirculacion = impuestoCirculacion;
    }
}