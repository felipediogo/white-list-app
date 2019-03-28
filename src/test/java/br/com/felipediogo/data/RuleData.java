package br.com.felipediogo.data;

import br.com.felipediogo.database.entities.Rule;

import java.util.Arrays;
import java.util.List;

public class RuleData {
    static final String REGEX_01 = "^(\\b*www.google.com\\b*)";
    public static final String CLIENT_01 = "1234567890";
    static final String REGEX_02 = "[abc]";

    public static Rule ruleData1() {
        Rule rule = new Rule();
        rule.setRegex(REGEX_01);
        rule.setClient(CLIENT_01);
        rule.setId(0L);
        return rule;
    }

    private static Rule ruleData2() {
        Rule rule = new Rule();
        rule.setRegex(REGEX_02);
        rule.setClient(CLIENT_01);
        rule.setId(1L);
        return rule;
    }

    public static List<Rule> rules() {
        return Arrays.asList(ruleData1(), ruleData2());
    }

}
