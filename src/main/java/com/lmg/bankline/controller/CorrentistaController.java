package com.lmg.bankline.controller;

import com.lmg.bankline.dto.NovoCorrentista;
import com.lmg.bankline.model.Correntista;
import com.lmg.bankline.repository.CorrentistaRepository;
import com.lmg.bankline.service.CorrentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/correntistas")
public class CorrentistaController {

    @Autowired
    private CorrentistaRepository correntistaRepository;

    @Autowired
    private CorrentistaService correntistaService;

    @GetMapping
    public List<Correntista> findAll(){
        return correntistaRepository.findAll();
    }

    @PostMapping
    public void save(@RequestBody NovoCorrentista correntista){
        correntistaService.save(correntista);
    }

    @DeleteMapping("/{correntistaId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @CrossOrigin
    public void delete(@NotNull @PathVariable("correntistaId") Integer correntistaId){
        correntistaService.delete(correntistaId);
    }

}
