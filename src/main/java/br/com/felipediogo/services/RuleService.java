package br.com.felipediogo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.felipediogo.converters.RuleConverter;
import br.com.felipediogo.database.repositories.GlobalRuleRepository;
import br.com.felipediogo.database.repositories.RuleRepository;
import br.com.felipediogo.dtos.InsertionDto;

@Component
public class RuleService {
	
	@Autowired
	GlobalRuleRepository globalRuleRepository;
	
	@Autowired
	RuleRepository ruleRepository;
	
	@Autowired
	RuleConverter converter;
	
	public RuleService(GlobalRuleRepository globalRuleRepository,
			RuleRepository ruleRepository,
			RuleConverter converter) {
		this.globalRuleRepository = globalRuleRepository;
		this.ruleRepository = ruleRepository;
		this.converter = converter;
	}
	
	public void addRule(InsertionDto input) {
		ruleRepository.save(converter.toEntity(input));
	}
	
	public void addGlobalRule(InsertionDto input) {
		
	}
}
