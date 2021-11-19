package clases;

import java.util.LinkedList;
import java.util.Random;

public class Pedido {
    private static final int MAX_PRODUCT_NUMBER=26;
    private final LinkedList<Producto> listadoProductos;
    private final int numProductos;

    public Pedido() {
        Random random= new Random();
        this.listadoProductos = new LinkedList<>();
        this.numProductos=random.nextInt(MAX_PRODUCT_NUMBER);
        generarProductos();
    }
    private void generarProductos() {
        for(int i=0; i<this.numProductos; i++) {
            listadoProductos.add(new Producto());
        }
    }
    public LinkedList<Producto> getListadoProductos() {
        return listadoProductos;
    }
}
