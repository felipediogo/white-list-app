package br.com.felipediogo.messagequeue;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class MessageQueueConfig {
    @Value("${INSERTION_QUEUE}")
    String insertQueue;

    @Value("${VALIDATION_QUEUE}")
    String validationQueue;

    @Value("${RESPONSE_ROUTING_KEY}")
    String responseQueue;

    @Value("${RESPONSE_EXCHANGE}")
    String exchange;

    @Value("${RABBITMQ_HOST}")
    String host;

    @Value("${RABBITMQ_USERNAME}")
    String username;

    @Value("${RABBITMQ_PASSWORD}")
    String password;

    @Value("${RABBITMQ_PORT}")
    Integer port;

    @Value("${RABBITMQ_VHOST}")
    String virtualHost;

    @Value("${NUMBER_OF_VALIDATION_CONSUMERS}")
    String numberOfConsumers;

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(host);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setPort(port);
        connectionFactory.setVirtualHost(virtualHost);
        return new CachingConnectionFactory(host);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }


    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory,
                                                                               SimpleRabbitListenerContainerFactoryConfigurer configurer) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        factory.setMessageConverter(jsonMessageConverter());
        factory.setConnectionFactory(connectionFactory());
        factory.setConcurrentConsumers(Integer.parseInt(numberOfConsumers));
        return factory;
    }

    @Bean
    Queue insert() {
        return new Queue(insertQueue, false);
    }

    @Bean
    Queue validation() {
        return new Queue(validationQueue, false);
    }

    @Bean
    Queue response() {
        return new Queue(responseQueue, false);
    }

    @Bean
    DirectExchange topicExchange() {
        return new DirectExchange(exchange);
    }

    @Bean
    Binding bindInsertQueue(@Qualifier("insert") Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(insertQueue);
    }

    @Bean
    Binding bindValidationQueue(@Qualifier("validation") Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(validationQueue);
    }

    @Bean
    Binding bindResponseQueue(@Qualifier("response") Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(responseQueue);
    }
}
