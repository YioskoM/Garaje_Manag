
import java.util.ArrayList;
import java.util.Scanner;


public class GestionGaraje {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner garajeOpcion = new Scanner(System.in);
        int opcion;
        ArrayList<Garaje> coleccionGaraje = null;

        do{ 
            System.out.println("\n--- Menú de Gestión del Garaje ---");
            System.out.println("");
            System.out.println("1. Crear Garaje");
            System.out.println("2. Eliminar Garaje");
            System.out.println("3. Actualizar Garaje");
            System.out.println("4. Ver Garajes");

            int opcionGar = garajeOpcion.nextInt();

            switch (opcionGar) {
                case 1:
                    System.out.println("Departamento en el cual se localiza el Garaje");
                    String departamento = scanner.nextLine();
                    System.out.println("Ciudad en el cual se localiza el Garaje");
                    String ciudad = scanner.nextLine();
                    System.out.println("Dirección en el cual se encuentra el Garaje");
                    String direccion = scanner.nextLine();
                    System.out.println("numero telefonico del administrador");
                    int telefono = scanner.nextInt();
                    System.out.println("email del adminstrador");
                    String email = scanner.nextLine();
                    System.out.println("nombre completo del administrador");
                    String nameAdmin = scanner.nextLine();

                    Garaje garaje = new Garaje(departamento, ciudad, direccion, telefono, email, nameAdmin);
                    coleccionGaraje.add(garaje);
                    break;

                    case 2:
                        System.out.println("aun no hay opcion");
                    break;

                    case 3:
                        System.out.println("aun no hay opcion");
                    break;

                    case 4:
                        if(coleccionGaraje != null){
                            System.out.println("muestra toda los garajes (metodo no creado aun)");
                            System.out.println("cual garaje deseas escoger?");
                            int opcionGarajeIndice = scanner.nextInt();
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
                                            vehiculo = new Camion(placa, marca, precio, cilindraje, placa, opcion, cilindraje, numeroEjes,
                                                    tipoCamion, capacidadCarga);
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
                                            vehiculo = new Auto(placa, marca, precio, cilindraje, placa, opcion, cilindraje, tieneRadio,
                                                    tieneNavegador);
                                        } else if (tipo.equals("camioneta")) {
                                            System.out.print("Ingrese el tipo de servicio (SUV/Pickup/Carga/Otro): ");
                                            String tipoServicio = scanner.nextLine();
                                            System.out.print("Ingrese el número de pasajeros: ");
                                            int numeroPasajeros = scanner.nextInt();
                                            System.out.print("¿Tiene remolque? (true/false): ");
                                            boolean tieneRemolque = scanner.nextBoolean();
                                            scanner.nextLine();
                                            vehiculo = new Camioneta(placa, marca, precio, cilindraje, placa, opcion, cilindraje,
                                                    tipoServicio, numeroPasajeros, tieneRemolque);
                                            
                                        } else {
                                            System.out.println("Tipo de vehículo no reconocido.");
                                            break;
                                        }
                    
                                        if (vehiculo != null) {
                                            if (!vehiculo.matricular(placa)) {
                                                System.out.println("Matrícula inválida. Debe tener 6 caracteres.");
                                                break;
                                            }
                                            if (coleccionGaraje.get(opcionGarajeIndice).alquilarEspacio(vehiculo)) { // Llama al método después de inicializar
                                                System.out.println("Vehículo registrado exitosamente.");
                                            } else {
                                                System.out.println("No hay espacio disponible en el garaje.");
                                            }
                                        }
                                        break;
                    
                                    
                                    case 2:
                                        System.out.print("Ingrese la matrícula del vehículo a retirar: ");
                                        String matriculaRetirar = scanner.nextLine();
                                        coleccionGaraje.get(opcionGarajeIndice).retirarVehiculo(matriculaRetirar);
                                        break;
                    
                                    case 3:
                                        double ingresos = coleccionGaraje.get(opcionGarajeIndice).calcularIngresos();
                                        System.out.println("Los ingresos mensuales son: " + ingresos);
                                        break;
                    
                                    case 4:
                                        coleccionGaraje.get(opcionGarajeIndice).mostrarProporcionAutosMotosCamionCamioneta();
                                        break;
                    
                                    case 5:
                                        coleccionGaraje.get(opcionGarajeIndice).listarVehiculos();
                                        break;
                                    case 6:
                                        System.out.println("Cantidad de plazas disponibles: " + coleccionGaraje.get(opcionGarajeIndice).plazasDisponibles());
                                        break;
                                    case 7:
                                        System.out.print("Ingrese la matrícula del vehículo a buscar: ");
                                        placa = scanner.nextLine().trim();
                                        int posicion = coleccionGaraje.get(opcionGarajeIndice).buscarVehiculo(placa);
                                        if (posicion != -1) {
                                            System.out.println("Vehículo encontrado en la posición: " + posicion);
                                        } else {
                                            System.out.println("No se encontró un vehículo con la matrícula: " + placa);
                                        }
                                        break;
                                    case 8:
                                    coleccionGaraje.get(opcionGarajeIndice).listarCamionetasPorTipo();
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

                        default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                    } break;

           } while (true);
       
        }
    } 
