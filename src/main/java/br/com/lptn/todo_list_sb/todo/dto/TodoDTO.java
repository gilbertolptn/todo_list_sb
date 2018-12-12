package br.com.lptn.todo_list_sb.todo.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private long id;
	private String text;
}
