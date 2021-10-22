package com.example.tarefas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.tarefas.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
	
	@Query("SELECT t FROM Tarefa t WHERE t.usuario.codigo = ?1")
	List<Tarefa> getTarefaPorUsuario(Long codigoUsuario);

}
