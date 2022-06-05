package Ferreteria;
import java.sql.SQLException;
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
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    run.agregarProductos();
                    break;
                case 2:
                    run.consultarProductos();
                    break;
                case 3:
                    run.consultarProductos();
                    break;
                case 4:
                    run.borrarProductos();
                    break;
                case 5:
                    run.modificarProductos();
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
