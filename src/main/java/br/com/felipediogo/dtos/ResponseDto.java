package br.com.felipediogo.dtos;

import org.apache.commons.lang3.builder.EqualsBuilder;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ResponseDto response = (ResponseDto) o;

        return new EqualsBuilder()
                .append(regex, response.regex)
                .append(match, response.match)
                .append(correlationId, response.correlationId)
                .isEquals();

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ResponseDto{");
        sb.append("correlationId='").append(correlationId).append('\'');
        sb.append(", regex='").append(regex).append('\'');
        sb.append(", match='").append(match).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
