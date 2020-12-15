/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.empresaM;

/**
 *
 * @author Bruno
 */
public class empresaDAO {
    
    public void create(empresaM c){
    Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = (PreparedStatement) con.prepareStatement("INSERT INTO empresa (nome_empresa,inscricao_estadual,cnpj,contato,endereco,email)VALUES(?,?,?,?,?,?)");
            stmt.setString(1,c.getNome());
            stmt.setString(2,c.getInscricaoEstadual());
            stmt.setString(3,c.getCnpj());
            stmt.setString(4,c.getTelefone());
            stmt.setString(5,c.getEndereco());
            stmt.setString(6,c.getEmail());
            
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
                    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
     public List<empresaM> read(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<empresaM> empresa = new ArrayList<>();
        
        try {
            stmt = (PreparedStatement) con.prepareStatement("SELECT * FROM empresa");
            rs = stmt.executeQuery();
            
            while (rs.next()){
                
                empresaM emp = new empresaM();
                
                emp.setId(rs.getInt("idempresa"));
                emp.setNome(rs.getString("nome_empresa"));
                emp.setInscricaoEstadual(rs.getString("inscricao_estadual"));
                emp.setCnpj(rs.getString("cnpj"));
               emp.setTelefone(rs.getString("contato"));
               emp.setEndereco(rs.getString("endereco"));
               emp.setEmail(rs.getString("email"));
              
                empresa.add(emp);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return empresa;
    }
     
      public void update(empresaM c){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = (PreparedStatement) con.prepareStatement("UPDATE empresa SET nome_empresa = ?,inscricao_estadual = ?,cnpj = ?,contato = ?,endereco = ?,email = ?  WHERE idempresa = ?");
            stmt.setString(1,c.getNome());
            stmt.setString(2,c.getInscricaoEstadual());
            stmt.setString(3,c.getCnpj());
            stmt.setString(4,c.getTelefone());
            stmt.setString(5,c.getEndereco());
            stmt.setString(6,c.getEmail());
          
            stmt.setInt(7, c.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
                    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
     public void delete(empresaM c){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = (PreparedStatement) con.prepareStatement("DELETE FROM empresa WHERE idempresa = ?");
            stmt.setInt(1, c.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
                    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
     
      public List<empresaM> readForName(String name){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<empresaM> cliente = new ArrayList<>();
        
        try {
            stmt = (PreparedStatement) con.prepareStatement("SELECT * FROM empresa WHERE nome_empresa LIKE ?");
            stmt.setString(1, "%"+name+"%");
            rs = stmt.executeQuery();
            
            while (rs.next()){
                
                empresaM clientes = new empresaM();
                
                clientes.setId(rs.getInt("idempresa"));
                clientes.setNome(rs.getString("nome_empresa"));
                clientes.setInscricaoEstadual(rs.getString("inscricao_estadual"));
                clientes.setCnpj(rs.getString("cnpj"));
                clientes.setTelefone(rs.getString("contato"));
                clientes.setEmail(rs.getString("email"));
                clientes.setEndereco(rs.getString("endereco"));
               
                cliente.add(clientes);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return cliente;
    }

   
}
