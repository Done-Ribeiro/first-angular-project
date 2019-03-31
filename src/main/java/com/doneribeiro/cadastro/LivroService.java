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
@RequestMapping(value = "/livro")
public class LivroService {

	@Autowired
	private LivroDao livroDao;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Livro> list() {
		List<Livro> result = new ArrayList<>();
		livroDao.findAll().forEach(l -> {
			result.add(l);
		});
		return result;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void save(@RequestBody Livro livro) {
		livroDao.save(livro);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Integer id) {
		livroDao.deleteById(id);
	}

}
