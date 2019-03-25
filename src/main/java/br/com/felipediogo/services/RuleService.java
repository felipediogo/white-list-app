package br.com.felipediogo.services;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import br.com.felipediogo.converters.GlobalRuleConverter;
import br.com.felipediogo.converters.RuleConverter;
import br.com.felipediogo.database.entities.GlobalRule;
import br.com.felipediogo.database.repositories.GlobalRuleRepository;
import br.com.felipediogo.database.repositories.RuleRepository;
import br.com.felipediogo.dtos.InsertionDto;

@Component
public class RuleService {
	
	private static final Logger log = LoggerFactory.getLogger(RuleService.class);
	
	@Autowired
	GlobalRuleRepository globalRuleRepository;
	
	@Autowired
	RuleRepository ruleRepository;
	
	@Autowired
	RuleConverter ruleConverter;
	
	@Autowired
	GlobalRuleConverter globalRuleConverter;
	
	public RuleService(GlobalRuleRepository globalRuleRepository,
			RuleRepository ruleRepository,
			RuleConverter converter) {
		this.globalRuleRepository = globalRuleRepository;
		this.ruleRepository = ruleRepository;
		this.ruleConverter = converter;
	}
	
	public void addRule(InsertionDto input) {
		if (StringUtils.isEmpty(input.getClient())) {
			addGlobalRule(input);
		}
		ruleRepository.save(ruleConverter.toEntity(input));
	}
	
	public void addGlobalRule(InsertionDto input) {
		globalRuleRepository.save(globalRuleConverter.toEntity(input));
	}
	
	public void getAllRules() {
		 List<Iterable<? extends GlobalRule>> rules = Arrays.asList(ruleRepository.findAll(), globalRuleRepository.findAll());
		 rules.stream().forEach(t -> log.info("rule -> {}", t.toString()));
	}
}
