package br.com.felipediogo.data;

import br.com.felipediogo.dtos.ResponseDto;

import static br.com.felipediogo.data.RuleData.REGEX_01;

public class ResponseData {
    public static final Boolean MATCH_01 = false;
    private static final Boolean MATCH_02 = true;
    public static final int CORRELATION_ID_01 = 123456;

    public static ResponseDto responseDtoData1() {
        ResponseDto dto = new ResponseDto();
        dto.setCorrelationId(CORRELATION_ID_01);
        dto.setMatch(MATCH_01);
        dto.setRegex(REGEX_01);
        return dto;
    }

    public static ResponseDto responseDtoInputData2() {
        ResponseDto dto = new ResponseDto();
        dto.setCorrelationId(CORRELATION_ID_01);
        dto.setMatch(MATCH_02);
        dto.setRegex(REGEX_01);
        return dto;
    }
}
