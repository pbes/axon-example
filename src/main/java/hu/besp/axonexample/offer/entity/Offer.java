package hu.besp.axonexample.offer.entity;

import hu.besp.axonexample.offer.dto.OfferDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "offers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Offer {

    @Id
    private String id;

    private String userId;

    private String product;

    @Enumerated(EnumType.STRING)
    private OfferType type;

    private BigDecimal quantity;

    private BigDecimal price;
}
