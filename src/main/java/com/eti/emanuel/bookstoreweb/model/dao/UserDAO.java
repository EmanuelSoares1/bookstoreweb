/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eti.emanuel.bookstoreweb.model.dao;

import com.eti.emanuel.bookstoreweb.model.bean.User;
import connection.MySQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author devsys-a
 */
public class UserDAO {
    
    private static final String SQL_INSERT = "INSERT INTO user (fullname, "
            + "email, password) "
            + "VALUES ( ?, ?, ?)";
    
    private static final String SQL_SELECT_ALL = "SELECT * FROM user";
    private static final String SQL_SELECT_ID = "SELECT * FROM user "
            + "WHERE id = ?";
    
    private static final String SQL_UPDATE = "UPDATE user SET id = ?,"
            + "fullname = ?, email = ?, password = ?";
    
    private static final String SQL_DELETE = "DELETE FROM user WHERE id = ?";  
    private static final String SQL_SELECT_FULLNAME = "SELECT fullname FROM user"
            + " WHERE email = ? AND password = ?";
    
    /**
     * Insere um usuario na base de dados Produto
     * @param u
     */
    public void create(User u){
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement stmt = null;
        
        try {
                stmt = conn.prepareStatement(SQL_INSERT);
                stmt.setString(1, u.getFullName());
                stmt.setString(2, u.getEmail());
                stmt.setString(3, u.getPassword());
                 //Executa a Querb
                int auxRetorno = stmt.executeUpdate();
                 
                Logger.getLogger(UserDAO.class.getName()).log(Level.INFO, null,
                         "Inclusao: " + auxRetorno);
        }catch (SQLException sQLException){
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null,
                    sQLException);
            
        } finally {
            // Encerra a conexão com o banco e o statemnt.
            MySQLConnection.closeConnection(conn, stmt);
        }
    }
    /**
     * Retorna todos os requisitos da tabela produto
     * @return
     */
    
    
    public List<User> getResults(){
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User u = null;
        List<User> listaUser = null;
    
        try {
            // Prepara a string de SELECT e executa em Produtos
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            rs = stmt.executeQuery();
            
            // Carrega a string de SELECT e executa a query.
            // adiciona na lista de retorno.
            listaUser = new ArrayList<>();
        
            while (rs.next()){
                u = new User();
                u.setId(rs.getInt("id"));
                u.setFullName(rs.getString("fullname"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                listaUser.add(u);
            
            }
        } catch (SQLException ex){
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaUser;
    }
    /**
     * Retorna um produto na tabela produto.
     * @param id Identificação do Produto
     * @return
     */
    public User getResultById(int id){
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User u = null;
        
        try {
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            if(rs.next()) {
                u = new User();
                u.setId(rs.getInt("id"));
                u.setFullName(rs.getString("fullName"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("passaword"));
                                             
            }
        }catch (SQLException sQLException){
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null,
                    sQLException);
        } finally {
            // Encerra a conexão com o banco e o statement.
            MySQLConnection.closeConnection(conn, stmt, rs);
        }
        return u;
    }
    /**
     * 
     * @param u
     * 
     */
    public void update(User u) {
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, u.getId());
            stmt.setString(2, u.getFullName());
            stmt.setString(3, u.getEmail());
            stmt.setString(4, u.getPassword());
                        
            /// Executa a query
            int auxRetorno = stmt.executeUpdate();
            
            Logger.getLogger(UserDAO.class.getName()).log(Level.INFO, null, "Update: " + auxRetorno);
            
        }catch(SQLException sQLException){
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null,
                    sQLException);
            
        }finally {
            // Encerra a conexão com o banco e o statement.
            MySQLConnection.closeConnection(conn, stmt);
        }   
    }
    /**
     * 
     * @param id 
     */
    
    public void delete(int id){
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id);
            
            // Executa a query 
            int auxRetorno = stmt.executeUpdate();
            
            Logger.getLogger(UserDAO.class.getName()).log(Level.INFO, null, 
                    "Delete: " + auxRetorno);
        
            
        } catch (SQLException sQLException){
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, 
                    sQLException);
            
        }finally{
            // Encerra a conexão com o bamco e o statement.
            MySQLConnection.closeConnection(conn, stmt);
        }
        
    }
    ///método que usa o select para varrer o banco e devolver um User se caso ter o dado no banco
    public User checkLogin(String email, String passaword){
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User u = null;
        
        try {
            stmt = conn.prepareStatement(SQL_SELECT_FULLNAME);
            stmt.setString(1, email);
            stmt.setString(2, passaword);
            rs = stmt.executeQuery();
        
            if (rs.next()) {
            
                u = new User();
                u.setFullName(rs.getString("email"));
                u.setEmail(rs.getString("email"));
            }
        }catch(SQLException sQLException){
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, sQLException);
        } finally {
            MySQLConnection.closeConnection(conn, stmt);
        }
        
        return u;
    }
    
}
    

