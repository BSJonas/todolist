package br.com.jonas.todolist.service;

import java.util.List;

import br.com.jonas.todolist.entity.Todo;
import br.com.jonas.todolist.repository.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class TodoService {
	private TodoRepository todoRepository;

	public TodoService(TodoRepository todoRepository){
		this.todoRepository = todoRepository;
	}

	public List<Todo>create(Todo todo) {
		todoRepository.save(todo);
		return list();
	}
	public List<Todo>list() {
		Sort sort = Sort.by("prioridade").descending().and(
			Sort.by("nome").ascending());
		return todoRepository.findAll(sort);
	}
	public List<Todo>update(Todo todo) {
		todoRepository.save(todo);
		return list();
	}


	public List<Todo>delete(Long id) {
		todoRepository.deleteById(id);
		return list();
	}

}
