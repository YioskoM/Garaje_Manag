package evaluacion2_ejerciciopractico;

import evaluacion2_ejerciciopractico.Garajes.Garaje;
import evaluacion2_ejerciciopractico.Vehiculo.Auto;
import evaluacion2_ejerciciopractico.Vehiculo.Camion;
import evaluacion2_ejerciciopractico.Vehiculo.Camioneta;
import evaluacion2_ejerciciopractico.Vehiculo.Moto;
import evaluacion2_ejerciciopractico.Vehiculo.Vehiculo;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionGaraje {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Scanner garajeOpcion = new Scanner(System.in);
        

        int opcion;
        // !crear la coleccion de garajes COMMIT #7
        ArrayList<Garaje> coleccionGaraje = new ArrayList<Garaje>();
        ArrayList<String> matriculas = new ArrayList<String>();




        do {
            // !Creacion del menu para garajes COMMIT OPEN#7
            System.out.println("\n--- Menú de Gestión del Garaje ---");
            System.out.println("");
            System.out.println("1. Crear Garaje");
            System.out.println("2. Eliminar Garaje");
            System.out.println("3. Actualizar Garaje");
            System.out.println("4. Ver Garajes");
            System.out.print("Seleccione una opción: ");

            int opcionGar = garajeOpcion.nextInt();

            // no comentarios

            switch (opcionGar) {
                case 1:
                    Scanner seleccionGaraje = new Scanner(System.in);
                    // ! Opciones del menu garaje COMMIT OPEN#8
                    System.out.println("Departamento en el cual se localiza el Garaje");
                    String departamento = seleccionGaraje.nextLine();
                    System.out.println("Ciudad en el cual se localiza el Garaje");
                    String ciudad = seleccionGaraje.nextLine();
                    System.out.println("Dirección en el cual se encuentra el Garaje");
                    String direccion = seleccionGaraje.nextLine();
                    System.out.println("Numero telefonico del administrador");
                    String telefono = seleccionGaraje.nextLine();

                    System.out.println("Email del adminstrador");
                    String email = seleccionGaraje.nextLine();
                    System.out.println("Nombre completo del administrador");
                    String nameAdmin = seleccionGaraje.nextLine();
                    System.out.println("Cantidad de espacios que tiene su garaje");
                    int numEspacios = seleccionGaraje.nextInt();
                    // ! Crear Garaje y agregarlo a colecion COMMIT #8
                    Garaje garaje = new Garaje(departamento, ciudad, direccion, telefono, email, nameAdmin, numEspacios);
                    coleccionGaraje.add(garaje);

                    System.out.println();
                    System.out.println("Garaje fue creado exitosamente");
                    Thread.sleep(2 * 1000);
                    break;

                case 2:
                    // ! Opciones de menu #2 COMMIT OPEN#9
                    if (coleccionGaraje.size() > 0) {
                        for (int i = 0; coleccionGaraje.size() > i; i++) {
                            coleccionGaraje.get(i).mostrarCaracteristicas(i);
                            System.out.println("");
                            Thread.sleep(3 * 1000);
                        }
                        System.out.println("");
                        System.out.println("Que garaje deseas eliminar?(ingresa el numero)");
                        int garajeEliminar = scanner.nextInt();

                        if (garajeEliminar <= coleccionGaraje.size()) {
                            coleccionGaraje.remove(garajeEliminar);
                            System.out.println();
                            System.out.println("Garaje eliminado exitosamente");
                            Thread.sleep(2 * 1000);

                        } else {
                            System.out.println();
                            System.out.println("Garaje no existe");
                            Thread.sleep(2 * 1000);

                        }
                    } else {
                        System.out.println("");
                        System.out.println("No tienes Garajes creados");
                        Thread.sleep(2 * 1000);
                    }
                    break;

                case 3:
                //! Opcion menu 3 COMMIT OPEN #3 ACTUALIZACIÓN
                    if (coleccionGaraje.size() > 0) {
                        for (int i = 0; coleccionGaraje.size() > i; i++) {
                            coleccionGaraje.get(i).mostrarCaracteristicas(i);
                            System.out.println("");
                            Thread.sleep(2 * 1000);
                        }
                        Scanner actualizar = new Scanner(System.in);
                        System.out.println("Que garaje deseas actualizar?");
                        int opcionActualizar = actualizar.nextInt();
                        if(coleccionGaraje.size() >= opcionActualizar){
                            //! Actualizar direccion
                            Scanner seleccionActualizar = new Scanner(System.in);
                            System.out.println("Actualizar direccion del garaje, DIRECCION ACTUAL: " + coleccionGaraje.get(opcionActualizar).getDireccion());
                            String direccionActualizar = seleccionActualizar.nextLine();
                            coleccionGaraje.get(opcionActualizar).setDireccion(direccionActualizar);

                            //! Actualizacion de telefono
                            System.out.println("Actualizar telefono del garaje, TELEFONO ACTUAL: " + coleccionGaraje.get(opcionActualizar).getNumero());
                            String telefonoActualizar = seleccionActualizar.nextLine();
                            coleccionGaraje.get(opcionActualizar).setNumero(telefonoActualizar);
                            
                            //! Actualizacion de email
                            System.out.println("Actualizar email del garaje, EMAIL ACTUAL: "+ coleccionGaraje.get(opcionActualizar).getEmail());
                            String emailActualizar = seleccionActualizar.nextLine();
                            coleccionGaraje.get(opcionActualizar).setEmail(emailActualizar);

                            System.out.println("Actualizar administrador, ADMIN ACTUAL: " + coleccionGaraje.get(opcionActualizar).getNameAdmin());
                            String adminActualizar = seleccionActualizar.nextLine();
                            coleccionGaraje.get(opcionActualizar).setNameAdmin(adminActualizar);
                        } else {
                            System.out.println("Garaje no existe");
                        }
                    }else{
                        System.out.println("No hay garajes creados");
                    }
                    
                    break;

                case 4:
                    if (coleccionGaraje.size() > 0) {
                        for (int i = 0; coleccionGaraje.size() > i; i++) {
                            coleccionGaraje.get(i).mostrarCaracteristicas(i);
                            System.out.println("");
                            Thread.sleep(3 * 1000);
                        }
                        System.out.println("");
                        System.out.println("Cual garaje deseas escoger?");
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


                                    boolean matriculaRepetida = false;

                                        if(matriculas.size() > 0){
                                        for(int i = 0; matriculas.size() > i; i++){
                                        
                                          if (matriculas.get(i) == coleccionGaraje.get(i).espacios.get(i).getPlaca()) {
                                            matriculaRepetida = true;
                                            
                                        }
                                        
                                         }
                                     
                                        }
                                    Vehiculo vehiculo = null;
                                    if(matriculaRepetida == false){
                                        matriculas.add(placa);
                                    if (tipo.equals("camion")) {
                                        System.out.print("Ingrese el tipo de camión (sencillo/doble): ");
                                        String tipoCamion = scanner.nextLine();
                                        System.out.print("Ingrese el número de ejes: ");
                                        int numeroEjes = scanner.nextInt();
                                        System.out.print("Ingrese la capacidad de carga en toneladas: ");
                                        double capacidadCarga = scanner.nextDouble();
                                        scanner.nextLine();
                                        vehiculo = new Camion(placa, marca, precio, cilindraje, placa, opcion, cilindraje, tipo, numeroEjes, tipoCamion, capacidadCarga);
                                    } else if (tipo.equals("moto")) {
                                        System.out.print("¿Tiene sidecar? (true/false): ");
                                        boolean tieneSidecar = scanner.nextBoolean();
                                        scanner.nextLine();
                                        vehiculo = new Moto(placa, marca, precio, cilindraje, placa, opcion, cilindraje, tipo, tieneSidecar);
                                    } else if (tipo.equals("auto")) {
                                        System.out.print("¿Tiene radio? (true/false): ");
                                        boolean tieneRadio = scanner.nextBoolean();
                                        System.out.print("¿Tiene navegador? (true/false): ");
                                        boolean tieneNavegador = scanner.nextBoolean();
                                        scanner.nextLine();
                                        vehiculo = new Auto(tieneNavegador, tieneRadio, placa, marca, precio, cilindraje, placa, opcion, cilindraje, tipo);

                                    } else if (tipo.equals("camioneta")) {
                                        System.out.print("Ingrese el tipo de servicio (SUV/Pickup/Carga/Otro): ");
                                        String tipoServicio = scanner.nextLine();
                                        System.out.print("Ingrese el número de pasajeros: ");
                                        int numeroPasajeros = scanner.nextInt();
                                        System.out.print("¿Tiene remolque? (true/false): ");
                                        boolean tieneRemolque = scanner.nextBoolean();
                                        scanner.nextLine();
                                        vehiculo = new Camioneta(numeroPasajeros, tieneRemolque, tipoServicio, placa, marca, precio, cilindraje, marca, precio, precio, tipo);
                                      

                                    } else {
                                        System.out.println("Tipo de vehículo no reconocido.");
                                        break;
                                    }

                                    if (vehiculo != null) {
                                        if (!vehiculo.matricular(placa)) {
                                            System.out.println("Matrícula inválida. Debe tener 6 caracteres.");
                                            break;
                                        }
                                        if (coleccionGaraje.get(opcionGarajeIndice).alquilarEspacio(vehiculo)) { // Llama
                                                                                                                 // al
                                                                                                                 // método
                                                                                                                 // después
                                                                                                                 // de
                                                                                                                 // inicializar
                                            System.out.println("Vehículo registrado exitosamente.");
                                            Thread.sleep(2 * 1000);
                                        } else {
                                            System.out.println("No hay espacio disponible en el garaje.");
                                        }
                                    }
                                } else {
                                    System.out.println("La matricula de su vehiculo ya existe");
                                }
                                    break;

                                case 2:
                                if (coleccionGaraje.size() > 0) {
                                    for (int i = 0; coleccionGaraje.size() > i; i++) {
                                        coleccionGaraje.get(i).espacios.get(i).mostrarCaracteristicasVehiculos(i); 
                                        System.out.println("");
                                        Thread.sleep(3 * 1000);
                                    }
                                }
                                    System.out.print("Ingrese la matrícula del vehículo a retirar: ");
                                    String matriculaRetirar = scanner.nextLine();
                                    coleccionGaraje.get(opcionGarajeIndice).retirarVehiculo(matriculaRetirar);
                                    break;

                                case 3:
                                    double ingresos = coleccionGaraje.get(opcionGarajeIndice).calcularIngresos();
                                    System.out.println("Los ingresos mensuales son: " + ingresos);
                                    break;

                                case 4:
                                    coleccionGaraje.get(opcionGarajeIndice)
                                            .mostrarProporcionAutosMotosCamionCamioneta();
                                    break;

                                case 5:
                                    coleccionGaraje.get(opcionGarajeIndice).listarVehiculos();
                                    break;
                                case 6:
                                    System.out.println("Cantidad de plazas disponibles: "
                                            + coleccionGaraje.get(opcionGarajeIndice).plazasDisponibles());
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
                    } else {
                        System.out.println("Aun no existe ningun Garaje");
                    }

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }

        } while (true);

    }
}

