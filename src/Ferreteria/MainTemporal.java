package Ferreteria;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainTemporal {
    
    public static void main(String[] args) throws SQLException {
        Conexion start = new Conexion();
        start.EstableciendoConexion();
        Metodos run = new Metodos();
        String nom = "";
        int e = 0;
        int opcion = 0;
        Scanner leer =  new Scanner(System.in);
        Scanner numerar = new Scanner(System.in);
        
        String menu = "*FERRETERIA*" + "\n"
                + "1. Adicionar producto" + "\n"
                + "2. Listar todos los productos" + "\n"
                + "3. Buscar producto" + "\n"
                + "4. Eliminar producto" + "\n"
                + "5. Modificar prducto" + "\n"
                + "6. Salir" + "\n"
                + "Opcion: ";
        do {
            System.out.println(menu);
            opcion = numerar.nextInt();

            switch (opcion) {
                case 1:
                    run.agregarProductos();
                    break;
                case 2:
                    run.listarProductos();
                    break;
                case 3:
                    run.consultarProductos();
                    break;
                case 4:
                    run.borrarProductos();
                    break;
                case 5:
                    System.out.println("\nEscoja que desea modificar \n"+"1.Nombre\n"+"2.Precio de compra\n"+"3.Precio de venta \n"+"4.Cantidad del producto\n"+
                            "5.Descripcion de categoria\n"+"6.Todas las anteriores\n");
                    boolean permitir= false;
                    opcion = numerar.nextInt();
                    System.out.println("Ingrese la referencia que desea modificar");
                    String datoo= leer.nextLine();                    
                    ArrayList<String> determinantes = new ArrayList<String>();
                    determinantes = run.consultarReferencia();
                    for(int i = 0; i < determinantes.size(); i++) {
                        if (determinantes.get(i).equals(datoo)) {
                            permitir=true;
                        }};
                        if (permitir) {
                        run.modificarProductos(opcion, datoo);
                    }else {System.out.println("INGRESO UNA REFERENCIA QUE NO EXISTE.\n Intentelo de nuevo");}
                    opcion=1;
                    break;
                case 6:
                    start.cerrandoConexion();
                    break;
                default:
                    System.out.println("Error: escogio una opción inválida");
            }
        } while (opcion != 6);
        
        

     
        }
    
}
