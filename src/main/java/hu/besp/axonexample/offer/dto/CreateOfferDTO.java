package hu.besp.axonexample.offer.dto;

import hu.besp.axonexample.offer.entity.OfferType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class CreateOfferDTO {
    protected String userId;
    protected String product;
    protected OfferType offerType;
    protected BigDecimal quantity;
    protected BigDecimal price;
}
