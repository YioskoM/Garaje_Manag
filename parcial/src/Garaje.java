package evaluacion2_ejerciciopractico;

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
        if (espacios.size() < NUMERO_ESPACIOS) {
            espacios.add(vehiculo); // Agregar el vehículo al garaje
            return true;
        }

        // Verifica que no haya más del 80% de motos
        int numMotos = calcularOcupacionPorTipoVehiculo(Moto.class);
        if (vehiculo instanceof Moto && ((double) (numMotos + 1) / NUMERO_ESPACIOS) > 0.8) {
            System.out.println("No se puede alquilar más motos. Se supera el 80% de ocupación por motos.");
            return false;
        }
        // Verifica que no haya más del 10% de camion
        int numCamion = calcularOcupacionPorTipoVehiculo(Camion.class);
        if (vehiculo instanceof Camion && ((double) (numCamion + 1) / NUMERO_ESPACIOS) > 0.10) {
            System.out.println("No se puede alquilar más motos. Se supera el 10% de ocupación por camion.");
            return false;
        }
        // Verifica que el vehículo tenga matrícula
        if (vehiculo.getPlaca() == null) {
            System.out.println("No se puede alquilar un vehículo sin matrícula.");
            return false;
        }
        System.out.println("Vehículo alquilado exitosamente.");
        return false; // No hay espacio disponible

    }

    public boolean retirarVehiculo(String placa) {
        for (int i = 0; i < espacios.size(); i++) {
            Vehiculo vehiculo = espacios.get(i);
            // Verificar si la matrícula del vehículo es nula antes de compararla
            if (vehiculo.getPlaca() != null && vehiculo.getPlaca().equals(placa)) {
                espacios.remove(i);
                System.out.println("Vehículo con matrícula " + placa + " retirado del garaje.");
                return true;
            }
        }
        System.out.println("No se encontró un vehículo con la matrícula: " + placa);
        return false;
    }

    public void listarVehiculos() {
        for (Vehiculo v : espacios) {
            System.out.println("Matrícula: " + v.getPlaca() + ", Cuota Mensual: " + v.getcuotaMesGaraje() + ", Tipo: "
                    + v.getClass().getSimpleName());
        }
    }

    public void mostrarProporcionAutosMotosCamion() {
        int numAutos = calcularOcupacionPorTipoVehiculo(Auto.class);
        int numMotos = calcularOcupacionPorTipoVehiculo(Moto.class);
        int numCamion = calcularOcupacionPorTipoVehiculo(Camion.class);
        System.out.println("Número de Autos: " + numAutos);
        System.out.println("Número de Motos: " + numMotos);
        System.out.println("Número de Camiones: " + numCamion);
    }
}
