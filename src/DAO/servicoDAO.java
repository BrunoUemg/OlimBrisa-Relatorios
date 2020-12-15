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
import model.servicoM;


/**
 *
 * @author Bruno
 */
public class servicoDAO {
     public void create(servicoM c){
    Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = (PreparedStatement) con.prepareStatement("INSERT INTO servico (idservico,descricao,DataServico,idempresa)VALUES(?,?,?,?)");
            stmt.setInt(1,c.getId());
            stmt.setString(2,c.getDescricao());
            stmt.setString(3,c.getDataServico());
           stmt.setInt(4,c.getIdempresa());
            
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
                    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
     
     
        public List<servicoM> readForServico(String name){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<servicoM> servico = new ArrayList<>();
        
        try {
            stmt = (PreparedStatement) con.prepareStatement("SELECT S.idservico, S.dataServico, S.descricao, S.idempresa, E.nome_empresa FROM servico S, empresa E WHERE E.idempresa = S.idempresa and  S.idempresa LIKE ?");
            stmt.setString(1, "%"+name+"%");
            rs = stmt.executeQuery();
            
            while (rs.next()){
                
                servicoM servicos = new servicoM();
                
                servicos.setId(rs.getInt("idservico"));
                servicos.setNome(rs.getString("nome_empresa"));
                servicos.setDescricao(rs.getString("descricao"));
                servicos.setDataServico(rs.getString("dataServico"));
                
               
                servico.add(servicos);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return servico;
    }
        
         public void update(servicoM c){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = (PreparedStatement) con.prepareStatement("UPDATE servico SET dataServico = ?,descricao = ?  WHERE idservico = ?");
            stmt.setString(1,c.getDataServico());
            stmt.setString(2,c.getDescricao());
           
            stmt.setInt(3, c.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
                    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
       
    
}
