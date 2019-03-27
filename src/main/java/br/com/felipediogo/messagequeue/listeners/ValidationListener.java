package br.com.felipediogo.messagequeue.listeners;

import br.com.felipediogo.dtos.ResponseDto;
import br.com.felipediogo.dtos.ValidationDto;
import br.com.felipediogo.services.ValidationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ValidationListener {
    @Value("${RESPONSE_ROUTING_KEY}")
    String responseQueue;

    @Autowired
    ValidationService validationService;

    @Autowired
    AmqpTemplate amqpTemplate;

    public ValidationListener(ValidationService validationService) {
        super();
        this.validationService= validationService;
    }



    @RabbitListener(queues = "${VALIDATION_QUEUE}", containerFactory = "rabbitListenerContainerFactory")
    public void listener(@Payload ValidationDto input) {
        ResponseDto response = validationService.findWhiteList(input);
        amqpTemplate.convertAndSend(responseQueue, response);
    }
}
