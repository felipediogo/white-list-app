package br.com.felipediogo.data;

import br.com.felipediogo.database.entities.Rule;

public class RuleData {
    public static final String REGEX_01 = "[^a-z^A-Z^0-9\\^_]+";
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

}
