package com.example.tarefas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.tarefas.model.Tarefa;
import com.example.tarefas.repository.TarefaRepository;

@RestController
@RequestMapping("/api")
public class TarefaController {

	@Autowired
	private TarefaRepository tarefaRepository;

	@GetMapping("/tarefas")
	public List<Tarefa> getTarefas() {
		return tarefaRepository.findAll();
	}

	@GetMapping("/tarefas/usuario/{codigo}")
	public List<Tarefa> getTarefasPorUsuario(@PathVariable Long codigo) {
		return tarefaRepository.getTarefaPorUsuario(codigo);
	}

	@PostMapping("/tarefas")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Tarefa> salvar(@RequestBody Tarefa tarefa) {

		Tarefa t = tarefaRepository.save(tarefa);

		return ResponseEntity.ok(t);

	}

	@PutMapping("/tarefas")
	public ResponseEntity<Tarefa> atualizar(@RequestBody Tarefa tarefa) {
		Tarefa t = tarefaRepository.save(tarefa);
		return ResponseEntity.ok(t);
	}
	
		

}
