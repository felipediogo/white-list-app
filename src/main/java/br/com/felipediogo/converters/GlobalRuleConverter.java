package br.com.felipediogo.converters;

import br.com.felipediogo.database.entities.GlobalRule;
import br.com.felipediogo.dtos.InsertionDto;
import org.springframework.stereotype.Component;

@Component
public class GlobalRuleConverter {
	public InsertionDto toDTO(GlobalRule globalRule) {
		InsertionDto dto = new InsertionDto();
		dto.setClient(null);
		dto.setRegex(globalRule.getRegex());
		return dto;
	}
	
	public GlobalRule toEntity(InsertionDto dto) {
		GlobalRule entity = new GlobalRule();
		entity.setRegex(dto.getRegex());
		return entity;
	}
}
