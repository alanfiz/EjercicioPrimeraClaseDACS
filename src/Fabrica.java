import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by alan on 13-Mar-17.
 */
public class Fabrica {

    private String nombre;
    private List<Pedido> pedidos;
    private Politica politica;
    private Fabrica fabrica;

    public void agregarPedido(Pedido p){
        pedidos.add(p);
    }

    public void atenderPedido(Pedido p){
        p.setEstado("Completado");
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setPolitica(Politica politica) {
        this.politica = politica;
    }

    public void setFabrica(Fabrica fabrica) {
        this.fabrica = fabrica;
    }


    public Politica getPolitica() {
        return politica;
    }

    public Fabrica getFabrica() {
        return fabrica;
    }

    public Fabrica(Pedido pedido, Politica politica, Fabrica fabrica) {
        this.politica = politica;
        this.fabrica = fabrica;
    }

    public Fabrica() {
    }

    public static void main(String[] args) {

        //crear map
        Map<String, String> m = new HashMap<String, String>();
        m.put("Color","Rojo");
        m.put("Material","Pino");

        Mueble mueble = new Mueble(m);
        System.out.println(mueble);
    }


    public boolean compararMueble(Pedido ped){}

    public boolean compararEstado(Pedido ped){
        if(politica.getAtributo()=="Estado" && (String)politica.getValor()==ped.getEstado()){
            return true;
        }else{return false;}
    }

    public boolean compararLugarEntrega(Pedido ped){
        if(politica.getAtributo()=="Lugar Entrega" && (String)politica.getValor()==ped.getLugarEntrega()){
            return true;
        }else{return false;}
    }

    public boolean compararFechaPedido(Pedido ped){
        if((politica.getAtributo()=="Fecha Pedido")&&((Date)politica.getValor() == ped.getFechaPedido())){
            return true;
        }else{return false;}
    }

    public boolean compararFechaMaxEntrega(Pedido ped){
        if((politica.getAtributo()=="Fecha Max Entrega")&&((Date)politica.getValor() == ped.getFechaPedido())){
            return true;
        }else{return false;}
    }

    public Pedido proxPedido(){
        for (int i = 0; i<= pedidos.size(); i++){
            boolean flag;
            Pedido p = new Pedido();
            p = pedidos.get(i);
            switch(politica.getAtributo()){
                case "Estado" : flag = compararEstado(p);
                case "Lugar Entrega" : flag = compararLugarEntrega(p);
                case "Fecha Pedido" : flag = compararFechaPedido(p);
                case "Fecha Max Entrega" : flag = compararFechaMaxEntrega(p);
            }

            }
        }
    }

    //public void atenderPedido(){}
}
