package br.com.felipediogo.converters;

import br.com.felipediogo.data.InsertionDtoData;
import br.com.felipediogo.data.ResponseData;
import br.com.felipediogo.dtos.InsertionDto;
import br.com.felipediogo.dtos.ResponseDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static br.com.felipediogo.data.ResponseData.CORRELATION_ID_01;
import static br.com.felipediogo.data.ResponseData.MATCH_01;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@RunWith(JUnit4.class)
public class ResponseConverterTest {
    ResponseConverter responseConverter;

    @Before
    public void setup() {
        responseConverter = new ResponseConverter();
    }

    @Test
    public void shouldConvertDataToResponse() {
        InsertionDto input = InsertionDtoData.insertionInputData1();
        ResponseDto expected = ResponseData.responseDtoData1();
        assertThat(responseConverter.convertResponse(input, MATCH_01, CORRELATION_ID_01),
                is(equalTo(expected)));

    }
}
