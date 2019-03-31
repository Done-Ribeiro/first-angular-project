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
@RequestMapping(value = "/remedio")
public class RemedioService {

	@Autowired
	private RemedioDao remedioDao;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Remedio> list() {
		List<Remedio> result = new ArrayList<>();
		remedioDao.findAll().forEach(r -> {
			result.add(r);
		});
		return result;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void save(@RequestBody Remedio remedio) {
		remedioDao.save(remedio);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Integer id) {
		remedioDao.deleteById(id);
	}

}
