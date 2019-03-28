package br.com.felipediogo.data;

import br.com.felipediogo.database.entities.GlobalRule;
import jdk.nashorn.internal.objects.Global;

import java.util.Arrays;
import java.util.List;

import static br.com.felipediogo.data.RuleData.REGEX_01;
import static br.com.felipediogo.data.RuleData.REGEX_02;

public class GlobalRuleData {


    public static GlobalRule globalRuleData1() {
        GlobalRule globalRule = new GlobalRule();
        globalRule.setRegex(REGEX_01);
        globalRule.setId(0L);
        return globalRule;
    }

    public static GlobalRule globalRuleData2() {
        GlobalRule globalRule = new GlobalRule();
        globalRule.setRegex(REGEX_02);
        globalRule.setId(1L);
        return globalRule;
    }

    public static List<GlobalRule> globalRules() {
        return Arrays.asList(globalRuleData1(), globalRuleData2());
    }

}
