/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.model.dao;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author kamil
 * conexao responsavel por ligar o banco do PostgreSQL com o programa
 */
public class Conexao {
    private static Connection conexao;
    //método statico que eu usei para pegar as falhas principalmente das pensagens de confirmação do sistema
    static Connection getConexao() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    //conexao do banco
    public static Connection getConnection() throws SQLException{
        if(conexao == null){ 
        
        Dotenv dotenv = Dotenv.load(); //carrega o que tem no .env que é só a senha
        
        //conecta no banco
        Connection conexao = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/feiTv", "postgres",
                dotenv.get("SENHA_DB"));
        
        //mensagem que aparece quando consegue puxar os dados do banco
        System.out.println("Conexao bem sucedida"); 
        return conexao;
        }else{return conexao;}
    }
}
