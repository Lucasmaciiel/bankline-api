package com.lmg.bankline.controller;

import com.lmg.bankline.dto.NovaMovimentacao;
import com.lmg.bankline.dto.NovoCorrentista;
import com.lmg.bankline.model.Correntista;
import com.lmg.bankline.model.Movimentacao;
import com.lmg.bankline.repository.CorrentistaRepository;
import com.lmg.bankline.repository.MovimentacaoRepository;
import com.lmg.bankline.service.CorrentistaService;
import com.lmg.bankline.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @Autowired
    private MovimentacaoService movimentacaoService;

    @GetMapping
    public List<Movimentacao> findAll(){
        return movimentacaoRepository.findAll();
    }

    @PostMapping
    public void save(@RequestBody NovaMovimentacao novaMovimentacao){
        movimentacaoService.save(novaMovimentacao);
    }

}
