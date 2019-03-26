package br.com.felipediogo.converters;

import br.com.felipediogo.dtos.InsertionDto;
import br.com.felipediogo.dtos.ResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ResponseConverter {
    public ResponseDto convertResponse(InsertionDto insertionDto, boolean match, int correlationId) {
        ResponseDto dto = new ResponseDto();
        dto.setCorrelationId(correlationId);
        dto.setMatch(match);
        dto.setRegex(insertionDto.getRegex());
        return dto;
    }
}
