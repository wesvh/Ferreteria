package Ferreteria;
import java.sql.SQLException;
import java.util.Scanner;
//AUTORES : Esteban Villada Henao, Cristian Roa y Giovany Andrés Molina
public class MainTemporal {
    
    public static void main(String[] args) throws SQLException {
        Conexion start = new Conexion();
        start.EstableciendoConexion();
        Metodos run = new Metodos();        
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
                    if (run.permitirConsultar()) {
                        run.consultarProductos();
                    }
                    break;
                case 4:
                    run.borrarProductos();
                    break;
                case 5:
                    if (run.permitirConsultar()) {
                        run.modificarProductos();}
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
