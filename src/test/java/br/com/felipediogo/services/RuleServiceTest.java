package br.com.felipediogo.services;

import br.com.felipediogo.converters.GlobalRuleConverter;
import br.com.felipediogo.converters.RuleConverter;
import br.com.felipediogo.database.repositories.GlobalRuleRepository;
import br.com.felipediogo.database.repositories.RuleRepository;
import br.com.felipediogo.dtos.InsertionDto;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import java.util.List;

import static br.com.felipediogo.data.GlobalRuleData.globalRuleData1;
import static br.com.felipediogo.data.GlobalRuleData.globalRules;
import static br.com.felipediogo.data.InsertionDtoData.*;
import static br.com.felipediogo.data.RuleData.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RuleServiceTest {
    @Mock
    GlobalRuleRepository globalRuleRepository;

    @Mock
    RuleRepository ruleRepository;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    private RuleService ruleService;

    @Before
    public void setup() {
        ruleService = new RuleService(globalRuleRepository, ruleRepository, new RuleConverter(), new GlobalRuleConverter());
    }

    @Test
    public void shouldTestAddRule() {
        ruleService.addRule(insertionInputData1());
        verify(ruleRepository).save(ruleData1());
    }

    @Test
    public void shouldTestAddGlobalRule() {
        ruleService.addRule(insertionInputGlobalData1());
        verify(globalRuleRepository).save(globalRuleData1());
    }

    @Test
    public void shouldGetAllRules() {
        whenDatabaseReturnsRules();
        whenDatabaseReturnsGlobalRules();

        List<InsertionDto> dtos = ruleService.getAllRules(CLIENT_01);
        assertThat(dtos, is(dtos()));
    }

    private void whenDatabaseReturnsRules() {
        when(ruleRepository.findByClient(br.com.felipediogo.data.RuleData.CLIENT_01)).thenReturn(rules());
    }

    private void whenDatabaseReturnsGlobalRules() {
        when(globalRuleRepository.findAll()).thenReturn(globalRules());
    }
}
