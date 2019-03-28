package br.com.felipediogo.services;

import br.com.felipediogo.converters.ResponseConverter;
import br.com.felipediogo.database.repositories.GlobalRuleRepository;
import br.com.felipediogo.database.repositories.RuleRepository;
import br.com.felipediogo.dtos.ResponseDto;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;

import static br.com.felipediogo.data.GlobalRuleData.globalRules;
import static br.com.felipediogo.data.InsertionDtoData.dtos;
import static br.com.felipediogo.data.ResponseData.responseDtoInputData2;
import static br.com.felipediogo.data.RuleData.CLIENT_01;
import static br.com.felipediogo.data.RuleData.rules;
import static br.com.felipediogo.data.ValidationData.validationInputData1;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ValidationServiceTest {

    private ValidationService validationService;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private RuleService ruleService;

    @Before
    public void setup() {
        validationService = new ValidationService(ruleService, new ResponseConverter());
    }

    @Test
    public void shouldTestWhitelist() {
        whenDatabaseReturnsAllRules(CLIENT_01);
        ResponseDto response = validationService.findWhiteList(validationInputData1());
        assertThat(response, is(responseDtoInputData2()));
    }

    private void whenDatabaseReturnsAllRules(String client) {
        when(ruleService.getAllRules(client)).thenReturn(dtos());
    }
}
