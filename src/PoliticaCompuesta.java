import java.util.ArrayList;

/**
 * Created by alan on 15-Mar-17.
 */
public class PoliticaCompuesta extends Politica {
    private ArrayList<Politica> listpolitica;
    private String operacion;

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    @Override
    public void borrarPolitica(Politica p){
        listpolitica.remove(p);
    }

    @Override
    public void agregarPolitica(Politica p){
        listpolitica.add(p);
    }

    public PoliticaCompuesta(ArrayList<Politica> listpolitica, String operacion) {
        this.listpolitica = listpolitica;
        this.operacion = operacion;
    }

    @Override
    public ArrayList<Politica> getListpolitica() {
        return listpolitica;
    }

    @Override
    public void setListpolitica(ArrayList<Politica> listpolitica) {
        this.listpolitica = listpolitica;
    }

    @Override
    public String toString() {
        return "PoliticaCompuesta{" +
                "nombre='" + getNombrePolitica() + '\'' +
                ", listpolitica=" + listpolitica +
                '}';
    }
}
