package sistemacontratos;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Contrato {
    private int idContrato;
    private Date fechainicio;
    private Date fechafin;
    private int valorcontrato;
    private EstadoContrato estadoContrato;
    private TipoContrato tipoContrato;
    private Cliente cliente; // Asociación por composición
    private String alcance;
    private final List<AsignacionEquipo> asignaciones = new ArrayList<>();
    //private List<Pago> pagos = new ArrayList<>();
    //private List<Servicio> servicios = new ArrayList<>();
    
            
    public Contrato() {
        this.cliente = new Cliente(); // crear instancia por defecto
    }

    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public Date getFechaInicio() {
        return fechainicio;
    }

    public void setFechaInicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }
    
    public Date getFechaFin() {
        return fechafin;
    }

    public void setFechaFin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public int getValorContrato() {
        return valorcontrato;
    }

    public void setValorContrato(int valor) {
        this.valorcontrato = valor;
    }

    public EstadoContrato getEstadoContrato() {
        return estadoContrato;
    }

    public void setEstadoContrato(EstadoContrato estadoContrato) {
        this.estadoContrato = estadoContrato;
    }
    
    public TipoContrato getTipoContrato() {
        return tipoContrato;
    }
    
    public void setTipoContrato(TipoContrato tipoContrato) {
        this.tipoContrato = tipoContrato;
    }
    
    public Cliente getCliente() {
    return cliente;
    }

    public void setCliente(Cliente cliente) {
    this.cliente = cliente;
    }
    
    public String getAlcance() {
        return alcance;
    }

    public void setAlcance(String alcance) {
        this.alcance = alcance;
    }
    
        // Método para mostrar los datos del cliente
    public void mostrarInformacion() {
        System.out.println("ID Contrato: " + idContrato);
        System.out.println("Fecha Inicio: " + fechainicio);
        System.out.println("Fecha Fin: " + fechafin);
        System.out.println("Valor: " + valorcontrato);
        System.out.println("Estado Contrato: " + estadoContrato);
        System.out.println("Tipo Contrato: " + tipoContrato);
        System.out.println("Alcance: " + alcance);
        
        if (!asignaciones.isEmpty()) {
        System.out.println("Asignaciones asociadas:");
        for (AsignacionEquipo asign : asignaciones) {
        asign.mostrarInformacion();
        }
            } else {
        System.out.println("No hay asignaciones asociadas.");
        }
    }

        public void agregarAsignacion(AsignacionEquipo asignacion) {
        if (asignacion != null) {
        asignaciones.add(asignacion);
        }
    }

}

