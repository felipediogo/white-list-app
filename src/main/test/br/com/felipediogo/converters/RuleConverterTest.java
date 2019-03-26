package br.com.felipediogo.converters;

import br.com.felipediogo.data.GlobalRuleData;
import br.com.felipediogo.data.InsertionDtoData;
import br.com.felipediogo.data.RuleData;
import br.com.felipediogo.database.entities.GlobalRule;
import br.com.felipediogo.database.entities.Rule;
import br.com.felipediogo.dtos.InsertionDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@RunWith(JUnit4.class)
public class RuleConverterTest {
    private RuleConverter ruleConverter;

    @Before
    public void setup() {
        ruleConverter = new RuleConverter();
    }

    @Test
    public void testShouldConvertDtoToEntity() {
        InsertionDto dto = InsertionDtoData.insertionInputData1();
        Rule expected = RuleData.ruleData1();
        assertThat(ruleConverter.toEntity(dto), is(equalTo(expected)));
    }

    @Test
    public void testShouldConvertEntityToDto() {
        Rule entity = RuleData.ruleData1();
        InsertionDto expected = InsertionDtoData.insertionInputData1();
        assertThat(ruleConverter.toDTO(entity), is(equalTo(expected)));
    }
}
