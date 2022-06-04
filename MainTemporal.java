import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainTemporal {
    
    public static void main(String[] args) throws SQLException {
        String dbURL= "jdbc:mysql://localhost:3306/ferreteria";
        String username = "root";
        String password = "root";
        Connection conn= null;
        try{
        conn= DriverManager.getConnection(dbURL,username,password);
        if (conn!=null) {
            System.out.println("Conectado");            
        }
    } catch(SQLException ex){
        ex.printStackTrace();}
      
        
        String sql = "INSERT INTO  productos (nombre,referencia,valor_compra,valor_venta,cantidad,categoria) VALUES (?,?,?,?,?,?)";
        PreparedStatement statement = conn.prepareStatement(sql);

statement.setString(1 , "PRUEBA DE CONEXION");
statement.setString(2 , "R0003");
statement.setInt(3 , 1000);
statement.setInt(4 , 2500);
statement.setInt(5 , 50);
statement.setString(6 , "PVC");
int rowsInserted = statement.executeUpdate();
if ( rowsInserted > 0) {
System.out.println (" Insercion exitosa !");
               
    }}}
