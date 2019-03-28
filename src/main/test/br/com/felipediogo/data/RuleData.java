package br.com.felipediogo.data;

import br.com.felipediogo.database.entities.Rule;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class RuleData {
    public static final String REGEX_01 = "^(\\b*www.google.com\\b*)";
    public static final String CLIENT_01 = "1234567890";
    public static final String REGEX_02 = "[abc]";
    public static final String CLIENT_02 = "09876543221";
    public static final String REGEX_03 = "CREATE THIRD REGEX";

    public static Rule ruleData1() {
        Rule rule = new Rule();
        rule.setRegex(REGEX_01);
        rule.setClient(CLIENT_01);
        rule.setId(0L);
        return rule;
    }

    public static Rule ruleData2() {
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
