package sistemacontratos;
import java.util.Date;

public class Pago {
    private int idPago;
    private Date fechapago;
    private int valor;
    private EstadoPago estadoPago;
    private MetodoPago metodoPago;
    private Contrato contrato;
    
    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public Date getFechaPago() {
        return fechapago;
    }

    public void setFechaPago(Date fechapago) {
        this.fechapago = fechapago;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public EstadoPago getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(EstadoPago estadoPago) {
        this.estadoPago = estadoPago;
    }
    
    public MetodoPago getMetodoPago() {
        return metodoPago;
    }
    
    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }
    
    public Contrato getContrato() {
    return contrato;
    }

    public void setContrato(Contrato contrato) {
    this.contrato = contrato;
    }
    
        // Método para mostrar los datos del cliente
    public void mostrarInformacion() {
        System.out.println("ID Pago: " + idPago);
        System.out.println("Fecha Pago : " + fechapago);
        System.out.println("Valor: " + valor);
        System.out.println("Estado: " + estadoPago);
        System.out.println("Metodo Pago: " + metodoPago);
    }
}
