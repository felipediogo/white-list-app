package br.com.felipediogo.services;

import br.com.felipediogo.converters.ResponseConverter;
import br.com.felipediogo.dtos.InsertionDto;
import br.com.felipediogo.dtos.ResponseDto;
import br.com.felipediogo.dtos.ValidationDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

@Component
public class ValidationService {

    @Autowired
    RuleService ruleService;

    @Autowired
    ResponseConverter responseConverter;

    private static final Logger log = LoggerFactory.getLogger(ValidationService.class);


    public ResponseDto findWhiteList(ValidationDto validation) {
        List<InsertionDto> rules = ruleService.getAllRules(validation.getClient());
        rules.forEach(item -> log.info("{} - {}", item.getRegex(), item.getClient()));
        AtomicInteger i = new AtomicInteger();
        return rules.stream().parallel().filter(item -> {
                    log.info("matching -> {} - {}", i.getAndIncrement(), item.getRegex());
                    return match(item.getRegex(), validation.getUrl());
                })
                .findAny().map(item -> responseConverter.convertResponse(item, true, validation.getCorrelationId()))
                .orElse(responseConverter.convertResponse(new InsertionDto(), false, validation.getCorrelationId()));
    }

    public boolean match(String regex, String url) {
        return Pattern.matches(regex, url);
    }
}
