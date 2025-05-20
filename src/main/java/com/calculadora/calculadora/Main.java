package com.calculadora.calculadora;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Criação do modelo, visão e controlador
        CalculadoraModel model = new CalculadoraModel();
        CalculadoraView view = new CalculadoraView();
        new CalculadoraController(model, view);

        // Configuração da cena
        Scene scene = new Scene(view.getView(), 300, 400);

        // Configuração da janela
        primaryStage.setTitle("Calculadora JavaFX Modular");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}