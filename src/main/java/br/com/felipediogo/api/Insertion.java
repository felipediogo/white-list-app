package br.com.felipediogo.api;

import br.com.felipediogo.dtos.InsertionDto;
import br.com.felipediogo.messagequeue.listeners.InsertionListener;
import br.com.felipediogo.services.RuleService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Insertion {
    private static final Logger log = LoggerFactory.getLogger(InsertionListener.class);

    @Value("${INSERTION_QUEUE}")
    String INSERTION_QUEUE;

    @Value("${RESPONSE_EXCHANGE}")
    String exchange;

    @Autowired
    AmqpTemplate amqpTemplate;
    
    @Autowired
    RuleService ruleService;

    @PostMapping({ "/insert/rule" })
    public void insertRule(@RequestBody InsertionDto input) {
        log.info(input.toString());
        ruleService.addRule(input);
    }
    
    @PostMapping({ "/insert/global-rule" })
    public void insertGlobalRule(@RequestBody InsertionDto input) {
        log.info(input.toString());
        ruleService.addGlobalRule(input);
    }
    
    @GetMapping({ "/rules" })
    public void getAllRules() {
    	log.info("Buscando todas as rules");
    	ruleService.getAllRules();
    }
}
