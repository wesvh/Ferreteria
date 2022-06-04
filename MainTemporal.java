import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainTemporal {
    
    public static void main(String[] args) throws SQLException {
        //Se agregan las credenciales y link de acceso a la base de datos
        String dbURL= "jdbc:mysql://localhost:3306/ferreteria"; //luego de localhost:3306/  se agrega el nombre del schema 
        String username = "root"; //credenciales
        String password = "root";
        Connection conn= null; //se inicializa la variable que comprueba conexion
        try{
        conn= DriverManager.getConnection(dbURL,username,password); //conecta
        if (conn!=null) {
            System.out.println("Conectado");  //Si no es null nos devuelve el mensaje
        }
    } catch(SQLException ex){
        ex.printStackTrace();}
        //Se inicializa la variable que contendra el script de INSERT   
        String sql = "INSERT INTO  productos (nombre,referencia,valor_compra,valor_venta,cantidad,categoria) VALUES (?,?,?,?,?,?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        //Se reemplaza cada ? , en orden siendo (x,valor) x el numero del ? a reemplazar por "valor"
        statement.setString(1 , "PRUEBA DE CONEXION"); 
        statement.setString(2 , "R0003");
        statement.setInt(3 , 1000);
        statement.setInt(4 , 2500);
        statement.setInt(5 , 50);
        statement.setString(6 , "PVC");
        int rowsInserted = statement.executeUpdate(); //ejecuta el script de SQL
        if ( rowsInserted > 0) {
        System.out.println (" Insercion exitosa !"); //Devuelve esto si se logro hacer la insercion
               
    }}}
