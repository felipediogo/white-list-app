package br.com.felipediogo.messagequeue.listeners;

import br.com.felipediogo.dtos.InsertionDto;
import br.com.felipediogo.services.RuleService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class InsertionListener {

    private static final Logger log = LoggerFactory.getLogger(InsertionListener.class);

    @Autowired
    RuleService ruleService;
    
    public InsertionListener(RuleService ruleService) {
		super();
		this.ruleService = ruleService;
	}



	@RabbitListener(queues = "${INSERTION_QUEUE}", containerFactory = "rabbitListenerContainerFactory")
    public void recievedMessage(@Payload InsertionDto input) {
        log.debug("Received message -> {}", input.toString());
        ruleService.addRule(input);
    }
}