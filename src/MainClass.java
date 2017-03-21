import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pablord on 17/03/17.
 */
public class MainClass {

    public static void main(String[] args){

        //Politica compuesta
        Politica pol1 = new PoliticaSimple("Color", "Negro");
        Politica pol2 = new PoliticaSimple("Lugar Entrega","Resistencia");
        ArrayList<Politica> listpoliticas1 = new ArrayList<>();
        listpoliticas1.add(pol1);
        listpoliticas1.add(pol2);
        Politica pc1 = new PoliticaCompuesta(listpoliticas1, "And");

        //Lista de muebles
        Map<String,String> att1 = new HashMap<>();
        att1.put("Nombre","Silla");
        att1.put("Color", "Negro");
        att1.put("Material","Pino");

        Map<String,String> att2 = new HashMap<>();
        att2.put("Nombre","Mesa");
        att2.put("Color", "Blanco");
        att2.put("Material","Roble");
        Mueble m1 = new Mueble(att1);
        Mueble m2 = new Mueble(att2);

        ArrayList<Mueble> muebles1 = new ArrayList<>();
        muebles1.add(m1);
        muebles1.add(m2);


        Pedido p1 = new Pedido(new Date(2017,2,17), new Date(2017,3,17),
                "Resistencia", "Incompleto",muebles1);

        ArrayList<Pedido> listPedidos1 = new ArrayList<>();
        listPedidos1.add(p1);

        ArrayList<Fabrica> listFabrica1 = new ArrayList<>();
        Fabrica fabrica1 = new Fabrica("Fabrica1", listPedidos1, pc1, listFabrica1, true  );

        System.out.println(fabrica1.getPedidos().size());
        fabrica1.atenderPedido();
        System.out.println(fabrica1.getPedidos().size());
//        System.out.println(fabrica1.getPedidos().get(0).getEstado());
        /*
        Politica pol1 = new PoliticaSimple("Color", "Negro");
        Politica pol2 = new PoliticaSimple("Lugar Entrega","Barranqueras");//"Fecha Pedido", new Date(2017,2,19)
        Politica pol3 = new PoliticaSimple("Lugar Entrega","Fontana");
        Politica pol4 = new PoliticaSimple("Material", "Roble");

        ArrayList<Politica> listpoliticas1 = new ArrayList<>();
        listpoliticas1.add(pol1);
        listpoliticas1.add(pol2);
        Politica pc1 = new PoliticaCompuesta(listpoliticas1, "And");

        ArrayList<Politica> listpoliticas2 = new ArrayList<>();
        listpoliticas2.add(pol3);
        listpoliticas2.add(pol4);
        Politica pc2 = new PoliticaCompuesta(listpoliticas2,"And");

        ArrayList<Politica> listpoliticas3 = new ArrayList<>();
        listpoliticas3.add(pol2);
        listpoliticas3.add(pol4);
        Politica pc3 = new PoliticaCompuesta(listpoliticas3,"And");

        Map<String,String> att1 = new HashMap<>();
        att1.put("Nombre","Silla");
        att1.put("Color", "Negro");
        att1.put("Material","Pino");

        Map<String,String> att2 = new HashMap<>();
        att1.put("Nombre","Mesa");
        att1.put("Color", "Blanco");
        att1.put("Material","Roble");

        Map<String,String> att3 = new HashMap<>();
        att1.put("Nombre","Ropero");
        att1.put("Color", "Marron");
        att1.put("Material","Pino");

        Map<String,String> att4 = new HashMap<>();
        att1.put("Nombre","Ropero");
        att1.put("Color", "Blanco");
        att1.put("Material","Roble");

        Map<String,String> att5 = new HashMap<>();
        att1.put("Nombre","Silla");
        att1.put("Color", "Blanco");
        att1.put("Material","Pino");

        Map<String,String> att6 = new HashMap<>();
        att1.put("Nombre","Mesa");
        att1.put("Color", "Gris");
        att1.put("Material","Pino");

        Map<String,String> att7 = new HashMap<>();
        att1.put("Nombre","Puerta");
        att1.put("Color", "Negro");
        att1.put("Material","Roble");

        Map<String,String> att8 = new HashMap<>();
        att1.put("Nombre","Ventana");
        att1.put("Color", "Gris");
        att1.put("Material","Roble");

        Map<String,String> att9 = new HashMap<>();
        att1.put("Nombre","Mesa de luz");
        att1.put("Color", "Blanco");
        att1.put("Material","Pino");

        Map<String,String> att10 = new HashMap<>();
        att1.put("Nombre","Mesa de luz");
        att1.put("Color", "Negro");
        att1.put("Material","Pino");

        Map<String,String> att11 = new HashMap<>();
        att1.put("Nombre","Ventana");
        att1.put("Color", "Negro");
        att1.put("Material","Pino");


        Mueble m1 = new Mueble(att1);
        Mueble m2 = new Mueble(att2);
        Mueble m3 = new Mueble(att3);
        Mueble m4 = new Mueble(att4);
        Mueble m5 = new Mueble(att5);
        Mueble m6 = new Mueble(att6);
        Mueble m7 = new Mueble(att7);
        Mueble m8 = new Mueble(att8);
        Mueble m9 = new Mueble(att9);
        Mueble m10 = new Mueble(att10);
        Mueble m11 = new Mueble(att11);

        ArrayList<Mueble> muebles1 = new ArrayList<>();
        muebles1.add(m1);
        muebles1.add(m2);
        muebles1.add(m3);

        ArrayList<Mueble> muebles2 = new ArrayList<>();
        muebles2.add(m4);
        muebles2.add(m7);

        ArrayList<Mueble> muebles3 = new ArrayList<>();
        muebles3.add(m7);
        muebles3.add(m8);
        muebles3.add(m9);

        ArrayList<Mueble> muebles4 = new ArrayList<>();
        muebles4.add(m10);
        muebles4.add(m11);
        muebles4.add(m1);

        ArrayList<Mueble> muebles5 = new ArrayList<>();
        muebles5.add(m2);
        muebles5.add(m4);
        muebles5.add(m6);

        Pedido p1 = new Pedido(new Date(2017,2,17), new Date(2017,3,17),
                "Resistencia", "Incompleto",muebles1);
        Pedido p2 = new Pedido(new Date(2017,2,18), new Date(2017,3,18),
                "Barranqueras", "Incompleto",muebles2);
        Pedido p3 = new Pedido(new Date(2017,2,19), new Date(2017,3,19),
                "Tirol", "Incompleto",muebles3);
        Pedido p4 = new Pedido(new Date(2017,2,20), new Date(2017,3,20),
                "Vilelas", "Incompleto",muebles4);
        Pedido p5 = new Pedido(new Date(2017,2,21), new Date(2017,3,21),
                "Fontana", "Incompleto",muebles5);

        ArrayList<Pedido> listPedidos1 = new ArrayList<>();
        listPedidos1.add(p1);
        listPedidos1.add(p2);
        listPedidos1.add(p3);
        listPedidos1.add(p4);
        listPedidos1.add(p5);

        ArrayList<Pedido> listPedidos2 = new ArrayList<>();
        listPedidos2.add(p1);
        listPedidos2.add(p3);
        listPedidos2.add(p5);

        ArrayList<Pedido> listPedidos3 = new ArrayList<>();
        listPedidos3.add(p2);
        listPedidos3.add(p4);

        ArrayList<Pedido> listPedidos4 = new ArrayList<>();
        listPedidos4.add(p1);
        listPedidos4.add(p2);
        listPedidos4.add(p4);
        listPedidos4.add(p5);


        ArrayList<Fabrica> listFabrica1 = new ArrayList<>();
        ArrayList<Fabrica> listFabrica2 = new ArrayList<>();
        ArrayList<Fabrica> listFabrica3 = new ArrayList<>();
        ArrayList<Fabrica> listFabrica4 = new ArrayList<>();

        Fabrica fabrica1 = new Fabrica("Fabrica1", listPedidos1, pc1, listFabrica1, true  );
        Fabrica fabrica2 = new Fabrica("Fabrica2", listPedidos2, pc2, listFabrica2, true );
        Fabrica fabrica3 = new Fabrica("Fabrica3", listPedidos3, pc3, listFabrica3, false );
        Fabrica fabrica4 = new Fabrica("Fabrica4", listPedidos4, pol1, listFabrica4, false );


        listFabrica1.add(fabrica2);
        listFabrica1.add(fabrica3);
        listFabrica1.add(fabrica4);

        listFabrica2.add(fabrica1);
        listFabrica2.add(fabrica3);
        listFabrica2.add(fabrica4);

        listFabrica3.add(fabrica1);
        listFabrica3.add(fabrica2);
        listFabrica3.add(fabrica4);

        listFabrica4.add(fabrica1);
        listFabrica4.add(fabrica2);
        listFabrica4.add(fabrica3);

        System.out.println(fabrica2.getPedidos().size());
        fabrica2.atenderPedido();
        System.out.println(fabrica2.getPedidos().size());
        */
    }
}
