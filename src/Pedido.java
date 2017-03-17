import java.util.Date;
import java.util.List;

/**
 * Created by alan on 13-Mar-17.
 */
public class Pedido {

    private Date fechaPedido;
    private Date fechaMaxEntrega;
    private String lugarEntrega;
    private String estado;
    private List<Mueble> muebles;

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Pedido(){}

    public Pedido(Date fechaPedido, Date fechaMaxEntrega, String lugarEntrega, String estado, List<Mueble> muebles) {
        this.fechaPedido = fechaPedido;
        this.fechaMaxEntrega = fechaMaxEntrega;
        this.lugarEntrega = lugarEntrega;
        this.estado = estado;
        this.muebles = muebles;
    }

    public Date getFechaMaxEntrega() {
        return fechaMaxEntrega;
    }

    public void setFechaMaxEntrega(Date fechaMaxEntrega) {
        this.fechaMaxEntrega = fechaMaxEntrega;
    }

    public String getLugarEntrega() {
        return lugarEntrega;
    }

    public void setLugarEntrega(String lugarEntrega) {
        this.lugarEntrega = lugarEntrega;
    }

    public List<Mueble> getMuebles() {
        return muebles;
    }

    public void setMuebles(List<Mueble> muebles) {
        this.muebles = muebles;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "fechaPedido=" + fechaPedido +
                ", fechaMaxEntrega=" + fechaMaxEntrega +
                ", lugarEntrega='" + lugarEntrega + '\'' +
                ", estado='" + estado + '\'' +
                ", muebles=" + muebles +
                '}';
    }
}
