package proyecto;

public class ClaseDetalle {

    String idDetalle;
    String Venta;
    String idJuego;
    String NombreJuego;
    int Cantidad;
    int Subtotal;

    public String getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(String idDetalle) {
        this.idDetalle = idDetalle;
    }

    public String getVenta() {
        return Venta;
    }

    public void setVenta(String Venta) {
        this.Venta = Venta;
    }

    public String getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(String Juego) {
        this.idJuego = Juego;
    }

    public String getNombreJuego() {
        return NombreJuego;
    }

    public void setNombreJuego(String NombreJuego) {
        this.NombreJuego = NombreJuego;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public int getSubtotal() {
        return Subtotal;
    }

    public void setSubtotal(int Subtotal) {
        this.Subtotal = Subtotal;
    }

}
