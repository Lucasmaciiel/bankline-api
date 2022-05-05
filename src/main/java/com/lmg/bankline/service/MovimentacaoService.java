package com.lmg.bankline.service;

import com.lmg.bankline.dto.NovaMovimentacao;
import com.lmg.bankline.dto.NovoCorrentista;
import com.lmg.bankline.model.Conta;
import com.lmg.bankline.model.Correntista;
import com.lmg.bankline.model.Movimentacao;
import com.lmg.bankline.model.MovimentacaoTipo;
import com.lmg.bankline.repository.CorrentistaRepository;
import com.lmg.bankline.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

@Service
public class MovimentacaoService {

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @Autowired
    private CorrentistaRepository correntistaRepository;

    public void save(NovaMovimentacao novaMovimentacao){

        var movimentacao = new Movimentacao();

        var valor = novaMovimentacao.getTipo() == MovimentacaoTipo.RECEITA ? novaMovimentacao.getValor() : novaMovimentacao.getValor() * -1;

        movimentacao.setDataHora(LocalDateTime.now());
        movimentacao.setDescricao(novaMovimentacao.getDescricao());
        movimentacao.setIdConta(novaMovimentacao.getIdConta());
        movimentacao.setTipo(novaMovimentacao.getTipo());
        movimentacao.setValor(valor);

        var correntista = correntistaRepository.findById(novaMovimentacao.getIdConta())
                .orElseThrow( () -> new EntityNotFoundException("Correntista não existe"));

        correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
        correntistaRepository.save(correntista);

        movimentacaoRepository.save(movimentacao);
    }
}
