
import java.util.ArrayList;


public class Garaje implements iGarage {
    public static final int NUMERO_ESPACIOS = 50; 
    public ArrayList<Vehiculo> espacios;

    public Garaje() {
        espacios = new ArrayList<>();
    }

   
    @Override
    public double calcularIngresos() {
        double ingresos = 0;
        for (Vehiculo v : espacios) {
            ingresos += v.getcuotaMesGaraje();
        }
        return ingresos;
    }

    @Override
    public int calcularOcupacionPorTipoVehiculo(Class<?> tipoVehiculo) {
        int contador = 0;
        for (Vehiculo v : espacios) {
            if (v.getClass() == tipoVehiculo) {
                contador++;
            }
        }
        return contador;
    }

    
    public boolean alquilarEspacio(Vehiculo vehiculo) {
        if (espacios.size() >= NUMERO_ESPACIOS) {
            System.out.println("No hay espacios disponibles.");
            return false;
        }
        // Verifica que no haya más del 80% de motos
        int numMotos = calcularOcupacionPorTipoVehiculo(Moto.class);
        if (vehiculo instanceof Moto && ((double)(numMotos + 1) / NUMERO_ESPACIOS) > 0.8) {
            System.out.println("No se puede alquilar más motos. Se supera el 80% de ocupación por motos.");
            return false;
        }
        // Verifica que no haya más del 10% de camion
        int numCamion = calcularOcupacionPorTipoVehiculo(Camion.class); //! llamar el arraylist
        if (vehiculo instanceof Camion && ((double)(numCamion + 1) / NUMERO_ESPACIOS) > 0.10) {
            System.out.println("No se puede alquilar más motos. Se supera el 10% de ocupación por camion.");
            return false;
        }
        // Verifica que el vehículo tenga matrícula
        if (vehiculo.getPlaca() == null) {
            System.out.println("No se puede alquilar un vehículo sin matrícula.");
            return false;
        }
        // Alquila el espacio
        espacios.add(vehiculo);
        System.out.println("Vehículo alquilado exitosamente.");
        return true;
    }

    public boolean retirarVehiculo(String placa) {
        for (Vehiculo v : espacios) {
            if (v.getPlaca().equals(placa)) {
                espacios.remove(v);
                System.out.println("Vehículo retirado exitosamente.");
                return true;
            }
        }
        System.out.println("Vehículo no encontrado.");
        return false;
    }

    public void listarVehiculos() {
        for (Vehiculo v : espacios) {
            System.out.println("Matrícula: " + v.getPlaca() + ", Cuota Mensual: " + v.getcuotaMesGaraje() + ", Tipo: " + v.getClass().getSimpleName());
        }
    }

    public void mostrarProporcionAutosMotosCamion() {
        int numAutos = calcularOcupacionPorTipoVehiculo(Auto.class);
        int numMotos = calcularOcupacionPorTipoVehiculo(Moto.class);
        int numCamion = calcularOcupacionPorTipoVehiculo(Camion.class);
        System.out.println("Número de Autos: " + numAutos);
        System.out.println("Número de Motos: " + numMotos);
        System.out.println("Número de Motos: " + numCamion);
    }
}

   