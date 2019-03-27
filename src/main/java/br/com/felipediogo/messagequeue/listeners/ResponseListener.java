package br.com.felipediogo.messagequeue.listeners;

import br.com.felipediogo.dtos.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ResponseListener {
    private static final Logger log = LoggerFactory.getLogger(ResponseListener.class);

    @RabbitListener(queues = "${RESPONSE_ROUTING_KEY}", containerFactory = "rabbitListenerContainerFactory")
    public void recievedMessage(@Payload ResponseDto response) {
        log.info(response.getRegex());
        log.info(Integer.toString(response.getCorrelationId()));
        log.info(Boolean.toString(response.getMatch()));
    }
}
