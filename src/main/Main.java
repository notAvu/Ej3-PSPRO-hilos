package main;

import clases.Pedido;
import hilos.DatosGeneral;
import hilos.GestorPedidos;

import java.util.LinkedList;

public class Main {
    public static final int NUM_PEDIDOS = 100000;
    public static final int NUM_HILOS=Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        LinkedList<Pedido> listadoDePedidos= new LinkedList<>();
        LinkedList<GestorPedidos> gestores= new LinkedList<>();
        LinkedList<Thread> threadList= new LinkedList<>();
        for (int i = 0; i< NUM_PEDIDOS; i++) {
            listadoDePedidos.add(new Pedido());
        }
        DatosGeneral.setPedidos(listadoDePedidos.size());
        asignarPedidos(listadoDePedidos, gestores);
        for (GestorPedidos g: gestores) {
            threadList.add(new Thread (g));
        }
        for (Thread t:threadList) {
            t.start();
        }
        //TODO Esperar a que los hilos acaben
        System.out.println("Herramientas: \nprecio total:"+ DatosGeneral.getPreciototalHerramientas() +"\ncantidadVendida: "+ DatosGeneral.getHerramientasVendidas());
        System.out.println("Repuestos: \nprecio total:"+ DatosGeneral.getPreciototalRepuestos() +"\ncantidadVendida: "+ DatosGeneral.getRepuestosVendidos() +"\n");
        System.out.println("Productos de limpieza: \nprecio total:"+ DatosGeneral.getPreciototalProductosLimpieza() +"\ncantidadVendida: "+ DatosGeneral.getProductosLimpezaVendidos() +"\n");
    }

    private static void asignarPedidos(LinkedList<Pedido> listadoDePedidos, LinkedList<GestorPedidos> gestores) {
        for (int i = 0; i< NUM_HILOS; i++) {
            gestores.add(new GestorPedidos());
            for (int j=0; j<NUM_PEDIDOS/NUM_HILOS; j++) {
                gestores.get(i).agregarPedido(listadoDePedidos.get(j));
                DatosGeneral.setPedidos(DatosGeneral.getPedidos()-1);
            }
        }
        while(DatosGeneral.getPedidos()>0){
            gestores.getFirst().agregarPedido(listadoDePedidos.get(DatosGeneral.getPedidos()-1));
            DatosGeneral.setPedidos(DatosGeneral.getPedidos()-1);
        }
    }
}
