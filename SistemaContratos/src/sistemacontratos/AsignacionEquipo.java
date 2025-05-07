package sistemacontratos;
import java.util.Date;


public class AsignacionEquipo {
    private int idAsignacion;
    private Date fechaasignacion;
    private Date fechadevolucion;
    private Inventario inventario; // Asociación por agregacion
    private Contrato contrato; 
    
    public AsignacionEquipo(Inventario inventario) {
    if (inventario == null) {
        throw new IllegalArgumentException("El inventario no puede ser nulo.");
    }
    this.inventario = inventario;
    }
    
    public AsignacionEquipo(Contrato contrato) {
    this.contrato = contrato;
    }
    
    public Contrato getContrato() {
    return contrato;
    }

    public void setContrato(Contrato contrato) {
    this.contrato = contrato;
    }
    
    public int getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(int idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public Date getFechaAsignacion() {
        return fechaasignacion;
    }

    public void setFechaAsignacion(Date fechaasignacion) {
        this.fechaasignacion = fechaasignacion;
    }

    public Date getFechaDevolucion() {
        return fechadevolucion;
    }

    public void setFechaDevolucion(Date fechadevolucion) {
        this.fechadevolucion = fechadevolucion;
    }    
    
    public Inventario getInventario() {
    return inventario;
    }

    public void setInventario(Inventario inventario) {
        if (inventario == null) {
            throw new IllegalArgumentException("El inventario no puede ser nulo.");
        }
        this.inventario = inventario;
    }

    
        // Método para mostrar la Asignación de los equipos
    public void mostrarInformacion() {
        System.out.println("ID Asignación del Equipo: " + idAsignacion);
        System.out.println("Fecha Asignación: " + fechaasignacion);
        System.out.println("Fecha Devolucion: " + fechadevolucion);
        inventario.mostrarInformacion(); // Mostrar también info del inventario
        
        if (contrato != null) {
        System.out.println("--- Datos del contrato asociado ---");
        contrato.mostrarInformacion();
            } else {
        System.out.println("No hay contrato asociado a esta asignación.");
            }
        }
}
