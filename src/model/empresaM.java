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
public class empresaM {
      private Integer id;
      private String inscricaoEstadual;

    
    private String nome;
    private String telefone;
    private String endereco;
    private String cnpj;
    private String email;

    public empresaM() {
      
    }

    public empresaM(Integer id, String inscricaoEstadual, String nome, String telefone, String endereco, String cnpj, String email) {
         this.id = id;
        this.inscricaoEstadual = inscricaoEstadual;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cnpj = cnpj;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

    
}
