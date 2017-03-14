import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by pablord on 14/03/17.
 */
public class main {
    public static void main(String[] args) {

        //crear map
        Map<String, String> m = new HashMap<String, String>();
        m.put("Color","Rojo");
        m.put("Material","Pino");

        Mueble mueble = new Mueble(m);
        System.out.println(mueble);
    }
}
