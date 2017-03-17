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

    public Fabrica(String nombre, ArrayList<Pedido> pedidos,
                   Politica politica, ArrayList<Fabrica> fabricas, boolean recibirPedido) {
        this.nombre = nombre;
        this.pedidos = pedidos;
        this.politica = politica;
        this.fabricas = fabricas;
        this.recibirPedido = recibirPedido;
    }

    public boolean compararMueble(Politica pol, Pedido ped){
        Mueble m = new Mueble();
        boolean flagAttr = false;
        boolean flagMueble = false;
        for(int i=0;i<ped.getMuebles().size();i++){
            m = ped.getMuebles().get(i);
            flagAttr = m.getAtributos().containsKey(pol.getAtributo());
            if(flagAttr==true){
                if(m.getAtributos().get(pol.getAtributo())==pol.getValor()){
                    flagMueble = true;
                }
            }else{break;}
        }
        return flagMueble;
    }

    public boolean compararEstado(Politica pol, Pedido ped){
        if(pol.getAtributo()=="Estado" && (String)pol.getValor()==ped.getEstado()){
            return true;
        }else{return false;}
    }

    public boolean compararLugarEntrega(Politica pol, Pedido ped){
        if(pol.getAtributo()=="Lugar Entrega"){
          if((String)pol.getValor()==ped.getLugarEntrega()){
              return true;
          }else{return false;}
        }else{return false;}
    }

    public boolean compararFechaPedido(Politica pol, Pedido ped){
        if((pol.getAtributo()=="Fecha Pedido")&&((Date)pol.getValor() == ped.getFechaPedido())){
            return true;
        }else{return false;}
    }

    public boolean compararFechaMaxEntrega(Politica pol, Pedido ped){
        if((pol.getAtributo()=="Fecha Max Entrega")&&((Date)pol.getValor() == ped.getFechaPedido())){
            return true;
        }else{return false;}
    }

    public boolean comprobarPoliticaPedido(Politica pol, Pedido ped){
        boolean flag = false;
        switch(pol.getAtributo()){
            case "Estado" : flag = compararEstado(pol,ped);
            case "Lugar Entrega" : flag = compararLugarEntrega(pol,ped);
            case "Fecha Pedido" : flag = compararFechaPedido(pol,ped);
            case "Fecha Max Entrega" : flag = compararFechaMaxEntrega(pol,ped);
            default : flag = compararMueble(pol,ped);
        }
        System.out.println(flag);
        return flag;
    }

    public Pedido proxPedido(Politica pol){
        boolean flag = false;
        Pedido p = new Pedido();
        for (int i = 0; i< pedidos.size(); i++){
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
            Politica pol;
            boolean flag = false;
            pol=politica.getListpolitica().get(0);
            p = proxPedido(pol);
            if(politica.getOperacion()=="And") {
                for (int i = 1; i < politica.getListpolitica().size(); i++) {
                    pol = politica.getListpolitica().get(i);
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
                    for (int i = 1; i < politica.getListpolitica().size(); i++) {
                        pol=politica.getListpolitica().get(i);
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

