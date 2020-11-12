/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Bruno
 */
public class usuarioM {
    private Integer idUsuario;
    private String userAcesso;
    private String senha;

    public usuarioM(Integer idUsuario, String userAcesso, String senha) {
        this.idUsuario = idUsuario;
        this.userAcesso = userAcesso;
        this.senha = senha;
    }

    public usuarioM() {
      
    }
    
    

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUserAcesso() {
        return userAcesso;
    }

    public void setUserAcesso(String userAcesso) {
        this.userAcesso = userAcesso;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
