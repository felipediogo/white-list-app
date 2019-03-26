package br.com.felipediogo.dtos;

import java.io.Serializable;

public class ResponseDto implements Serializable {
    private Boolean match;
    private String regex;
    private int correlationId;

    public Boolean getMatch() {
        return match;
    }

    public void setMatch(Boolean match) {
        this.match = match;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public int getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(int correlationId) {
        this.correlationId = correlationId;
    }
}
