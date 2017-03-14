import java.util.Map;

/**
 * Created by alan on 13-Mar-17.
 */
public class Mueble {

    private Map<String,String> atributos;

    public Map getAtributos() {
        return atributos;
    }

    public void setAtributos(Map atributos) {
        this.atributos = atributos;
    }

    //Hay que crear un map y pasarlo a constructor para crear el objeto
    public Mueble(Map<String, String> atributos) {
        this.atributos = atributos;
    }

    public Mueble() {
    }

    @Override
    public String toString() {
        return "Mueble{" +
                "atributos=" + atributos +
                '}';
    }
}
