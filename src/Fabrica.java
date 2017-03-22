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
        Mueble m;
        boolean flagAttr;
        boolean flagMueble = true;
        for(int i=0;i<ped.getMuebles().size();i++){
            m = ped.getMuebles().get(i);
            flagAttr = m.getAtributos().containsKey(pol.getAtributo());
            if(flagAttr==true){
                if(m.getAtributos().get(pol.getAtributo())==pol.getValor()){
                    //System.out.println(i);
                    flagMueble = true;
                }
            }else{flagMueble=false;}
        }
        //System.out.println(flagMueble);
        return flagMueble;
    }

    public boolean compararEstado(Politica pol, Pedido ped){
        if(pol.getAtributo()=="Estado" && pol.getValor()==ped.getEstado()){
            return true;
        }else{return false;}
    }

    public boolean compararLugarEntrega(Politica pol, Pedido ped){
      if(pol.getValor()==ped.getLugarEntrega()){
          //System.out.println("flag = true");
          return true;
      }else{return false;}

    }

    public boolean compararFechaPedido(Politica pol, Pedido ped){
        if((pol.getAtributo()=="Fecha Pedido")&&(pol.getValor() == ped.getFechaPedido())){
            return true;
        }else{return false;}
    }

    public boolean compararFechaMaxEntrega(Politica pol, Pedido ped){
        if((pol.getAtributo()=="Fecha Max Entrega")&&(pol.getValor() == ped.getFechaPedido())){
            return true;
        }else{return false;}
    }

    public boolean comprobarPoliticaPedido(Politica pol, Pedido ped){

        switch(pol.getAtributo()){
            case "Estado" : if(compararEstado(pol,ped)){return true;}else{return false;}
            case "Lugar Entrega" : if(compararLugarEntrega(pol,ped)){return true;}else{return false;}
            case "Fecha Pedido" : if(compararFechaPedido(pol,ped)){return true;}else{return false;}
            case "Fecha Max Entrega" : if(compararFechaMaxEntrega(pol,ped)){return true;}else{return false;}
            default : if(compararMueble(pol,ped)){return true;}else{return false;}
        }
        //System.out.println(flag);
    }

    public Pedido proxPedido(Politica pol){
        boolean flag;
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
        Pedido p = null;
        boolean f;
        if(politica.getClass().getSimpleName()=="PoliticaSimple"){
        p = proxPedido(politica);
        if(p == null){System.out.println("Pedido nulo");}
        else{
        f = pedidos.remove(p);
        if(f==true)System.out.println("Pedido Realizado");
        }
        }else{
            if(politica.getOperacion()=="And") {
                Politica pol;
                boolean flag = false;

                for (int i = 0; i < politica.getListpolitica().size(); i++) {
                    pol = politica.getListpolitica().get(i);
                    if(p == null){
                        p = proxPedido(pol);
                    }
                    flag = comprobarPoliticaPedido(pol, p);
                    if (flag == false) {
                        p.setEstado("Delegar");
                        break;
                    }
                    //System.out.println(i);
                }
                if (flag == true) {
                    f = pedidos.remove(p);
                    if (f == true) System.out.println("Pedido Realizado");
                }

            }else{
                Politica pol;
                boolean flag = false;

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

