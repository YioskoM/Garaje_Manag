package evaluacion2_ejerciciopractico;

import java.util.Scanner;


public class GestionGaraje {
    public static void main(String[] args) {
        Garaje garaje = new Garaje();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú de Gestión del Garaje ---");
            System.out.println("1. Alquilar un espacio");
            System.out.println("2. Retirar vehículo");
            System.out.println("3. Consulta de ingresos mensuales");
            System.out.println("4. Consulta proporción autos / motos / camion / camioneta");
            System.out.println("5. Listado de matrículas y cuota mensual y tipo vehículo");
            System.out.println("6. Cantidad de plazas disponibles");
            System.out.println("7. Buscar vehiculo");
            System.out.println("8. Listado de camionetas por tipo");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el tipo de vehículo (auto/moto/camion/camioneta): ");
                    String tipo = scanner.nextLine().toLowerCase();
                    System.out.print("Ingrese la marca: ");
                    String marca = scanner.nextLine();
                    System.out.print("Ingrese el precio: ");
                    double precio = scanner.nextDouble();
                    System.out.print("Ingrese el cilindraje: ");
                    int cilindraje = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese la matrícula (6 caracteres): ");
                    String placa = scanner.nextLine().trim(); // Elimina espacios adicionales
                    System.out.println("Matrícula ingresada: " + placa);

                    Vehiculo vehiculo = null;

                    if (tipo.equals("camion")) {
                        System.out.print("Ingrese el tipo de camión (sencillo/doble): ");
                        String tipoCamion = scanner.nextLine();
                        System.out.print("Ingrese el número de ejes: ");
                        int numeroEjes = scanner.nextInt();
                        System.out.print("Ingrese la capacidad de carga en toneladas: ");
                        double capacidadCarga = scanner.nextDouble();
                        scanner.nextLine();
                        vehiculo = new Camion(placa, marca, precio, cilindraje, placa, opcion, cilindraje, numeroEjes, tipoCamion, capacidadCarga);
                    } else if (tipo.equals("moto")) {
                        System.out.print("¿Tiene sidecar? (true/false): ");
                        boolean tieneSidecar = scanner.nextBoolean();
                        scanner.nextLine();
                        vehiculo = new Moto(placa, marca, precio, cilindraje, placa, opcion, cilindraje, tieneSidecar);
                    } else if (tipo.equals("auto")) {
                        System.out.print("¿Tiene radio? (true/false): ");
                        boolean tieneRadio = scanner.nextBoolean();
                        System.out.print("¿Tiene navegador? (true/false): ");
                        boolean tieneNavegador = scanner.nextBoolean();
                        scanner.nextLine();
                        vehiculo = new Auto(placa, marca, precio, cilindraje, placa, opcion, cilindraje, tieneRadio, tieneNavegador);
                    } else if (tipo.equals("camioneta")) {
                        System.out.print("Ingrese el tipo de servicio (SUV/Pickup/Carga/Otro): ");
                        String tipoServicio = scanner.nextLine();
                        System.out.print("Ingrese el número de pasajeros: ");
                        int numeroPasajeros = scanner.nextInt();
                        System.out.print("¿Tiene remolque? (true/false): ");
                        boolean tieneRemolque = scanner.nextBoolean();
                        scanner.nextLine();
                        vehiculo = new Camioneta(placa, marca, precio, cilindraje, placa, opcion, cilindraje, tipoServicio, numeroPasajeros, tieneRemolque);
                    } else {
                        System.out.println("Tipo de vehículo no reconocido.");
                        break;
                    }

                    if (vehiculo != null) {
                        if (!vehiculo.matricular(placa)) {
                            System.out.println("Matrícula inválida. Debe tener 6 caracteres.");
                            break;
                        }
                        if (garaje.alquilarEspacio(vehiculo)) { // Llama al método después de inicializar
                            System.out.println("Vehículo registrado exitosamente.");
                        } else {
                            System.out.println("No hay espacio disponible en el garaje.");
                        }
                    }
                    break;

                // case hecho en parcial
                /*
                 * case 1:
                 * System.out.print("Ingrese el tipo de vehículo (auto/moto/camion): ");
                 * String tipo = scanner.nextLine().toLowerCase();
                 * if (tipo.equals("camion")) {
                 * System.out.print("Ingrese el tipo de camión (sencillo/doble): ");
                 * String tipoCamion = scanner.nextLine();
                 * System.out.print("Ingrese el número de ejes: ");
                 * int numeroEjes = scanner.nextInt();
                 * System.out.print("Ingrese la capacidad de carga en toneladas: ");
                 * double capacidadCarga = scanner.nextDouble();
                 * scanner.nextLine();
                 * System.out.print("Ingrese la marca: ");
                 * String marca = scanner.nextLine();
                 * System.out.print("Ingrese el precio: ");
                 * double precio = scanner.nextDouble();
                 * System.out.print("Ingrese el cilindraje: ");
                 * int cilindraje = scanner.nextInt();
                 * scanner.nextLine();
                 * System.out.print("Ingrese la matrícula (6 caracteres): ");
                 * String placa = scanner.nextLine();
                 * 
                 * Vehiculo vehiculo;
                 * vehiculo = new Camion(marca, precio, cilindraje, numeroEjes, tipoCamion,
                 * capacidadCarga);
                 * if (tipo.equals("moto")) {
                 * System.out.print("¿Tiene sidecar? (true/false): ");
                 * boolean tieneSidecar = scanner.nextBoolean();
                 * scanner.nextLine();
                 * vehiculo = new Moto(marca, precio, cilindraje, tieneSidecar);
                 * } else if (tipo.equals("auto")) {
                 * System.out.print("¿Tiene radio? (true/false): ");
                 * boolean tieneRadio = scanner.nextBoolean();
                 * System.out.print("¿Tiene navegador? (true/false): ");
                 * boolean tieneNavegador = scanner.nextBoolean();
                 * scanner.nextLine();
                 * vehiculo = new Auto(marca, precio, cilindraje, tieneRadio, tieneNavegador);
                 * } else {
                 * System.out.println("Tipo de vehículo no reconocido.");
                 * break;
                 * }
                 * 
                 * if (!vehiculo.matricular(placa)) {
                 * System.out.println("Matrícula inválida. Debe tener 6 caracteres.");
                 * break;
                 * }
                 * }
                 * break;
                 */
                case 2:
                    System.out.print("Ingrese la matrícula del vehículo a retirar: ");
                    String matriculaRetirar = scanner.nextLine();
                    garaje.retirarVehiculo(matriculaRetirar);
                    break;

                case 3:
                    double ingresos = garaje.calcularIngresos();
                    System.out.println("Los ingresos mensuales son: " + ingresos);
                    break;

                case 4:
                    garaje.mostrarProporcionAutosMotosCamionCamioneta();
                    break;

                case 5:
                    garaje.listarVehiculos();
                    break;
                case 6:
                    System.out.println("Cantidad de plazas disponibles: " + garaje.plazasDisponibles());
                    break;
                case 7:
                    System.out.print("Ingrese la matrícula del vehículo a buscar: ");
                    placa = scanner.nextLine().trim();
                    int posicion = garaje.buscarVehiculo(placa);
                    if (posicion != -1) {
                        System.out.println("Vehículo encontrado en la posición: " + posicion);
                    } else {
                        System.out.println("No se encontró un vehículo con la matrícula: " + placa);
                    }
                    break;
                case 8:
                    garaje.listarCamionetasPorTipo();
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
