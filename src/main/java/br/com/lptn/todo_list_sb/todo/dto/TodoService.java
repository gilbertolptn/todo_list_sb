package br.com.lptn.todo_list_sb.todo.dto;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lptn.todo_list_sb.todo.TodoModel;

@Service
public class TodoService {

	@Autowired
	TodoRepository todoRepository;
	
	public Iterable<TodoModel> listAll(){
		return todoRepository.findAll();
	}

	public void deleteById(Long id){
		todoRepository.deleteById(id);
	}

	public void save(TodoModel todo){
		todoRepository.save(todo);
	}

	public Optional<TodoModel> findById(Long id){
		return todoRepository.findById(id);
	}

}
