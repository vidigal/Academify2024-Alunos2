package com.academify.service;

import com.academify.model.entity.Aluno;
import com.academify.model.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    private AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Aluno findById(Long id) throws Exception {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        if (!aluno.isPresent()) {
            throw new Exception("Aluno não encontrado");
        }
        return aluno.get();
    }

    public Aluno save(Aluno aluno) throws Exception {
        if (aluno.getMatricula() == null || aluno.getMatricula().length() < 10) {
            throw new Exception("Matrícula deve ter 10 caracteres.");
        }

        if (aluno.getNome() == null || aluno.getNome().length() < 3) {
            throw new Exception("Nome deve ter pelo menos 3 caracteres.");
        }

        aluno.setDataHoraCadastro(new Date());
        return alunoRepository.save(aluno);
    }

    public Aluno delete(Long id) throws Exception {
        Optional<Aluno> aluno = alunoRepository.findById(id);

        if (!aluno.isPresent()) {
            throw new Exception("Aluno não encontrado");
        }

        alunoRepository.delete(aluno.get());
        return aluno.get();
    }

    public Long count() {
        return alunoRepository.count();
    }

}