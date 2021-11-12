package clases;

import java.util.Random;

public class Producto {
    private final double MAX_HERRAMIENTAS_PRECIO=130;
    private final double MAX_RECAMBIOS_PRECIO=28.90;
    private final double MAX_lIMPIEZA_PRECIO=14.50;
    private final double MIN_HERRAMIENTAS_PRECIO=4.5;
    private final double MIN_RECAMBIOS_PRECIO=2;
    private final double MIN_lIMPIEZA_PRECIO=0.45;
    private double precioUnitario;
    private int cantidad;
    private char tipo;//h=herramienta, r=recmbio, p=producto de limpieza

    public Producto(int cantidad, char tipo) {
        setPrecioUnitario();
        this.cantidad = cantidad;
        this.tipo = tipo;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario() {
        Random random= new Random();
        double preciounitario= random.nextDouble();
        this.precioUnitario = precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }
}
