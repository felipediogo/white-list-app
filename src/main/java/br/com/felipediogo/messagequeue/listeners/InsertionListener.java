package br.com.felipediogo.messagequeue.listeners;

import br.com.felipediogo.dtos.InsertionDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class InsertionListener {

    private static final Logger log = LoggerFactory.getLogger(InsertionListener.class);

    @RabbitListener(queues = "${INSERTION_QUEUE}", containerFactory = "rabbitListenerContainerFactory")
    public void recievedMessage(@Payload InsertionDto message) {
        log.info(message.toString());
    }
}