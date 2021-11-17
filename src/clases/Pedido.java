package clases;

import java.util.LinkedList;
import java.util.Random;

public class Pedido {
    private static final int MAX_PRODUCT_NUMBER=26;
    private LinkedList<Producto> listadoProductos;//o arraylist?
    private int numProductos;

    public Pedido() {
        Random cantidad= new Random();
        this.listadoProductos = new LinkedList<>();
        this.numProductos= cantidad.nextInt(26);
        generarProductos();
    }
    private void generarProductos() {
        for(int i=0; i<numProductos; i++) {
            listadoProductos.add(new Producto());
        }
    }
    public LinkedList<Producto> getListadoProductos() {
        return listadoProductos;
    }
    public void setListadoProductos(LinkedList<Producto> listadoProductos) {
        this.listadoProductos = listadoProductos;
    }
    public Producto getProducto(int position)
    {
        return listadoProductos.get(position);
    }
}
