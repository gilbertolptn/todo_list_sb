package br.com.lptn.todo_list_sb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@GetMapping
    public ModelAndView lista(String produto) {
        ModelAndView model = new ModelAndView("/produto-lista.html");
        
//        List<Produto> lista = DADOS.stream()
//                .filter(p -> produto.getId() == null || produto.getId().equals(p.getId()))
//                .filter(p -> StringUtils.isEmpty(produto.getNome()) || p.getNome().startsWith(produto.getNome()))
//                .collect(Collectors.toList());
        
        String lista = "";
		model.addObject("produtos", lista);
        
        return model;
}
}
