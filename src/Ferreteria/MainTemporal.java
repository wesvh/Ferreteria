package Ferreteria;
import java.sql.SQLException;
import java.util.Scanner;

public class MainTemporal {
    
    public static void main(String[] args) throws SQLException {
        Conexion exec = new Conexion();
        exec.EstableciendoConexion();
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
                    exec.agregarProductos();
                    break;
                case 2:
                    exec.consultarProductos();
                    break;
                case 3:
                    exec.consultarProductos();
                    break;
                case 4:
                    exec.borrarProductos();
                    break;
                case 5:
                    exec.modificarProductos();
                    break;
                case 6:
                    exec.cerrandoConexion();
                    break;
                default:
                    System.out.println("Error: escogio una opción inválida");
            }
        } while (opcion != 6);
        exec.agregarProductos();
        exec.modificarProductos();
        exec.consultarProductos();
        exec.borrarProductos();

     
        }
    
}
