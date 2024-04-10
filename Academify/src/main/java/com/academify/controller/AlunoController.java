package com.academify.controller;

import com.academify.model.entity.Aluno;
import com.academify.model.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping("/listar")
    public List<Aluno> listar() {
        return alunoRepository.findAll();
    }

    @GetMapping("/getById/{id}")
    public Optional<Aluno> getById(@PathVariable("id") int id) {
        return alunoRepository.findById(id);
    }

    @GetMapping("/total")
    public Long getTotal() {
        return alunoRepository.count();
    }

    @PostMapping("/create")
    public Aluno create(@RequestBody Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @PutMapping("/edit")
    public Aluno edit(@RequestBody Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @DeleteMapping("/delete/{id}")
    public Aluno delete(@PathVariable("id") int id) {
        Optional<Aluno> alunoQueEuQueroRemover = alunoRepository.findById(id);
        if (!alunoQueEuQueroRemover.isPresent()) return null;

        alunoRepository.delete(alunoQueEuQueroRemover.get());
        return alunoQueEuQueroRemover.get();
    }

}
