package br.com.felipediogo.dtos;

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
    public String toString() {
        return "client -  " +
                client +
                "regex -  " +
                regex;
    }
}
