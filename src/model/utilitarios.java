/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.awt.Toolkit;
import javax.swing.JFrame;
/**
 *
 * @author Bruno
 */
public class utilitarios {
    
    public void InserirIcone(JFrame frm){
    try{
        frm.setIconImage(Toolkit.getDefaultToolkit().getImage("/imagens/icone.jpg"));
    }catch(Exception ex){
        System.out.println(ex.toString());
    }}
}
