package com.lmg.bankline.service;

import com.lmg.bankline.dto.NovoCorrentista;
import com.lmg.bankline.model.Conta;
import com.lmg.bankline.model.Correntista;
import com.lmg.bankline.repository.CorrentistaRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.webjars.NotFoundException;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Date;

@Service
public class CorrentistaService {

    @Autowired
    private CorrentistaRepository correntistaRepository;

    public void save(NovoCorrentista novoCorrentista){
        var correntista = new Correntista();

        Conta conta = new Conta();
        conta.setSaldo(0.0);
        conta.setNumero(new Date().getTime());

        correntista.setNome(novoCorrentista.getNome());
        correntista.setCpf(novoCorrentista.getCpf());
        correntista.setConta(conta);

        correntistaRepository.save(correntista);
    }


    @Transactional
    public void delete(Integer correntistaId) {
        this.findById(correntistaId);
        correntistaRepository.deleteById(correntistaId);
    }

    public Correntista findById(Integer correntistaId){
        return correntistaRepository.findById(correntistaId)
                .orElseThrow(() -> new EntityNotFoundException("Correntista não existe"));
    }
}
