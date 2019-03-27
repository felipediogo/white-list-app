package br.com.felipediogo.data;

import br.com.felipediogo.dtos.InsertionDto;

import static br.com.felipediogo.data.RuleData.CLIENT_01;
import static br.com.felipediogo.data.RuleData.REGEX_01;

public class InsertionDtoData {
    public static InsertionDto insertionInputData1() {
        InsertionDto input = new InsertionDto();
        input.setRegex(REGEX_01);
        input.setClient(CLIENT_01);
        return input;
    }

    public static InsertionDto insertionInputGlobalData1() {
        InsertionDto input = new InsertionDto();
        input.setRegex(REGEX_01);
        return input;
    }
}