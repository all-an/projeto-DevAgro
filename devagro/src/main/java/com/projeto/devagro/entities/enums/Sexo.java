package com.projeto.devagro.entities.enums;

public enum Sexo {

    FEMININO(1),
    MASCULINO(2),
    NAO_INFORMADO(3);

    private int codigo;

    private Sexo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static Sexo valueOf(int codigo) {
        for (Sexo valor : Sexo.values()) {
            if (valor.getCodigo() == codigo) {
                return valor;
            }
        }
        throw new IllegalArgumentException("Código inválido");
    }
}