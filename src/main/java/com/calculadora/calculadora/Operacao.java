package com.calculadora.calculadora;

public enum Operacao {
    SOMA("+"),
    SUBTRACAO("-"),
    MULTIPLICACAO("*"),
    DIVISAO("/"),
    NENHUMA("");

    private final String simbolo;

    Operacao(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public static Operacao fromSimbolo(String simbolo) {
        for (Operacao op : values()) {
            if (op.getSimbolo().equals(simbolo)) {
                return op;
            }
        }
        return NENHUMA;
    }
}