package Ferreteria;
import java.sql.SQLException;

public class MainTemporal {
    
    public static void main(String[] args) throws SQLException {
        Conexion exec = new Conexion();
        exec.EstableciendoConexion();
        exec.agregarProductos();
        exec.modificarProductos();
        exec.consultarProductos();
        exec.borrarProductos();

     
        }}