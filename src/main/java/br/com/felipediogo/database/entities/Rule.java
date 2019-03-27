package br.com.felipediogo.database.entities;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table(name = "rules")
public class Rule {

    @Nullable
    private String client;

    @NonNull
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Rule rule = (Rule) o;

        return new EqualsBuilder()
                .append(id, rule.id)
                .append(regex, rule.regex)
                .append(client, rule.client)
                .isEquals();
    }

}