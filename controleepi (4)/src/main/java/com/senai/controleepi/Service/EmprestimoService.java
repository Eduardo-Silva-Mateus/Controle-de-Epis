package com.senai.controleepi.Service;

import com.senai.controleepi.Dtos.EmprestimoDto;
import com.senai.controleepi.Models.ColaboradorModel;
import com.senai.controleepi.Models.EmprestimoModel;
import com.senai.controleepi.Models.epiModel;
import com.senai.controleepi.Repository.EmprestimoRepository;
import com.senai.controleepi.Repository.colaboradorRepository;
import com.senai.controleepi.Repository.epiRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmprestimoService {

    @Autowired
    EmprestimoRepository emprestimoRepository;

    @Autowired
    epiRepository epiRepository;

    public boolean cadastrarEmprestimo(EmprestimoDto cadastro) {
        
        // Verificar se já existe um empréstimo associado a este colaborador
        Optional<EmprestimoModel> optionalEmprestimo = emprestimoRepository.findByColaborador(cadastro.getColaborador());

        if (optionalEmprestimo.isPresent()) {
            // Já existe um empréstimo com este colaborador
            return false;
        }

        // Criar o empréstimo e associar o colaborador existente
        EmprestimoModel emprestimo = new EmprestimoModel();
        emprestimo.setColaborador(cadastro.getColaborador());
        
        epiModel epi = epiRepository.findById(cadastro.getEpi().getId())
                .orElseThrow(() -> new IllegalArgumentException("EPI não encontrado no sistema!"));

        // Verificar se há estoque suficiente
        if (epi.getQuantidade() <= 0) {
            throw new IllegalArgumentException("Estoque insuficiente para o EPI selecionado!");
        }

        // Decrementar o estoque do EPI
        epi.setQuantidade(epi.getQuantidade() - 1);
        epiRepository.save(epi);
        
        emprestimo.setEpi(cadastro.getEpi());
        emprestimo.setDataInicio(LocalDate.now());

        // Salvar o empréstimo no banco de dados
        emprestimoRepository.save(emprestimo);

        return true;
    }

    public List<EmprestimoDto> obterListaUsuarios() {

        List<EmprestimoModel> listaUsuarioModel = emprestimoRepository.findAll();

        List<EmprestimoDto> listaEPI = new ArrayList();

        for (EmprestimoModel epi : listaUsuarioModel) {

            EmprestimoDto epiDto = new EmprestimoDto();
            epiDto.setId(epi.getId());
            epiDto.setNomeColaborador(epi.getColaborador().getNome());
            epiDto.setDescricaoEpi(epi.getEpi().getDescricao());
            epiDto.setDataInicio(epi.getDataInicio());
            epiDto.setDataFim(epi.getDataFim());

            listaEPI.add(epiDto);
        }

        return listaEPI;

    }

    public EmprestimoDto obterEmprestimoDevolucao(Long id) {

        Optional<EmprestimoModel> optionalEmprestimo = emprestimoRepository.findById(id);

        EmprestimoDto emprestimoDto = new EmprestimoDto();

        if (!optionalEmprestimo.isPresent()) {
            emprestimoDto.setId(0L);
            return emprestimoDto;
        }

        emprestimoDto.setId(optionalEmprestimo.get().getId());

        return emprestimoDto;
    }

    public boolean excluirEmprestimo(Long id) {

        System.out.println("id:" + id);

        Optional<EmprestimoModel> optionalEmprestimo = emprestimoRepository.findById(id);

        if (!optionalEmprestimo.isPresent()) {
            return false;
        }

        emprestimoRepository.delete(optionalEmprestimo.get());

        return true;

    }

    public boolean DevolverEmprestimo(Long id, EmprestimoDto dados) {

        Optional<EmprestimoModel> optionalUsuario = emprestimoRepository.findById(id);

        if (!optionalUsuario.isPresent()) {
            return false;
        }
        
        epiModel epi = epiRepository.findById(dados.getEpi().getId())
                .orElseThrow(() -> new IllegalArgumentException("EPI não encontrado no sistema!"));

        // Verificar se há estoque suficiente
        if (epi.getQuantidade() <= 0) {
            throw new IllegalArgumentException("Estoque insuficiente para o EPI selecionado!");
        }

        // Decrementar o estoque do EPI
        epi.setQuantidade(epi.getQuantidade() - 1);
        epiRepository.save(epi);
        EmprestimoModel emprestimo = optionalUsuario.get();

        emprestimo.setDataFim(LocalDate.now());

        emprestimoRepository.save(emprestimo);

        return true;
    }

}
