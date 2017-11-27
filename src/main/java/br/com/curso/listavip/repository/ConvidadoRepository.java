package br.com.curso.listavip.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.curso.listavip.model.Convidado;

public interface ConvidadoRepository extends CrudRepository<Convidado, Long> {

}
