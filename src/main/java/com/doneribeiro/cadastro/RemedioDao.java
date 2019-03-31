package com.doneribeiro.cadastro;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RemedioDao extends CrudRepository<Remedio, Integer> {

}
