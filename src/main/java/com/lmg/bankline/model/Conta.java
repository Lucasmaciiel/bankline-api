package com.lmg.bankline.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
public class Conta {

    @Column(name = "conta_numero")
    private Long numero;

    @Column(name = "conta_saldo")
    private Double saldo;


}
