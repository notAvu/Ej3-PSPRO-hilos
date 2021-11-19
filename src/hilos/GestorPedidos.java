package hilos;

import clases.Pedido;
import clases.Producto;

import java.util.LinkedList;

public class GestorPedidos implements Runnable{
    private final LinkedList<Pedido> pendientes;
    double preciototalHerramientas;
    double preciototalRepuestos;
    double preciototalProductosLimpieza;
    int herramientasVendidas;
    int repuestosVendidos;
    int productosLimpezaVendidos;
    LinkedList<Producto> pedido;

    public GestorPedidos() {
        this.preciototalHerramientas = 0;
        this.preciototalRepuestos = 0;
        this.preciototalProductosLimpieza = 0;
        this.herramientasVendidas = 0;
        this.repuestosVendidos = 0;
        this.productosLimpezaVendidos = 0;
        pendientes = new LinkedList<>();
    }

    private void asignarNuevoPedido() {
        if(pendientes.getFirst()!=null) {
            this.pedido = pendientes.getFirst().getListadoProductos();
            pendientes.remove(pendientes.getFirst());
        }
    }
    @Override
    public void run() {
        while(pendientes.getFirst()!=null){
        asignarNuevoPedido();
        procesarPedido();
        }
        printInfoHerramientas();
        printInfoRecambios();
        printInfoLimpieza();
    }

    private void printInfoHerramientas() {
        System.out.println("Herramientas: \nprecio total:"+ preciototalHerramientas+"\ncantidadVendida: "+herramientasVendidas+"\n");
    }
    private void printInfoRecambios() {
        System.out.println("Repuestos: \nprecio total:"+ preciototalRepuestos+"\ncantidadVendida: "+repuestosVendidos+"\n");
    }
    private void printInfoLimpieza() {
        System.out.println("Productos de limpieza: \nprecio total:"+ preciototalProductosLimpieza+"\ncantidadVendida: "+productosLimpezaVendidos+"\n");
    }

    private void procesarPedido() {
        for (Producto p: pedido) {
            switch (p.getTipo()) {
                case 'h'-> calculoHerramientas(p);
                case 'r'-> calculoRepuestos(p);
                case 'p'->calculoProductoLimpieza(p);
            }
        }
        pedido=pendientes.getFirst().getListadoProductos();
    }

    private void calculoProductoLimpieza(Producto p) {
        productosLimpezaVendidos+=p.getCantidad();
        preciototalProductosLimpieza+=p.getPrecioUnitario()* p.getCantidad();
        DatosGeneral.setProductosLimpezaVendidos(DatosGeneral.getProductosLimpezaVendidos()+ p.getCantidad());
        DatosGeneral.setPreciototalProductosLimpieza(DatosGeneral.getPreciototalProductosLimpieza() + p.getPrecioUnitario()* p.getCantidad());
    }
    private void calculoRepuestos(Producto p) {
        repuestosVendidos+=p.getCantidad();
        preciototalRepuestos+=p.getPrecioUnitario()* p.getCantidad();
        DatosGeneral.setRepuestosVendidos(DatosGeneral.getRepuestosVendidos()+ p.getCantidad());
        DatosGeneral.setPreciototalRepuestos(DatosGeneral.getPreciototalRepuestos() + p.getPrecioUnitario()* p.getCantidad());
    }
    private void calculoHerramientas(Producto p) {
        herramientasVendidas+= p.getCantidad();
        preciototalHerramientas += p.getPrecioUnitario()* p.getCantidad();
        DatosGeneral.setHerramientasVendidas(DatosGeneral.getHerramientasVendidas()+ p.getCantidad());
        DatosGeneral.setPreciototalHerramientas(DatosGeneral.getPreciototalHerramientas() + p.getPrecioUnitario()* p.getCantidad());
    }
    public void agregarPedido(Pedido pedido) {
        pendientes.add(pedido);
    }
}
