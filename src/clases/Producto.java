package clases;

import java.util.Random;

public class Producto {
    private static final double MAX_HERRAMIENTAS_PRECIO=130;
    private static final double MAX_RECAMBIOS_PRECIO=28.90;
    private static final double MAX_lIMPIEZA_PRECIO=14.50;
    private static final double MIN_HERRAMIENTAS_PRECIO=4.5;
    private static final double MIN_RECAMBIOS_PRECIO=2;
    private static final double MIN_lIMPIEZA_PRECIO=0.45;
    private static final int MIN_UDS=1;
    private static final int MAX_UDS=50;
    private double precioUnitario;
    private int cantidad;
    private final char tipo;//h=herramienta, r=recmbio, p=producto de limpieza

    public Producto() {
        Random getCantidad= new Random();
        this.cantidad =getCantidad.nextInt(50)+1;
        this.tipo = getTipoRandom();
        setPrecioUnitario();
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }
    public void setPrecioUnitario() {
        double precioUnitario=0;
        switch(tipo) {
            case 'h'-> precioUnitario = getPrecioRandom(MIN_HERRAMIENTAS_PRECIO,MAX_HERRAMIENTAS_PRECIO);
            case 'r'-> precioUnitario = getPrecioRandom(MIN_RECAMBIOS_PRECIO,MAX_RECAMBIOS_PRECIO);
            case 'p'-> precioUnitario = getPrecioRandom(MIN_lIMPIEZA_PRECIO,MAX_lIMPIEZA_PRECIO);
        }
        this.precioUnitario = precioUnitario;
    }

    private double getPrecioRandom(double min, double max) {
        Random random= new Random();
        return random.nextDouble(max-min)+min;
    }
    private char getTipoRandom() {
        char tipo='r';
        Random random= new Random();
        switch (random.nextInt(2)) {
            case 0->tipo='h';
            case 1->tipo='p';
        }
        return  tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getCantidadRandom() {
        Random random= new Random();
        return random.nextInt(MAX_UDS-MIN_UDS)+MAX_UDS;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = getCantidadRandom();
    }

    public char getTipo() {
        return tipo;
    }
}
