package br.com.felipediogo.services;

import br.com.felipediogo.converters.ResponseConverter;
import br.com.felipediogo.dtos.InsertionDto;
import br.com.felipediogo.dtos.ResponseDto;
import br.com.felipediogo.dtos.ValidationDto;
import br.com.felipediogo.messagequeue.listeners.InsertionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Component
public class ValidationService {

    @Autowired
    RuleService ruleService;

    @Autowired
    ResponseConverter responseConverter;

    private static final Logger log = LoggerFactory.getLogger(ValidationService.class);


    public ResponseDto findWhiteList(ValidationDto validation) {
        List<InsertionDto> rules = ruleService.getAllRules(validation.getClient());
        return rules.stream().parallel().filter(item -> {
                    log.info("matching -> {}", item.getRegex());
                    return match(item.getRegex(), validation.getUrl());
                })
                .findAny().map(item -> responseConverter.convertResponse(item, true, validation.getCorrelationId()))
                .orElse(responseConverter.convertResponse(new InsertionDto(), false, validation.getCorrelationId()));
    }

    public static void main(String[] args) {
        String input = "a";
        System.out.print(Pattern.matches("[abc]", input));
    }

    public boolean match(String regex, String url) {
        return Pattern.matches(regex, url);
    }
}
