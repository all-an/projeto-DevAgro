package com.projeto.devagro.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class Response<T>  {

    private T dados;
    private List<String> erros;

    public List<String> getErros() {
        if (this.erros == null) {
            this.erros = new ArrayList<String>();
        }
        return erros;
    }

    public void setDados(T dados) {
        this.dados = dados;
    }

    public void setErros(List<String> erros) {
        this.erros = erros;
    }
}
