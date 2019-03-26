package com.doneribeiro.cadastro;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/aluno")
public class AlunoService {

	@Autowired
	private AlunoDao alunoDao;

	@RequestMapping(value="/list", method = RequestMethod.GET)
	public List<Aluno> list() {
		List<Aluno> result = new ArrayList<>();
		alunoDao.findAll().forEach(a -> {result.add(a);});
		return result;
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public void save(@RequestBody Aluno aluno) {
		alunoDao.save(aluno);
	}
	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Integer id) {
		alunoDao.deleteById(id);
	}
}
