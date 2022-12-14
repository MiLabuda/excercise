package com.excercise.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "t_campaign")
public class Campaign {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Id
    private Long id;
    @NotBlank
    private String name;
    @NotNull
    @ElementCollection(targetClass=String.class)
    private List<String> keywords;
    @NotNull
    private Long minimalBid;
    @NotNull
    private Long campaignFunds;

    private boolean activeStatus;
    @NotBlank
    private String targetTown;
    @NotNull
    private int radiusInKm;
    @ManyToOne
    @JoinColumn(name = "t_product")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Product product;
//    private User user;

    private static AtomicInteger idSequence = new AtomicInteger();

    public void setId() {
        this.id = (long) idSequence.incrementAndGet();
    }

    enum Town {
        KRAKOW,
        WARSZAWA,
        GDANSK,
        WROCLAW,
        KATOWICE
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Campaign)) return false;
        Campaign campaign = (Campaign) o;
        return id.equals(campaign.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}