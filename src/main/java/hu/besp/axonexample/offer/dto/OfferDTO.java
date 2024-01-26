package hu.besp.axonexample.offer.dto;

import hu.besp.axonexample.offer.entity.OfferState;
import hu.besp.axonexample.offer.entity.OfferType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OfferDTO extends CreateOfferDTO {
    private String id;
    private OfferState state;

    public OfferDTO(String id, String product, String userId, OfferType offerType, OfferState state, BigDecimal quantity, BigDecimal price) {
        super(userId, product, offerType, quantity, price);
        this.id = id;
        this.state = state;
    }

}
