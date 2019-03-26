package br.com.felipediogo.dtos;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.springframework.lang.Nullable;

import java.io.Serializable;

public class InsertionDto implements Serializable {
    @Nullable
    private String client;

    private String regex;

    public String getClient() {
        return client;
    }

    public String getRegex() {
        return regex;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        InsertionDto rule = (InsertionDto) o;

        return new EqualsBuilder()
                .append(regex, rule.regex)
                .append(client, rule.client)
                .isEquals();
    }
}
