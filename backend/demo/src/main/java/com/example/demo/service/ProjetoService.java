package com.example.demo.service;

import com.example.demo.entity.Projeto;
import com.example.demo.repository.ProjetoRepository;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class ProjetoService {
    private final ProjetoRepository projetoRepository;

    public ProjetoService(ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }

    //Regras de negócio do CRUD(funções de salvar, excluir etc)

    //salvar e atualizar o projeto
    public Projeto salvar(Projeto projeto) {
        if(projeto.getNome() == null) { throw new RuntimeException("Nome inválido"); }
        return projetoRepository.save(projeto);
    }

    //listar os projetos
    public List listarTodos() {
        return projetoRepository.findAll();
    }

    public Projeto buscarPorId(Long id) {
        return projetoRepository.findById(id).orElseThrow(() -> new RuntimeException("Projeto não encontrado com o ID: " + id));
    }

    //deletar o projeto
    public void deletar(Long id) {
        Projeto projeto = buscarPorId(id);
        projetoRepository.delete(projeto);
    }
}
