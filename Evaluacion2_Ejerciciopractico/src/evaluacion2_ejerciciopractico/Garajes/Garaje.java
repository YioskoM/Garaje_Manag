package evaluacion2_ejerciciopractico.Garajes;

import evaluacion2_ejerciciopractico.Vehiculo.Auto;
import evaluacion2_ejerciciopractico.Vehiculo.Camion;
import evaluacion2_ejerciciopractico.Vehiculo.Camioneta;
import evaluacion2_ejerciciopractico.Vehiculo.Moto;
import evaluacion2_ejerciciopractico.Vehiculo.Vehiculo;
import java.util.ArrayList;

public class Garaje implements iGarage {
    public ArrayList<Vehiculo> espacios;

    private String departamento;
    private String ciudad;
    private String direccion;
    private String numero;
    private String email;
    private String nameAdmin;
    private int numEspacios;

    // ! crear constructores COMMIT OPEN#2
    public Garaje(String departamento, String ciudad,
            String direccion, String numero, String email, String nameAdmin, int numEspacios) {
        this.departamento = departamento;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.numero = numero;
        this.email = email;
        this.nameAdmin = nameAdmin;
        this.numEspacios = numEspacios;

        this.espacios = new ArrayList<>();

    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNameAdmin() {
        return nameAdmin;
    }

    public void setNameAdmin(String nameAdmin) {
        this.nameAdmin = nameAdmin;
    }

    public int getNumEspacios() {
        return numEspacios;
    }

    public void setNumEspacios(int numEspacios) {
        this.numEspacios = numEspacios;
    }

    // ! Metodo que enseña las caracteristicas del garaje

    public void mostrarCaracteristicas(int i) {
        System.out.println("GARAJE " + i);
        System.out.println("Departamento: " + departamento);
        System.out.println("Ciudad: " + ciudad);
        System.out.println("Direccion: " + direccion);
        System.out.println("Numero telefonico: " + numero);
        System.out.println("Email: " + email);
        System.out.println("Nombre administrador: " + nameAdmin);
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
        if (espacios.size() < numEspacios) {
            espacios.add(vehiculo); // Agregar el vehículo al garaje
            return true;
        }

        // Verifica que no haya más del 80% de motos
        int numMotos = calcularOcupacionPorTipoVehiculo(Moto.class);
        if (vehiculo instanceof Moto && ((double) (numMotos + 1) / numEspacios) > 0.20) {
            System.out.println("No se puede alquilar más motos. Se supera el 20% de ocupación por motos.");
            return false;
        }
        // Verifica que no haya más del 10% de camion
        int numCamion = calcularOcupacionPorTipoVehiculo(Camion.class);
        if (vehiculo instanceof Camion && ((double) (numCamion + 1) / numEspacios) > 0.10) {
            System.out.println("No se puede alquilar más camion. Se supera el 10% de ocupación por camion.");
            return false;
        }
        // Verifica que no haya más del 20% de camioneta
        int numCamioenta = calcularOcupacionPorTipoVehiculo(Camioneta.class);
        if (vehiculo instanceof Camioneta && ((double) (numCamioenta + 1) / numEspacios) > 0.20) {
            System.out.println("No se puede alquilar más camionetas. Se supera el 20% de ocupación por camioneta.");
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
                System.out.println(
                        "Vehículo con matrícula " + placa + "la marca " + vehiculo.marca + " retirado del garaje.");
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

    public void mostrarProporcionAutosMotosCamionCamioneta() {
        int numAutos = calcularOcupacionPorTipoVehiculo(Auto.class);
        int numMotos = calcularOcupacionPorTipoVehiculo(Moto.class);
        int numCamion = calcularOcupacionPorTipoVehiculo(Camion.class);
        int numCamioenta = calcularOcupacionPorTipoVehiculo(Camioneta.class);
        System.out.println("Número de Autos: " + numAutos);
        System.out.println("Número de Motos: " + numMotos);
        System.out.println("Número de Camiones: " + numCamion);
        System.out.println("Número de Camionetas: " + numCamioenta);
    }

    public int plazasDisponibles() {
        return numEspacios - espacios.size(); // Espacios totales menos los ocupados
    }

    public int buscarVehiculo(String placa) {
        for (int i = 0; i < espacios.size(); i++) {
            Vehiculo vehiculo = espacios.get(i);
            if (vehiculo.getPlaca() != null && vehiculo.getPlaca().equals(placa)) {
                return i; // Retorna la posición si lo encuentra
            }
        }
        return -1; // Retorna -1 si no lo encuentra
    }

    public void listarCamionetasPorTipo() {
        int suv = 0, pickup = 0, carga = 0, otro = 0;

        for (Vehiculo vehiculo : espacios) {
            if (vehiculo instanceof Camioneta) {
                Camioneta camioneta = (Camioneta) vehiculo;
                switch (camioneta.getTipoServicio().toLowerCase()) {
                    case "suv":
                        suv++;
                        break;
                    case "pickup":
                        pickup++;
                        break;
                    case "carga":
                        carga++;
                        break;
                    case "otro":
                        otro++;
                        break;
                }
            }
        }

        System.out.println("Camionetas por tipo:");
        System.out.println("SUV: " + suv);
        System.out.println("Pickup: " + pickup);
        System.out.println("Carga: " + carga);
        System.out.println("Otro: " + otro);
    }

    public boolean puedeAgregarCamion() {
        int limiteCamiones = this.numEspacios > 100 ? 20 : 10;
        int camionesActuales = calcularOcupacionPorTipoVehiculo(Camion.class);

        return camionesActuales >= limiteCamiones;
    }

    // Para un garaje específico
    public  void mostrarOcupacionGaraje() {
        int espaciosOcupados = espacios.size();
        int espaciosTotales = getNumEspacios();
        double porcentajeOcupacion = (espaciosOcupados * 100.0) / espaciosTotales;

        System.out.println(" Informe de Ocupación del Garaje ");
        System.out.println("Ubicación: " + getCiudad() + ", " + getDireccion());
        System.out.println("Espacios ocupados: " + espaciosOcupados);
        System.out.println("Espacios totales: " + espaciosTotales);
        System.out.println("Porcentaje de ocupación: " + String.format("%.2f%%", porcentajeOcupacion));
    }


    // informe por tipo de vehiculo 
    
        public void mostrarOcupacionPorTipo() {
            System.out.println(" Ocupación por Tipo de Vehículo ");
            System.out.println("Garaje: " + getCiudad() + ", " + getDireccion());

            int autos = calcularOcupacionPorTipoVehiculo(Auto.class);
            int motos = calcularOcupacionPorTipoVehiculo(Moto.class);
            int camiones = calcularOcupacionPorTipoVehiculo(Camion.class);
            int camionetas = calcularOcupacionPorTipoVehiculo(Camioneta.class);

            System.out.println("Autos: " + autos + " (" +
                    String.format("%.1f%%", (autos * 100.0) / getNumEspacios()) + ")");
            System.out.println("Motos: " + motos + " (" +
                    String.format("%.1f%%", (motos * 100.0) / getNumEspacios()) + ")");
            System.out.println("Camiones: " + camiones + " (" +
                    String.format("%.1f%%", (camiones * 100.0) / getNumEspacios()) + ")");
            System.out.println("Camionetas: " + camionetas + " (" +
                    String.format("%.1f%%", (camionetas * 100.0) / getNumEspacios()) + ")");
        }
    
     
    

}