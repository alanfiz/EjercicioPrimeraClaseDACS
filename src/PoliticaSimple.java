import java.util.Date;

/**
 * Created by alan on 15-Mar-17.
 */
public class PoliticaSimple extends Politica {

    private String atributo;
    private Object valor;

    public PoliticaSimple(String a, Object v){
        this.atributo = a;
        this.valor = v;
    }

    @Override
    public String getAtributo() {
        return atributo;
    }

    @Override
    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }

    @Override
    public Object getValor() {
        return valor;
    }

    @Override
    public void setValor(Object valor) {
        this.valor = valor;
    }


}

