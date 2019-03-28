package br.com.felipediogo.converters;

import br.com.felipediogo.database.entities.Rule;
import br.com.felipediogo.dtos.InsertionDto;
import org.springframework.stereotype.Component;

@Component
public class RuleConverter {
	
	public InsertionDto toDTO(Rule rule) {
		InsertionDto dto = new InsertionDto();
		dto.setClient(rule.getClient());
		dto.setRegex(rule.getRegex());
		return dto;
	}
	
	public Rule toEntity(InsertionDto dto) {
		Rule entity = new Rule();
		entity.setClient(dto.getClient());
		entity.setRegex(dto.getRegex());
		return entity;
	}
}
