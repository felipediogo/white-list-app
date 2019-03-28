package br.com.felipediogo.data;

import br.com.felipediogo.dtos.InsertionDto;

import java.util.Arrays;
import java.util.List;

import static br.com.felipediogo.data.RuleData.*;

public class InsertionDtoData {
    public static InsertionDto insertionInputData1() {
        InsertionDto input = new InsertionDto();
        input.setRegex(REGEX_01);
        input.setClient(CLIENT_01);
        return input;
    }

    private static InsertionDto insertionInputData2() {
        InsertionDto input = new InsertionDto();
        input.setRegex(REGEX_02);
        input.setClient(CLIENT_01);
        return input;
    }

    public static InsertionDto insertionInputGlobalData1() {
        InsertionDto input = new InsertionDto();
        input.setRegex(REGEX_01);
        return input;
    }

    private static InsertionDto insertionInputGlobalData2() {
        InsertionDto input = new InsertionDto();
        input.setRegex(REGEX_02);
        return input;
    }



    public static List<InsertionDto> dtos() {
        return Arrays.asList(insertionInputData1(), insertionInputData2(), insertionInputGlobalData1(), insertionInputGlobalData2());
    }
}
