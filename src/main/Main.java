package main;

import clases.Pedido;
import hilos.GestorPedidos;

import java.util.LinkedList;

public class Main {

    public static final int NUM_PEDIDOS = 100000;
    public static final int NUM_HILOS=Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        LinkedList<Pedido> listadoDePedidos= new LinkedList<>();
        for (int i = 0; i< NUM_PEDIDOS; i++) {
            listadoDePedidos.add(new Pedido());
        }
        LinkedList<Thread> hilos= new LinkedList<>();
        for (int i = 0; i< NUM_HILOS; i++) {
            hilos.add(new Thread(new GestorPedidos(listadoDePedidos.get(i).getListadoProductos())));
        }
        for (Thread t:hilos) {
            t.start();
        }

    }
}
