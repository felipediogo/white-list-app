package br.com.felipediogo.database.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "global_rules")
public class GlobalRule {	

    @NonNull
    private String regex;

    public String getRegex() {
        return regex;
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

        GlobalRule globalRule = (GlobalRule) o;

        return new EqualsBuilder()
                .append(id, globalRule.id)
                .append(regex, globalRule.regex)
                .isEquals();
    }
}
