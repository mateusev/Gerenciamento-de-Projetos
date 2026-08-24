package com.example.demo.controller;

import com.example.demo.entity.Atividade;
import com.example.demo.entity.Risco;
import com.example.demo.repository.AtividadeRepository;
import com.example.demo.entity.Projeto;
import com.example.demo.service.ProjetoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projetos")
@CrossOrigin(origins = "*")
public class ProjetoController {
    private final ProjetoService projetoService;

    //esse construtor traz o service para a camada de controller
    public ProjetoController(ProjetoService projetoService) {
        this.projetoService = projetoService;
    }

    //Criação dos ENDPOINTS de Projeto

    @GetMapping
    public ResponseEntity listarTodos(){
        return ResponseEntity.ok(projetoService.listarTodos());
    }

    //endopoint de buscar por id
    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(projetoService.buscarPorId(id));
    }

    //endpoint de criação de projetos
    @PostMapping
    public ResponseEntity salvar(@RequestBody Projeto projeto) {
        Projeto projetoSalvo = projetoService.salvar(projeto);
        return ResponseEntity.status(HttpStatus.CREATED).body(projetoSalvo);
    }

    //endpoint de deletar
    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id) {
        projetoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    //Criação dos Endpoints da entidade Atividade

    @PostMapping("/{id}/atividades")
    public ResponseEntity adicionarAtividade(
            @PathVariable Long id,
            @RequestBody Atividade atividade
            ) {
        //busca do projeto existente no banco
        Projeto projeto = projetoService.buscarPorId(id);
        projeto.adicionarAtividade(atividade);

        Projeto projetoAtualizado = projetoService.salvar(projeto);

        return ResponseEntity.status(HttpStatus.CREATED).body(projetoAtualizado);
    }

    @PostMapping("/{id}/riscos")
    public ResponseEntity<Projeto> adicionarRisco(
            @PathVariable Long id,
            @RequestBody Risco risco
            ) {
        //busca quem é o projeto pai desse risco que iremos adicionar
        Projeto projeto = projetoService.buscarPorId(id);
        projeto.adicionarRisco(risco);

        Projeto projetoAtualizado = projetoService.salvar(projeto);

        return ResponseEntity.status(HttpStatus.CREATED).body(projetoAtualizado);
    }

}
