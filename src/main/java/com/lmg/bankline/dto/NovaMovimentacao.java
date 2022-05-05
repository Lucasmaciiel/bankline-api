package com.lmg.bankline.dto;

import com.lmg.bankline.model.MovimentacaoTipo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NovaMovimentacao {

    private String descricao;
    private Double valor;
    private MovimentacaoTipo tipo;
    private Integer idConta;
}
