import java.time.LocalDate;

public class Factura {
    String codigoDeFactura;
    String descripcion;
    int importe;
    int cantidadProducto;
    LocalDate date;

    public Factura(String codigoDeFactura, String descripcion, int importe, int cantidadProducto, LocalDate date) {
        this.codigoDeFactura = codigoDeFactura;
        this.descripcion = descripcion;
        this.importe = importe;
        this.cantidadProducto = cantidadProducto;
        this.date = date;
    }

    public String getCodigoDeFactura() {
        return codigoDeFactura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getImporte() {
        return importe;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "codigoDeFactura='" + codigoDeFactura + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", importe=" + importe +
                ", cantidadProducto=" + cantidadProducto +
                ", date=" + date +
                '}';
    }
}
