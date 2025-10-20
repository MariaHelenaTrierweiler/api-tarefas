package com.mariah.api_tarefas.controller; // Pacote correto

import com.mariah.api_tarefas.model.Tarefa;
import com.mariah.api_tarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    @PostMapping
    public ResponseEntity<Tarefa> criarTarefa(@RequestBody Tarefa tarefa) {
        Tarefa novaTarefa = tarefaRepository.save(tarefa);
        return new ResponseEntity<>(novaTarefa, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Tarefa> listarTodasTarefas() {
        return tarefaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarTarefaPorId(@PathVariable Long id) {
        Optional<Tarefa> tarefa = tarefaRepository.findById(id);
        return tarefa.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa tarefaDetalhes) {
        return tarefaRepository.findById(id)
                .map(tarefa -> {
                    tarefa.setNome(tarefaDetalhes.getNome());
                    tarefa.setDataEntrega(tarefaDetalhes.getDataEntrega());
                    tarefa.setResponsavel(tarefaDetalhes.getResponsavel());
                    Tarefa tarefaAtualizada = tarefaRepository.save(tarefa);
                    return ResponseEntity.ok(tarefaAtualizada);
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerTarefa(@PathVariable Long id) {
        // Tenta encontrar a tarefa pelo ID
        Optional<Tarefa> tarefaOptional = tarefaRepository.findById(id);

        // Se a tarefa não existir, retorna 404 Not Found
        if (tarefaOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // Se existir, deleta a tarefa e retorna 204 No Content
        tarefaRepository.delete(tarefaOptional.get());
        return ResponseEntity.noContent().build();
    }
}
