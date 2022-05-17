package connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;/*Função level*/
import java.util.logging.Logger;/*função logger*/


/**
 * Gerencia a conexão com o banco de dados. Possuias informações neccessários para conhecer ao banco
 */


public class MySQLConnection {
    ///Variavaen do tipo final MAIÚSCULA
    //Define String de conexao com o banco.
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://172.16.0.30:3306/eeos_bookstore";
    
    private static final String USER = "emanuel";
    private static final String PASS = "21262799";
/**
 * Cria conexão com o banco de dados MySQL
 * @return
 */
        
    public static Connection getConnection(){
        try {///Abaixo há uma tentativa de encontrar o banco de dados.
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
         } catch (SQLException ex) {
            Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro na Conexão com o BD. Verifique!", ex);
        } catch(ClassNotFoundException ex){
            Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro na carga do Driver. verifique!", ex);
            
        }
    }
/**
 * Fecha a conexão com o BD
 *@param conn Connection a ser fechada.
 */
    public static void closeConnection(Connection conn){
        
        try {
            if (conn != null){
                conn.close();
            }
            
        } catch(SQLException ex){
            Logger.getLogger(
                    MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    /***@param conn Conexão
     * @param stmt statement
    */
    
    public static void closeConnection(Connection conn, PreparedStatement stmt){
    
        try {
            if(stmt != null){
                stmt.close();
            }
        } catch (SQLException ex){
            Logger.getLogger(
                    MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void closeConnection(Connection conn, PreparedStatement stmt, ResultSet rs){
    
        try {
            if(stmt != null){
                stmt.close();
            }
        } catch (SQLException ex){
            Logger.getLogger(
                    MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}