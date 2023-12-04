package com.example.javafxproject222;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao_e_consulta extends Application {

    private static final String URL = "jdbc:mysql://localhost:3306/nome_do_banco";
    private static final String USUARIO = "root";
    private static final String SENHA = "senha";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Consulta JavaFX com JDBC");

        Label resultLabel = new Label("Resultado da consulta:");
        
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String consultaSQL = "SELECT * FROM Cinema";
            try (PreparedStatement preparedStatement = connection.prepareStatement(consultaSQL);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                StringBuilder resultado = new StringBuilder();
                while (resultSet.next()) {
                    int id = resultSet.getInt("ID");
                    String snackBarScene = resultSet.getString("SnackBarScene");
                    String discountScene = resultSet.getString("DiscountScene");
                    String paymentScene = resultSet.getString("PaymentScene");

                    resultado.append("ID: ").append(id)
                            .append(", SnackBarScene: ").append(snackBarScene)
                            .append(", DiscountScene: ").append(discountScene)
                            .append(", PaymentScene: ").append(paymentScene)
                            .append("\n");
                }

                resultLabel.setText("Resultado da consulta:\n" + resultado.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            resultLabel.setText("Erro ao conectar ou consultar o banco de dados.");
        }

        VBox vbox = new VBox(resultLabel);
        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
