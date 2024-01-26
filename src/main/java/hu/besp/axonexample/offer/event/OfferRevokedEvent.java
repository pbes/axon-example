package hu.besp.axonexample.offer.event;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class OfferRevokedEvent {
    private final String offerId;
}
