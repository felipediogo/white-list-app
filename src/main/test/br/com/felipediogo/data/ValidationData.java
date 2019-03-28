package br.com.felipediogo.data;

import br.com.felipediogo.dtos.ValidationDto;

import static br.com.felipediogo.data.ResponseData.CORRELATION_ID_01;
import static br.com.felipediogo.data.RuleData.CLIENT_01;

public class ValidationData {
    private static final String URL_1 = "www.google.com";

    public static ValidationDto validationInputData1() {
        ValidationDto dto = new ValidationDto();
        dto.setClient(CLIENT_01);
        dto.setCorrelationId(CORRELATION_ID_01);
        dto.setUrl(URL_1);
        return dto;
    }
}
