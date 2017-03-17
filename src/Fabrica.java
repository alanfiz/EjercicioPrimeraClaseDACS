import java.lang.ref.PhantomReference;
import java.util.*;

/**
 * Created by alan on 13-Mar-17.
 */
public class Fabrica {

    private String nombre;
    private ArrayList<Pedido> pedidos;
    private Politica politica;
    private ArrayList<Fabrica> fabricas;
    private boolean recibirPedido;

    public ArrayList<Fabrica> getFabricas() {
        return fabricas;
    }

    public void setFabricas(ArrayList<Fabrica> fabricas) {
        this.fabricas = fabricas;
    }

    public boolean getRecibirPedido() {
        return recibirPedido;
    }

    public void setRecibirPedido(boolean recibirPedido) {
        this.recibirPedido = recibirPedido;
    }

    public void agregarPedido(Pedido p){
        pedidos.add(p);
    }

    public void atenderPedido(Pedido p){
        p.setEstado("Completado");
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
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

    public void setFabrica(ArrayList<Fabrica> fabricas) {
        this.fabricas = fabricas;
    }


    public Politica getPolitica() {
        return politica;
    }

    public ArrayList<Fabrica> getFabrica() {
        return fabricas;
    }

    public Fabrica(Pedido pedido, Politica politica, ArrayList<Fabrica> fabricas) {
        this.politica = politica;
        this.fabricas = fabricas;
    }

    public Fabrica() {
    }

    public static void main(String[] args) {

        Map<String, String> m = new HashMap<String, String>();
        m.put("Color","Rojo");
        m.put("Material","Pino");

        Mueble mueble = new Mueble(m);
        System.out.println(mueble);
    }



    public boolean compararMueble(Pedido ped){
        Mueble m = new Mueble();
        boolean flagAttr = false;
        boolean flagMueble = false;
        for(int i=0;i<=ped.getMuebles().size();i++){
            m = ped.getMuebles().get(i);
            flagAttr = m.getAtributos().containsKey(politica.getAtributo());
            if(flagAttr==true){
                if(m.getAtributos().get(politica.getAtributo())==politica.getValor()){
                    flagMueble = true;
                }
            }
            if(flagMueble == false){break;}
        }
        return flagMueble;
    }

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

    public boolean comprobarPoliticaPedido(Politica pol, Pedido ped){
        boolean flag = false;
        switch(pol.getAtributo()){
            case "Estado" : flag = compararEstado(ped);
            case "Lugar Entrega" : flag = compararLugarEntrega(ped);
            case "Fecha Pedido" : flag = compararFechaPedido(ped);
            case "Fecha Max Entrega" : flag = compararFechaMaxEntrega(ped);
            default : flag = compararMueble(ped);
        }
        return flag;
    }

    public Pedido proxPedido(Politica pol){
        boolean flag = false;
        Pedido p = new Pedido();
        for (int i = 0; i<= pedidos.size(); i++){
            p = pedidos.get(i);
            flag = comprobarPoliticaPedido(pol,p);
            if(pol.getClass().getSimpleName()=="PoliticaSimple"){
            if(flag==false){pedidos.get(i).setEstado("Delegar");}else{
            break;}}
        }
        if(flag = true){return p;}else{return null;}
    }

    public void atenderPedido(){
        Pedido p = new Pedido();
        boolean f = false;
        if(politica.getClass().getSimpleName()=="PoliticaSimple"){
        p = proxPedido(politica);
        if(p == null){System.out.println("Pedido nulo");}
        else{
        f = pedidos.remove(p);
        if(f==true)System.out.println("Pedido Realizado");
        }
        }else{
            Politica pol = new PoliticaSimple();
            boolean flag = false;
            pol=politica.getListpolitica().get(0);
            p = proxPedido(pol);
            if(politica.getOperacion()=="And") {
                for (int i = 1; i <= politica.getListpolitica().size(); i++) {
                    flag = comprobarPoliticaPedido(pol, p);
                    if (flag == false) {
                        p.setEstado("Delegar");
                        break;
                    }
                }
                if (flag == true) {
                    f = pedidos.remove(p);
                    if (f == true) System.out.println("Pedido Realizado");
                }
            }else{
                if(p!=null){
                    f = pedidos.remove(p);
                    if (f == true) System.out.println("Pedido Realizado");
                }else {
                    for (int i = 1; i <= politica.getListpolitica().size(); i++) {
                        flag = comprobarPoliticaPedido(pol, p);
                        if (flag == true) {
                            f = pedidos.remove(p);
                            if (f == true) System.out.println("Pedido Realizado");
                            break;
                        }
                    }
                    if (flag == false) {
                        p.setEstado("Delegar");
                    }
                }
            }
        }
    }

    public void delegarPedido(){
        for(int i = 0; i <=pedidos.size(); i++){
            Pedido p = new Pedido();
            p = pedidos.get(i);
            boolean f = false;
            if(p.getEstado() == "Delegar"){
                delegarFabrica(p);
                f = pedidos.remove(p);
                if(f==true)System.out.println("Pedido Delegado");
            }
        }

    }

    public void delegarFabrica(Pedido p){
        for(int i = 0; i<=fabricas.size(); i++){
            if(fabricas.get(i).getRecibirPedido()==true){fabricas.get(i).getPedidos().add(p);break;}
        }
    }
}
