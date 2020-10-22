/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import view.loginview;


/**
 *
 * @author Bruno
 */
public class OlimBrisa {
    
     public static void main(String[] args) throws SQLException {
        
       new OlimBrisa().executar();
    }
    
    public void executar(){
        loginview login = new loginview();
    }
}
