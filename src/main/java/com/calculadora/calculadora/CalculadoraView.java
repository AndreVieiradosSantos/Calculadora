package com.calculadora.calculadora;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class CalculadoraView {
    private VBox view;
    private TextField display;
    private Button[][] botoes;

    public CalculadoraView() {
        inicializarUI();
    }

    private void inicializarUI() {
        // Campo de exibição
        display = new TextField();
        display.setAlignment(Pos.CENTER_RIGHT);
        display.setEditable(false);
        display.setStyle("-fx-font-size: 24; -fx-pref-height: 60;");

        // Botões
        String[][] rotulosBotoes = {
                {"7", "8", "9", "/"},
                {"4", "5", "6", "*"},
                {"1", "2", "3", "-"},
                {"0", ".", "C", "+"},
                {"=", "", "", ""}
        };

        botoes = new Button[rotulosBotoes.length][rotulosBotoes[0].length];

        for (int linha = 0; linha < rotulosBotoes.length; linha++) {
            for (int coluna = 0; coluna < rotulosBotoes[linha].length; coluna++) {
                String rotulo = rotulosBotoes[linha][coluna];
                if (!rotulo.isEmpty()) {
                    botoes[linha][coluna] = criarBotao(rotulo);
                }
            }
        }

        // Layout dos botões
        GridPane gridBotoes = new GridPane();
        gridBotoes.setHgap(5);
        gridBotoes.setVgap(5);
        gridBotoes.setPadding(new Insets(10));

        for (int linha = 0; linha < botoes.length; linha++) {
            for (int coluna = 0; coluna < botoes[linha].length; coluna++) {
                Button botao = botoes[linha][coluna];
                if (botao != null) {
                    GridPane.setConstraints(botao, coluna, linha);
                    gridBotoes.getChildren().add(botao);
                }
            }
        }

        // Layout principal
        view = new VBox(10);
        view.setPadding(new Insets(10));
        view.getChildren().addAll(display, gridBotoes);
    }

    private Button criarBotao(String texto) {
        Button botao = new Button(texto);
        botao.setStyle("-fx-font-size: 18; -fx-min-width: 60; -fx-min-height: 60;");
        return botao;
    }

    public VBox getView() {
        return view;
    }

    public TextField getDisplay() {
        return display;
    }

    public Button[][] getBotoes() {
        return botoes;
    }
}