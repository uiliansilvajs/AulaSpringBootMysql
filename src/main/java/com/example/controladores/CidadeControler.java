package com.example.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entidades.Cidade;
import com.example.repositorios.CidadeRepositorio;

@Controller
public class CidadeControler {
	@Autowired
	CidadeRepositorio cidadeRepositorio;

	@RequestMapping(value = "/cidade")
	public String lista(Cidade cidade, Model model) {
		model.addAttribute("cidades", cidadeRepositorio.findAll());
		if (cidade.getId() != null) {
			model.addAttribute("cidade", cidadeRepositorio.findOne(cidade.getId()));
		} else {
			model.addAttribute("cidade", new Cidade());
		}
		return "Cidade";
	}

	@RequestMapping(value = "/cidade/save")
	public String salvar(Cidade cidade) {
		cidadeRepositorio.save(cidade);
		return "redirect:/cidade";
	}

	@RequestMapping(value = "/cidade/del")
	public String deletar(Cidade cidade) {
		cidadeRepositorio.delete(cidade);
		return "redirect:/cidade";
	}
}
