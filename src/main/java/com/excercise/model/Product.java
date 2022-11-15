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
@Entity(name="t_product")
public class Product {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotNull
    private Long productFunds;
    @OneToMany
    @JoinColumn(name ="t_campaign")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Campaign> campaigns;

    private static AtomicInteger idSequence = new AtomicInteger();

    public void setId() {
        this.id = (long) idSequence.incrementAndGet();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return id.equals(product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
