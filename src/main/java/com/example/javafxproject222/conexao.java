package com.example.javafxproject222;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {
    public static void main(String[] args) {
        Connection conexao = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/conexao";
            String usuario = "root";
            String senha = "erick123";

            conexao = DriverManager.getConnection(url, usuario, senha);

            System.out.println("Conexão bem-sucedida!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
