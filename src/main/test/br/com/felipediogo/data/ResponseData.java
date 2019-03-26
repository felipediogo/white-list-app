package br.com.felipediogo.data;

import br.com.felipediogo.dtos.ResponseDto;

import static br.com.felipediogo.data.RuleData.REGEX_01;

public class ResponseData {
    public static final Boolean MATCH_01 = false;
    public static final int CORRELATION_ID = 123456;

    public static ResponseDto responseDtoData1() {
        ResponseDto dto = new ResponseDto();
        dto.setCorrelationId(CORRELATION_ID);
        dto.setMatch(MATCH_01);
        dto.setRegex(REGEX_01);
        return dto;
    }
}
