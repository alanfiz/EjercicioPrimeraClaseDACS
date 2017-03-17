import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by alan on 13-Mar-17.
 */
public abstract class Politica {

    //atributos de politica//
    private String nombrePolitica;

    public String getNombrePolitica() {
        return nombrePolitica;
    }

    public void setNombrePolitica(String nombrePolitica) {
        this.nombrePolitica = nombrePolitica;
    }

    public String getAtributo(){return null;}
    public void setAtributo(String a){}
    public Object getValor(){return null;}
    public void setValor(Object v){}
    public void borrarPolitica(Politica p){}
    public void agregarPolitica(Politica p){}
    public ArrayList<Politica> getListpolitica(){return null;}
    public void setListpolitica(ArrayList<Politica> listpolitica){}
    public void setOperacion(String operacion){}
    public String getOperacion(){return null;}
}
