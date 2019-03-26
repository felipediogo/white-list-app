package br.com.felipediogo.dtos;

import org.apache.commons.lang3.builder.EqualsBuilder;

import java.io.Serializable;

public class ValidationDto implements Serializable {
    private String url;
    private String client;
    private int correlationId;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
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

        ValidationDto validation = (ValidationDto) o;

        return new EqualsBuilder()
                .append(url, validation.url)
                .append(client, validation.client)
                .append(correlationId, validation.correlationId)
                .isEquals();
    }
}
