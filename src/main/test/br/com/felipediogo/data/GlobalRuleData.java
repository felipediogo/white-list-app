package br.com.felipediogo.data;

import br.com.felipediogo.database.entities.GlobalRule;

import static br.com.felipediogo.data.RuleData.REGEX_01;

public class GlobalRuleData {


    public static GlobalRule globalRuleData1() {
        GlobalRule globalRule = new GlobalRule();
        globalRule.setRegex(REGEX_01);
        globalRule.setId(0L);
        return globalRule;
    }

}
