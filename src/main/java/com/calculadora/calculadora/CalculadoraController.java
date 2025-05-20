package com.calculadora.calculadora;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;


public class CalculadoraController {
    private CalculadoraModel model;
    private CalculadoraView view;

    public CalculadoraController(CalculadoraModel model, CalculadoraView view) {
        this.model = model;
        this.view = view;

        configurarHandlers();
    }

    private void configurarHandlers() {
        Button[][] botoes = view.getBotoes();

        for (int linha = 0; linha < botoes.length; linha++) {
            for (int coluna = 0; coluna < botoes[linha].length; coluna++) {
                Button botao = botoes[linha][coluna];
                if (botao != null) {
                    botao.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            tratarCliqueBotao(((Button) event.getSource()).getText());
                        }
                    });
                }
            }
        }
    }

    private void tratarCliqueBotao(String texto) {
        switch (texto) {
            case "0": case "1": case "2": case "3": case "4":
            case "5": case "6": case "7": case "8": case "9":
                if (model.deveComecarNovoNumero()) {
                    view.getDisplay().setText("");
                    model.setComecarNovoNumero(false);
                }
                view.getDisplay().setText(view.getDisplay().getText() + texto);
                break;

            case ".":
                if (model.deveComecarNovoNumero()) {
                    view.getDisplay().setText("0");
                    model.setComecarNovoNumero(false);
                }
                if (!view.getDisplay().getText().contains(".")) {
                    view.getDisplay().setText(view.getDisplay().getText() + texto);
                }
                break;

            case "+": case "-": case "*": case "/":
                model.setNumero1(Double.parseDouble(view.getDisplay().getText()));
                model.setOperacao(Operacao.fromSimbolo(texto));
                model.setComecarNovoNumero(true);
                break;

            case "=":
                if (model.getOperacao() != Operacao.NENHUMA) {
                    double numero2 = Double.parseDouble(view.getDisplay().getText());
                    double resultado = model.calcular(numero2);
                    view.getDisplay().setText(String.valueOf(resultado));
                    model.setOperacao(Operacao.NENHUMA);
                    model.setComecarNovoNumero(true);
                }
                break;

            case "C":
                view.getDisplay().setText("0");
                model.reset();
                break;
        }
    }
}