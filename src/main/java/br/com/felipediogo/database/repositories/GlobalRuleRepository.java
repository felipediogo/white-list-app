package br.com.felipediogo.database.repositories;

import br.com.felipediogo.database.entities.GlobalRule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GlobalRuleRepository extends CrudRepository<GlobalRule, Long>  {
    List<GlobalRule> findAll();
}
