package br.com.lptn.todo_list_sb.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.lptn.todo_list_sb.todo.TodoModel;
import br.com.lptn.todo_list_sb.todo.dto.TodoDTO;
import br.com.lptn.todo_list_sb.todo.dto.TodoService;

@Controller
public class HomeController {

	@Autowired
	TodoService todoService;

	@RequestMapping("/")
	public ModelAndView index(Model model) {

		ArrayList<TodoDTO> todos = new ArrayList<TodoDTO>();

		todoService.listAll().forEach(m -> todos.add(new TodoDTO(m.getId(), m.getText())));
				
		model.addAttribute("todos", todos);

		return new ModelAndView("index");
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(@RequestParam("text") String text, @RequestParam("id") Long id) {

		Optional<TodoModel> todoOptional = todoService.findById(id);

		if(todoOptional.isPresent()){
			TodoModel todo = todoOptional.get();
			todo.setText(text);
			todoService.save(todo);
		}
		
		return "redirect:/";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public String delete(@PathVariable Long id) {
		todoService.deleteById(id);
		return "redirect:/";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView add(@RequestParam("text") String text) {
		TodoModel todoModel = new TodoModel();
		todoModel.setText(text);
		todoService.save(todoModel);
		
		return new ModelAndView("redirect:/");
	}
}
