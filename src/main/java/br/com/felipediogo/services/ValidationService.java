package br.com.felipediogo.services;

import br.com.felipediogo.converters.ResponseConverter;
import br.com.felipediogo.dtos.InsertionDto;
import br.com.felipediogo.dtos.ResponseDto;
import br.com.felipediogo.dtos.ValidationDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Pattern;

@Component
public class ValidationService {

    private RuleService ruleService;

    private ResponseConverter responseConverter;

    public ValidationService(RuleService ruleService, ResponseConverter responseConverter) {
        this.ruleService = ruleService;
        this.responseConverter = responseConverter;
    }

    public ResponseDto findWhiteList(ValidationDto validation) {
        List<InsertionDto> rules = ruleService.getAllRules(validation.getClient());
        return rules.stream().parallel().filter(item -> match(item.getRegex(), validation.getUrl()))
                .findAny().map(item -> responseConverter.convertResponse(item, true, validation.getCorrelationId()))
                .orElse(responseConverter.convertResponse(new InsertionDto(), false, validation.getCorrelationId()));
    }

    private boolean match(String regex, String url) {
        return Pattern.matches(regex, url);
    }
}
