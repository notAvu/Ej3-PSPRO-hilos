package hilos;

public class DatosGeneral {
    private static double preciototalHerramientas;
    private static double preciototalRepuestos;
    private static double preciototalProductosLimpieza;
    private static int herramientasVendidas;
    private static int repuestosVendidos;
    private static int productosLimpezaVendidos;
    private static int pedidos;

    public static double getPreciototalHerramientas() {
        return preciototalHerramientas;
    }

    public static void setPreciototalHerramientas(double preciototalHerramientas) {
        DatosGeneral.preciototalHerramientas = preciototalHerramientas;
    }

    public static double getPreciototalRepuestos() {
        return preciototalRepuestos;
    }

    public static void setPreciototalRepuestos(double preciototalRepuestos) {
        DatosGeneral.preciototalRepuestos = preciototalRepuestos;
    }

    public static double getPreciototalProductosLimpieza() {
        return preciototalProductosLimpieza;
    }

    public static void setPreciototalProductosLimpieza(double preciototalProductosLimpieza) {
        DatosGeneral.preciototalProductosLimpieza = preciototalProductosLimpieza;
    }

    public static int getHerramientasVendidas() {
        return herramientasVendidas;
    }

    public static void setHerramientasVendidas(int herramientasVendidas) {
        DatosGeneral.herramientasVendidas = herramientasVendidas;
    }

    public static int getRepuestosVendidos() {
        return repuestosVendidos;
    }

    public static void setRepuestosVendidos(int repuestosVendidos) {
        DatosGeneral.repuestosVendidos = repuestosVendidos;
    }

    public static int getProductosLimpezaVendidos() {
        return productosLimpezaVendidos;
    }

    public static void setProductosLimpezaVendidos(int productosLimpezaVendidos) {
        DatosGeneral.productosLimpezaVendidos = productosLimpezaVendidos;
    }

    public static int getPedidos() {
        return pedidos;
    }

    public static void setPedidos(int pedidos) {
        DatosGeneral.pedidos = pedidos;
    }
}
