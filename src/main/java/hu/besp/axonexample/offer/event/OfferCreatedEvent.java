package hu.besp.axonexample.offer.event;

import hu.besp.axonexample.offer.entity.OfferType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OfferCreatedEvent {
    private final String offerId;
    private final String productId;
    private final String userId;
    private final OfferType type;
    private final BigDecimal quantity;
    private final BigDecimal price;
}
