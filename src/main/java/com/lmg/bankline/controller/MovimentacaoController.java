package com.lmg.bankline.controller;

import com.lmg.bankline.dto.NovaMovimentacao;
import com.lmg.bankline.model.Movimentacao;
import com.lmg.bankline.repository.MovimentacaoRepository;
import com.lmg.bankline.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
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

    @GetMapping("/{contaId}")
    public List<Movimentacao> findByIdConta(@NotNull @PathVariable("contaId") Integer contaId){
        return movimentacaoService.findByIdConta(contaId);
    }

}
