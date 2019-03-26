package br.com.felipediogo.api;

import br.com.felipediogo.dtos.InsertionDto;
import br.com.felipediogo.dtos.ResponseDto;
import br.com.felipediogo.dtos.ValidationDto;
import br.com.felipediogo.messagequeue.listeners.InsertionListener;
import br.com.felipediogo.services.RuleService;
import br.com.felipediogo.services.ValidationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Insertion {
    private static final Logger log = LoggerFactory.getLogger(InsertionListener.class);
    
    @Autowired
    RuleService ruleService;

    @Autowired
    ValidationService validationService;

    @PostMapping({ "/insert/rule" })
    public void insertRule(@RequestBody InsertionDto input) {
        log.info(input.toString());
        ruleService.addRule(input);
    }
    
    @PostMapping({ "/insert/global-rule" })
    public void insertGlobalRule(@RequestBody InsertionDto input) {
        log.info(input.toString());
        ruleService.addRule(input);
    }
    
    @GetMapping({ "/rules" })
    public ResponseEntity<List<InsertionDto>> getAllRules(@RequestBody InsertionDto input) {
    	log.info("Buscando todas as rules");
    	return ResponseEntity.ok(ruleService.getAllRules(input.getClient()));
    }

    @PostMapping({ "/validation" })
    public ResponseEntity<ResponseDto> insertGlobalRule(@RequestBody ValidationDto input) {
        log.info(input.toString());
        return ResponseEntity.ok(validationService.findWhiteList(input));
    }

}
