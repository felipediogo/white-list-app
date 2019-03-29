package br.com.felipediogo.database.repositories;

import br.com.felipediogo.database.entities.Rule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RuleRepository extends CrudRepository<Rule, Long> {
    List<Rule> findByClient(String client);
}
