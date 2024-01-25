package hu.besp.axonexample.offer.dto;

import hu.besp.axonexample.offer.entity.OfferType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OfferDTO extends CreateOfferDTO {
    private String id;

    public OfferDTO(String id, String product, String userId, OfferType offerType, BigDecimal quantity, BigDecimal price) {
        super(userId, product, offerType, quantity, price);
        this.id = id;
    }

}
