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
        this.cantidad = cantidad;
        this.tipo = tipo;
        setPrecioUnitario();
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitarioO() {
        double maxPrecioTipo=0;
        double minPrecioTipo=0;
        switch(tipo) {
            case 'h'-> {
                maxPrecioTipo = MAX_HERRAMIENTAS_PRECIO;
                minPrecioTipo = MIN_HERRAMIENTAS_PRECIO;
            }
            case 'r'->{
                maxPrecioTipo = MAX_RECAMBIOS_PRECIO;
                minPrecioTipo = MIN_RECAMBIOS_PRECIO;
            }
            case 'p'-> {
                maxPrecioTipo = MAX_lIMPIEZA_PRECIO;
                minPrecioTipo = MIN_lIMPIEZA_PRECIO;
            }
        }
        this.precioUnitario = getPrecioRandom(maxPrecioTipo, minPrecioTipo);
    }
    public void setPrecioUnitario() {
        double precioUnitario=0;
        switch(tipo) {
            case 'h'-> precioUnitario = getPrecioRandom(MAX_HERRAMIENTAS_PRECIO, MIN_HERRAMIENTAS_PRECIO);
            case 'r'-> precioUnitario = getPrecioRandom(MAX_RECAMBIOS_PRECIO, MIN_RECAMBIOS_PRECIO);
            case 'p'-> precioUnitario = getPrecioRandom(MAX_lIMPIEZA_PRECIO, MAX_lIMPIEZA_PRECIO);
        }
        this.precioUnitario = precioUnitario;
    }

    private double getPrecioRandom(double min, double max) {
        Random random= new Random();
        return random.nextDouble(max-min)+min;
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
