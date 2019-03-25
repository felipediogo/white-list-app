package br.com.felipediogo.converters;

import org.springframework.stereotype.Component;

import br.com.felipediogo.database.entities.Rule;
import br.com.felipediogo.dtos.InsertionDto;

@Component
public class RuleConverter {
	
	public InsertionDto toDTO(Rule rule) {
		InsertionDto dto = new InsertionDto();
		dto.setClient(rule.getClient());
		dto.setRegex(rule.getRegex());
		return new InsertionDto();
	}
	
	public Rule toEntity(InsertionDto dto) {
		Rule entity = new Rule();
		entity.setClient(dto.getClient());
		entity.setRegex(dto.getRegex());
		return entity;
	}
}
