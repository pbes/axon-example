package hu.besp.axonexample.offer.command;

import hu.besp.axonexample.offer.dto.CreateOfferDTO;
import hu.besp.axonexample.offer.entity.OfferType;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class CreateOfferCommand {
    private final String id;
    private final String product;
    private final String userId;
    private final OfferType offerType;
    private final BigDecimal quantity;
    private final BigDecimal price;


    public CreateOfferCommand(CreateOfferDTO dto) {
        this.id = UUID.randomUUID().toString();
        this.product = dto.getProduct();
        this.userId = dto.getUserId();
        this.offerType = dto.getOfferType();
        this.quantity = dto.getQuantity();
        this.price = dto.getPrice();
    }
}
