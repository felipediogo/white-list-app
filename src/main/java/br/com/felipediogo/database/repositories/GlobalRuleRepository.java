package br.com.felipediogo.database.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.felipediogo.database.entities.GlobalRule;

@Repository
public interface GlobalRuleRepository extends CrudRepository<GlobalRule, Long>  {

}
