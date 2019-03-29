package br.com.felipediogo.messagequeue.listeners;

import br.com.felipediogo.dtos.InsertionDto;
import br.com.felipediogo.services.RuleService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class InsertionListener {

    private RuleService ruleService;
    
    public InsertionListener(RuleService ruleService) {
		this.ruleService = ruleService;
	}



	@RabbitListener(queues = "${INSERTION_QUEUE}", containerFactory = "rabbitListenerContainerFactory")
    public void listener(@Payload InsertionDto input) {
        ruleService.addRule(input);
    }
}