package com.example.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entidades.Aluno;
import com.example.repositorios.AlunoRepositorio;
import com.example.repositorios.CidadeRepositorio;

@Controller
public class AlunoControler {
	@Autowired
	private AlunoRepositorio alunoRepositorio;
	@Autowired
	private CidadeRepositorio cidadeRepositorio;

	@RequestMapping(value = "/")
	public String listarAlunos(Model model) {
		model.addAttribute("alunos", alunoRepositorio.findAll());
		model.addAttribute("cidades", cidadeRepositorio.findAllOrderByNome());
		return "Alunos";
	}

	@RequestMapping(value = "/aluno/save")
	public String salvar(Aluno aluno) {
		alunoRepositorio.save(aluno);
		return "redirect:/";
	}
}
