package br.com.felipediogo.services;

import br.com.felipediogo.converters.GlobalRuleConverter;
import br.com.felipediogo.converters.RuleConverter;
import br.com.felipediogo.database.repositories.GlobalRuleRepository;
import br.com.felipediogo.database.repositories.RuleRepository;
import br.com.felipediogo.dtos.InsertionDto;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class RuleService {

    private GlobalRuleRepository globalRuleRepository;

    private RuleRepository ruleRepository;

    private RuleConverter ruleConverter;

    private GlobalRuleConverter globalRuleConverter;

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

    private void addGlobalRule(InsertionDto input) {
        globalRuleRepository.save(globalRuleConverter.toEntity(input));
    }

    private List<InsertionDto> getRules(String client) {
        return ruleRepository
                .findByClient(client).stream()
                .map(ruleConverter::toDTO)
                .collect(Collectors.toList());
    }

    private List<InsertionDto> getGlobalRules() {
        return globalRuleRepository.findAll().stream()
                .map(globalRuleConverter::toDTO)
                .collect(Collectors.toList());

    }

    public List<InsertionDto> getAllRules(String client) {
        return Stream.concat(
                getRules(client).stream(),
                getGlobalRules().stream()
        ).collect(Collectors.toList());
    }
}
