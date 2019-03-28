package br.com.felipediogo.services;

import br.com.felipediogo.converters.GlobalRuleConverter;
import br.com.felipediogo.converters.RuleConverter;
import br.com.felipediogo.database.repositories.GlobalRuleRepository;
import br.com.felipediogo.database.repositories.RuleRepository;
import br.com.felipediogo.dtos.InsertionDto;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class RuleService {
	
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
			RuleConverter converter,
		   	GlobalRuleConverter globalRuleConverter) {
		this.globalRuleRepository = globalRuleRepository;
		this.ruleRepository = ruleRepository;
		this.ruleConverter = converter;
		this.globalRuleConverter = globalRuleConverter;
	}
	
	public void addRule(InsertionDto input) {
		if (StringUtils.isEmpty(input.getClient())) {
			addGlobalRule(input);
		} else {
			ruleRepository.save(ruleConverter.toEntity(input));
		}
	}
	
	public void addGlobalRule(InsertionDto input) {
		globalRuleRepository.save(globalRuleConverter.toEntity(input));
	}

	private List<InsertionDto> getRules(String client) {
		List<InsertionDto> rules = IteratorUtils
				.toList(ruleRepository.findByClient(client).iterator())
				.stream()
				.map(ruleConverter::toDTO)
				.collect(Collectors.toList());
		return rules;
	}

	private List<InsertionDto> getGlobalRules() {
		List<InsertionDto> globalRules = IteratorUtils
				.toList(globalRuleRepository.findAll().iterator())
				.stream()
				.map(globalRuleConverter::toDTO)
				.collect(Collectors.toList());
		return globalRules;
	}

	public List<InsertionDto> getAllRules(String client) {
		return Stream.concat(
				getRules(client).stream(),
				getGlobalRules().stream()
		).collect(Collectors.toList());
	}
}
