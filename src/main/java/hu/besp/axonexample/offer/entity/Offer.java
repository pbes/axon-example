package hu.besp.axonexample.offer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "offers")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Offer {

    @Id
    private String id;

    private String userId;

    private String product;

    @Enumerated(EnumType.STRING)
    private OfferType type;

    @Enumerated(EnumType.STRING)
    private OfferState state;

    private BigDecimal quantity;

    private BigDecimal price;
}
