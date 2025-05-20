package com.calculadora.calculadora;

public class CalculadoraModel {
    private double numero1;
    private Operacao operacao;
    private boolean comecarNovoNumero;

    public CalculadoraModel() {
        reset();
    }

    public void reset() {
        numero1 = 0;
        operacao = Operacao.NENHUMA;
        comecarNovoNumero = true;
    }

    public void setOperacao(Operacao operacao) {
        this.operacao = operacao;
    }

    public Operacao getOperacao() {
        return operacao;
    }

    public void setNumero1(double numero) {
        this.numero1 = numero;
    }

    public double getNumero1() {
        return numero1;
    }

    public boolean deveComecarNovoNumero() {
        return comecarNovoNumero;
    }

    public void setComecarNovoNumero(boolean comecarNovoNumero) {
        this.comecarNovoNumero = comecarNovoNumero;
    }

    public double calcular(double numero2) {
        switch (operacao) {
            case SOMA: return numero1 + numero2;
            case SUBTRACAO: return numero1 - numero2;
            case MULTIPLICACAO: return numero1 * numero2;
            case DIVISAO:
                if (numero2 == 0) return 0; // Evita divisão por zero
                return numero1 / numero2;
            default: return numero2;
        }
    }
}