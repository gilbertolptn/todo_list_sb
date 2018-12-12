package br.com.lptn.todo_list_sb.todo.dto;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.lptn.todo_list_sb.todo.TodoModel;

@Repository
public interface TodoRepository extends CrudRepository<TodoModel, Long> {
}
