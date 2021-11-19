package hilos;

import clases.Pedido;
import clases.Producto;

import java.util.LinkedList;

public class GestorPedidos implements Runnable{
    double preciototalHerramientas;
    double preciototalRepuestos;
    double preciototalProductosLimpieza;
    int herramientasVendidas;
    int repuestosVendidos;
    int productosLimpezaVendidos;
    LinkedList<Producto> pedido;

    public GestorPedidos(LinkedList<Producto> pedido) {
        this.preciototalHerramientas = 0;
        this.preciototalRepuestos = 0;
        this.preciototalProductosLimpieza = 0;
        this.herramientasVendidas = 0;
        this.repuestosVendidos = 0;
        this.productosLimpezaVendidos = 0;
        this.pedido = pedido;
    }
    @Override
    public void run() {
        for (Producto p: pedido) {
            switch (p.getTipo()) {
                case 'h'-> calculoHerramientas(p);
                case 'r'-> calculoRepuestos(p);
                case 'p'->calculoProductoLimpieza(p);
            }
        }
        System.out.println("Calculos terminados: ");
    }
    private void calculoProductoLimpieza(Producto p) {
        productosLimpezaVendidos+=p.getCantidad();
        preciototalProductosLimpieza+=p.getPrecioUnitario()* p.getCantidad();
    }
    private void calculoRepuestos(Producto p) {
        repuestosVendidos+=p.getCantidad();
        preciototalRepuestos+=p.getPrecioUnitario()* p.getCantidad();
    }
    private void calculoHerramientas(Producto p) {
        herramientasVendidas+= p.getCantidad();
        preciototalHerramientas += p.getPrecioUnitario()* p.getCantidad();
    }
}
