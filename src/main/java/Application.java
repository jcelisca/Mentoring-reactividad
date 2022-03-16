
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        Factura f = new Factura("FN001","ordenador", 1000,1,LocalDate.of(2021,12,12));
        Factura f2 = new Factura("FN002","movil", 300,2,LocalDate.of(2021,12,20));
        Factura f3 = new Factura("FN003","impresora", 200,3,LocalDate.of(2022,01,02));
        Factura f4 = new Factura("FN004","imac", 1500,1,LocalDate.of(2022,01,15));

        List<Factura> lista = new ArrayList<Factura>();
        lista.add(f);
        lista.add(f2);
        lista.add(f3);
        lista.add(f4);

        Predicate<Factura> predicado = new Predicate<Factura>() {
            @Override
            public boolean test(Factura factura) {
                return factura.getImporte()>300;
            }
        };

        //Filtro que muestra el primer producto con importe mayor a 300
        Factura facturaFiltro = lista.stream().filter(predicado).findFirst().get();
        System.out.println("Factura con importe mayor a 300:\n"+"Factura: "+ facturaFiltro.getCodigoDeFactura()+
                ", importe: "+facturaFiltro.getImporte()+"\n");


        //Filtro que devulve las productos con cantidad mayor a 1
        List<Factura> filtroCantidad = lista.stream()
                .filter(e->e.getCantidadProducto()>1).collect(Collectors.toList());
        System.out.println("Productos con cantidad mayor a 1:");
        filtroCantidad.forEach(System.out::println);

        //Filtro que devuelve la primer fecha mayor a 1 enero de 2022
        Factura fechaMayor = lista.stream()
                .filter(e->e.getDate().isAfter(LocalDate.of(2022,01,01))).findFirst().get();

        System.out.println("\nProducto con fecha mayor a enero 1 de 2022\n"+"Producto: "+fechaMayor.getDescripcion()+", fecha: "+fechaMayor.getDate()+"\n");

        //Filtro que devuelve una factura por medio de su codigo
        Factura filtroPorCodigo = lista.stream()
                .filter(e->e.getCodigoDeFactura()=="FN002").findAny().get();

        System.out.println("Factura con codigo FN002: \n"+filtroPorCodigo);

        //filtro que devuelve una factura por fecha especifica
        Factura fechaExacta = lista.stream()
                .filter(e->e.getDate().isEqual(LocalDate.of(2021,12,12))).findAny().get();

        System.out.println("\nFactura con fecha 2021-12-12:\n"+fechaExacta);

        //filtro que devuelve las productos con cantidad mayor a 3
        List<Factura> cantidadMayor = lista.stream()
                .filter(e->e.cantidadProducto>3).collect(Collectors.toList());
        System.out.println("\nFactura con catidad de productos mayor a 3:");
        System.out.println(cantidadMayor.isEmpty() ? "No hay facturas con cantidad de produstos mayor a 3":
                cantidadMayor);
    }
}
