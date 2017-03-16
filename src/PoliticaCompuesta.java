import java.util.List;

/**
 * Created by alan on 15-Mar-17.
 */
public class PoliticaCompuesta extends Politica {
    private List<Politica> listpolitica;

    public void borrarPolitica(Politica p){
        listpolitica.remove(p);
    }

    public void agregarPolitica(Politica p){
        listpolitica.add(p);
    }

    public PoliticaCompuesta(List<Politica> listpolitica) {
        this.listpolitica = listpolitica;
    }

    public List<Politica> getListpolitica() {
        return listpolitica;
    }

    public void setListpolitica(List<Politica> listpolitica) {
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
