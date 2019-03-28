package br.com.felipediogo.converters;

import br.com.felipediogo.data.GlobalRuleData;
import br.com.felipediogo.data.InsertionDtoData;
import br.com.felipediogo.database.entities.GlobalRule;
import br.com.felipediogo.dtos.InsertionDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@RunWith(JUnit4.class)
public class GlobalRuleConverterTest {
    private GlobalRuleConverter globalRuleConverter;

    @Before
    public void setup() {
        globalRuleConverter = new GlobalRuleConverter();
    }

    @Test
    public void testShouldConvertDtoToEntity() {
        InsertionDto dto = InsertionDtoData.insertionInputData1();
        GlobalRule expected = GlobalRuleData.globalRuleData1();
        assertThat(globalRuleConverter.toEntity(dto), is(equalTo(expected)));
    }

    @Test
    public void testShouldConvertEntityToDto() {
        GlobalRule entity = GlobalRuleData.globalRuleData1();
        InsertionDto expected = InsertionDtoData.insertionInputGlobalData1();
        assertThat(globalRuleConverter.toDTO(entity), is(equalTo(expected)));
    }
}
