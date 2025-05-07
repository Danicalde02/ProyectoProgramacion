package sistemacontratos;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SistemaContratos {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int opcion;
            //Cliente cliente = new Cliente();
            Inventario inventario = new Inventario();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Pago pago = new Pago();
            Contrato contrato = new Contrato();
            AsignacionEquipo asignacion = new AsignacionEquipo(inventario);
            boolean salir = false;
            Cliente cliente = contrato.getCliente(); // obtenemos el cliente dentro del contrato
            //Inventario invetario = inventario.getAsignacionInventario(); // obtenemos el invetario dentro de la asignacion
            List<Inventario> listaInventarios = new ArrayList<>();
            List<AsignacionEquipo> listaAsignaciones = new ArrayList<>();
            
            //Menu
            while (!salir) {
                System.out.println("\n--- MENÚ DE CONTRATOS ---");
                System.out.println("1. Crear contrato");
                System.out.println("2. Crear cliente");
                System.out.println("3. Asignar cliente a contrato");
                System.out.println("4. Ver Contrato");
                System.out.println("5. Ingresar Inventario");
                System.out.println("6. Ingresar Asignación Equipo");
                System.out.println("7. Asignar Equipos a Contrato");
                System.out.println("8. Ingresar Pagos");
                System.out.println("9. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // limpiar buffer
                
                switch (opcion) {
                    case 1 -> {
                        //Ingresar Datos de Contrato
                        System.out.print("Ingrese ID del Contrato: ");
                        int idContrato = scanner.nextInt();
                        contrato.setIdContrato(idContrato);
                        scanner.nextLine(); // Limpia el buffer
                        
                        System.out.print("Ingrese la fecha de inicio del contrato (dd/MM/yyyy): ");
                        String inputFechaInicio = scanner.nextLine();
                        
                        try {
                            Date fechainicio = formato.parse(inputFechaInicio);
                            contrato.setFechaInicio(fechainicio);
                            //System.out.println("Fecha registrada correctamente.");
                        } catch (ParseException e) {
                            System.out.println("Error: Formato de fecha inválido. Use dd/MM/yyyy.");
                        }
                        
                        System.out.print("Ingrese la fecha de finalización del contrato (dd/MM/yyyy): ");
                        String inputFechaFin = scanner.nextLine();
                        
                        try {
                            Date fechafin = formato.parse(inputFechaFin);
                            contrato.setFechaFin(fechafin);
                            //System.out.println("Fecha registrada correctamente.");
                        } catch (ParseException e) {
                            System.out.println("Error: Formato de fecha inválido. Use dd/MM/yyyy.");
                        }
                        
                        System.out.print("Ingrese Valor del Contrato: ");
                        int valorcontrato = scanner.nextInt();
                        contrato.setValorContrato(valorcontrato);
                        scanner.nextLine(); // Limpia el buffer
                        
                        System.out.println("Seleccione Estado del Contrato (1. Activo, 2. Terminado, 3. Suspendido): ");
                        opcion = scanner.nextInt();
                        switch (opcion) {
                            case 1 -> contrato.setEstadoContrato(EstadoContrato.Activo);
                            case 2 -> contrato.setEstadoContrato(EstadoContrato.Terminado);
                            case 3 -> contrato.setEstadoContrato(EstadoContrato.Suspendido);
                            default -> {
                                System.out.println("Opción no válida. Se asignará ESTADO SUSPENDIDO por defecto.");
                                contrato.setEstadoContrato(EstadoContrato.Suspendido);
                            }
                        }
                        
                        System.out.println("Seleccione Tipo del Contrato (1. Arrendamiento, 2. Mantenimiento, 3. Soporte): ");
                        opcion = scanner.nextInt();
                        switch (opcion) {
                            case 1 -> contrato.setTipoContrato(TipoContrato.Arrendamiento);
                            case 2 -> contrato.setTipoContrato(TipoContrato.Mantenimiento);
                            case 3 -> contrato.setTipoContrato(TipoContrato.Soporte);
                            default -> {
                                System.out.println("Opción no válida. Se asignará TIPO ARRENDAMIENTO por defecto.");
                                contrato.setTipoContrato(TipoContrato.Arrendamiento);
                            }
                        }
                        
                        System.out.print("Ingrese Alcance: ");
                        contrato.setAlcance(scanner.nextLine());
                        
                        System.out.println("\n--- Datos del Contrato ---");
                        contrato.mostrarInformacion();
                    }
                    case 2 -> {
                        //Ingresas datos de Cliente
                        System.out.print("Ingrese ID del Cliente: ");
                        cliente.setIdCliente(scanner.nextInt());
                        scanner.nextLine(); // Limpiar buffer
                        
                        System.out.print("Ingrese Nombre: ");
                        cliente.setNombre(scanner.nextLine());
                        
                        System.out.print("Ingrese Dirección: ");
                        cliente.setDireccion(scanner.nextLine());
                        
                        System.out.print("Ingrese Teléfono: ");
                        cliente.setTelefono(scanner.nextLine());
                        
                        System.out.print("Ingrese Correo: ");
                        cliente.setCorreo(scanner.nextLine());
                        
                        System.out.println("Seleccione Estado del Cliente (1. Activo, 2. Inactivo, 3. Suspendido): ");
                        opcion = scanner.nextInt();
                        switch (opcion) {
                            case 1 -> cliente.setEstadoCliente(EstadoCliente.Activo);
                            case 2 -> cliente.setEstadoCliente(EstadoCliente.Inactivo);
                            case 3 -> cliente.setEstadoCliente(EstadoCliente.Suspendido);
                            default -> {
                                System.out.println("Opción no válida. Se asignará ESTADO INACTIVO por defecto.");
                                cliente.setEstadoCliente(EstadoCliente.Inactivo);
                            }
                        }
                        
                        System.out.println("\n--- Datos del Cliente ---");
                        cliente.mostrarInformacion();
                    }
                    //Asignar Cliente a Contrato
                    case 3 -> {
                        if (contrato == null || cliente == null) {
                            System.out.println("Primero cree el cliente y el contrato.");
                        } else {
                            contrato.setCliente(cliente);
                            System.out.println("Cliente asignado al contrato.");
                        }
                        break;
                    }
                    //Mostrar detalles del contrato
                    case 4 -> {
                        if (contrato != null) {
                            System.out.println("\n--- DETALLES DEL CONTRATO ---");
                            contrato.mostrarInformacion();
                            if (contrato.getCliente() != null) {
                                System.out.println("Cliente asociado:");
                                cliente.mostrarInformacion();  // ← aquí llamas al método del cliente
                            } else {
                                System.out.println("Contrato sin cliente.");
                            }
                        } else {
                            System.out.println("No hay contrato creado.");
                        }
                        break;
                    }
                    //Ingresar datos de Inventario
                    case 5 -> {
                        Inventario nuevoinventario = new Inventario();
                        
                        System.out.print("Ingrese ID del Inventario: ");
                        nuevoinventario.setIdInventario(scanner.nextInt());
                        scanner.nextLine(); // Limpiar buffer
                        
                        System.out.print("Ingrese Modelo: ");
                        nuevoinventario.setModelo(scanner.nextLine());
                        
                        System.out.print("Ingrese Número de Serial: ");
                        nuevoinventario.setSerial(scanner.nextLine());
                        
                        System.out.print("Ingrese Número de Parte: ");
                        nuevoinventario.setNumeroParte(scanner.nextLine());
                                                
                        System.out.print("Ingrese Valor Unitario: ");
                        nuevoinventario.setValorUnitario(scanner.nextInt());
                        scanner.nextLine(); // Limpiar buffer
                        
                        System.out.println("Seleccione Estado del Inventario (1. Disponible, 2. Asignado, 3. Mantenimiento, 4.Devuelto): ");
                        opcion = scanner.nextInt();
                        switch (opcion) {
                            case 1 -> nuevoinventario.setEstadoInventario(EstadoInventario.Disponible);
                            case 2 -> nuevoinventario.setEstadoInventario(EstadoInventario.Asignado);
                            case 3 -> nuevoinventario.setEstadoInventario(EstadoInventario.Mantenimiento);
                            case 4 -> nuevoinventario.setEstadoInventario(EstadoInventario.Devuelto);
                            default -> {
                                System.out.println("Opción no válida. Se asignará ESTADO MANTENIMIENTO por defecto.");
                                inventario.setEstadoInventario(EstadoInventario.Mantenimiento);
                            }
                        }
                        
                        listaInventarios.add(nuevoinventario);
                        System.out.println("Inventario registrado correctamente.");
                        
                        System.out.println("\n--- Datos del Inventario Registrado ---");
                        nuevoinventario.mostrarInformacion();
                    }
                    
                    //Ingresar Asignación Equipo
                    case 6 -> {
                        if (listaInventarios.isEmpty()) {
                    System.out.println("No hay inventarios registrados. Cree uno primero.");
                    break;
                    }

                    System.out.println("Seleccione el ID del inventario a asignar:");
                    for (Inventario inv : listaInventarios) {
                    System.out.println("ID: " + inv.getIdInventario() + " | Modelo: " + inv.getModelo());
                    }

                    int idSeleccionado = scanner.nextInt();
                    scanner.nextLine(); // limpiar buffer

                    Inventario inventarioSeleccionado = null;
                    for (Inventario inv : listaInventarios) {
                    if (inv.getIdInventario() == idSeleccionado) {
                    inventarioSeleccionado = inv;
                    break;
                    }
                }

                    if (inventarioSeleccionado == null) {
                    System.out.println("ID no encontrado. Operación cancelada.");
                    break;
                    }
                    
                    asignacion = new AsignacionEquipo(inventarioSeleccionado);

                    System.out.print("Ingrese ID de la Asignación: ");
                    asignacion.setIdAsignacion(scanner.nextInt());
                    scanner.nextLine();

                    System.out.print("Ingrese fecha de asignación (dd/MM/yyyy): ");
                    String inputFechaAsign = scanner.nextLine();
                    try {
                        asignacion.setFechaAsignacion(formato.parse(inputFechaAsign));
                    } catch (ParseException ex) {
                        Logger.getLogger(SistemaContratos.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    System.out.print("Ingrese fecha de devolución (dd/MM/yyyy): ");
                    String inputFechaDev = scanner.nextLine();
                    try {
                        asignacion.setFechaDevolucion(formato.parse(inputFechaDev));
                    } catch (ParseException ex) {
                        Logger.getLogger(SistemaContratos.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    System.out.println("Asignación registrada correctamente.");
                    
                    if (contrato != null) {
                    contrato.agregarAsignacion(asignacion);
                    listaAsignaciones.add(asignacion);
                    System.out.println("Asignación asociada al contrato.");
                        } else {
                    System.out.println("Debe crear un contrato primero para asociar esta asignación.");
                    }
                }
                    
                    //Asignar Equipos a Contrato
                    case 7 -> {
                    if (listaAsignaciones.isEmpty()) {
                    System.out.println("No hay asignaciones disponibles para asociar al contrato.");
                    break;
                    }
                    
                    if (contrato == null) {
                    System.out.println("No hay contrato creado. Cree uno primero.");
                    break;
                    }

                    System.out.println("\n--- ASIGNACIONES DISPONIBLES ---");
                    for (AsignacionEquipo asign : listaAsignaciones) {
                    System.out.println("ID: " + asign.getIdAsignacion() + " | Fecha Asignación: " + asign.getFechaAsignacion());
                    }

                    System.out.print("Ingrese los ID de las asignaciones a vincular separados por coma (ej: 1,3,5): ");
                    String input = scanner.nextLine();
                    String[] idsSeleccionados = input.split(",");

                    int contador = 0;
                    for (String idStr : idsSeleccionados) {
                    try {
                        int id = Integer.parseInt(idStr.trim());
                        for (AsignacionEquipo asign : listaAsignaciones) {
                        if (asign.getIdAsignacion() == id) {
                        if (asign.getContrato() == null) { // para evitar asignarlas 2 veces
                        contrato.agregarAsignacion(asign);
                        asign.setContrato(contrato);
                        contador++;
                        }
                        break;
                        }
                        }
                    } 
                    catch (NumberFormatException e) {
                    System.out.println("ID inválido: " + idStr.trim());
                    }
                }

                    if (contador > 0) {
                    System.out.println("Se asociaron " + contador + " asignaciones al contrato.");
                    } else {
                    System.out.println("No se asociaron asignaciones.");
                    }
                }        
                
                    //Ingresar Datos de Pago
                    case 8 -> {
                        System.out.print("Ingrese ID del Pago: ");
                        int idPago = scanner.nextInt();
                        pago.setIdPago(idPago);
                        scanner.nextLine(); // Limpia el buffer
                        
                        System.out.print("Ingrese la fecha de pago (dd/MM/yyyy): ");
String inputFecha = scanner.nextLine();

try {
    Date fecha = formato.parse(inputFecha);
    pago.setFechaPago(fecha);
} catch (ParseException e) {
    System.out.println("Error: Formato de fecha inválido. Use dd/MM/yyyy.");
}

System.out.print("Ingrese Valor del Pago: ");
int valorPago = scanner.nextInt();
pago.setValor(valorPago);
scanner.nextLine(); // Limpia el buffer

System.out.println("Seleccione Estado del Pago (1. Pendiente, 2. Pagado, 3. Vencido): ");
opcion = scanner.nextInt();
switch (opcion) {
    case 1 -> pago.setEstadoPago(EstadoPago.Pendiente);
    case 2 -> pago.setEstadoPago(EstadoPago.Pagado);
    case 3 -> pago.setEstadoPago(EstadoPago.Vencido);
    default -> {
        System.out.println("Opción no válida. Se asignará ESTADO PENDIENTE por defecto.");
        pago.setEstadoPago(EstadoPago.Pendiente);
    }
}

System.out.println("Seleccione el Metodo de Pago:");
System.out.println("1. Transferencia");
System.out.println("2. Tarjeta");
System.out.println("3. Efectivo");
opcion = scanner.nextInt();
scanner.nextLine(); // limpiar buffer

MetodoPago metodoPago = null;

switch (opcion) {
    case 1 -> {
        System.out.print("Ingrese el nombre del titular: ");
        String titular = scanner.nextLine();
        System.out.print("Ingrese el número de cuenta de origen: ");
        String cuenta = scanner.nextLine();
        System.out.print("Ingrese el banco de origen: ");
        String banco = scanner.nextLine();
        System.out.print("Ingrese el código o referencia de la transferencia: ");
        String referencia = scanner.nextLine();
        metodoPago = new PagoTransferencia(titular, valorPago, cuenta, banco, referencia);
    }
    case 2 -> {
        System.out.print("Ingrese el nombre del titular: ");
        String titular = scanner.nextLine();
        System.out.print("Ingrese el número de tarjeta: ");
        String numeroTarjeta = scanner.nextLine();
        System.out.print("Ingrese la fecha de expiración (MM/AA): ");
        String fechaExpiracion = scanner.nextLine();
        System.out.print("Ingrese el CVV: ");
        String cvv = scanner.nextLine();
        metodoPago = new PagoTarjeta(titular, valorPago, numeroTarjeta, fechaExpiracion, cvv);
    }
    case 3 -> {
        System.out.print("Ingrese el nombre del pagador: ");
        String titular = scanner.nextLine();
        metodoPago = new PagoEfectivo(titular, valorPago);
    }
    default -> {
        System.out.println("Opción no válida. Se asignará pago en efectivo por defecto.");
        metodoPago = new PagoEfectivo("Anónimo", valorPago);
    }
}

pago.setMetodoPago(metodoPago);

System.out.println("\n--- Datos del Pago ---");
pago.mostrarInformacion();
                    }
                    
                    case 9 -> {
                        salir = true;
                        System.out.println("Saliendo...");
                    }
                    default -> System.out.println("Opción inválida.");
                }
            }
        }
                
    }
}
