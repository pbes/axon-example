package hu.besp.axonexample.offer.projection;

import hu.besp.axonexample.offer.dto.OfferDTO;
import hu.besp.axonexample.offer.entity.Offer;
import hu.besp.axonexample.offer.entity.OfferState;
import hu.besp.axonexample.offer.event.OfferCreatedEvent;
import hu.besp.axonexample.offer.event.OfferRevokedEvent;
import hu.besp.axonexample.offer.query.ListAllOffersQuery;
import hu.besp.axonexample.offer.repository.OfferRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferProjection {

    private final OfferRepository offerRepository;

    public OfferProjection(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @EventHandler
    void write(OfferCreatedEvent offerCreatedEvent) {
        var offerEntity = new Offer(
                offerCreatedEvent.getOfferId(),
                offerCreatedEvent.getUserId(),
                offerCreatedEvent.getProductId(),
                offerCreatedEvent.getType(),
                offerCreatedEvent.getState(),
                offerCreatedEvent.getQuantity(),
                offerCreatedEvent.getPrice()
        );
        this.offerRepository.save(offerEntity);
    }

    @EventHandler
    void delete(OfferRevokedEvent offerRevokedEvent) {
        this.offerRepository.findById(offerRevokedEvent.getOfferId()).ifPresent(offer -> {
            offer.setState(OfferState.REVOKED);
            this.offerRepository.save(offer);
        });
    }

    @QueryHandler
    List<OfferDTO> read(ListAllOffersQuery query) {
        return this.offerRepository.findAll().stream().map(offer -> new OfferDTO(
                offer.getId(),
                offer.getUserId(),
                offer.getProduct(),
                offer.getType(),
                offer.getState(),
                offer.getQuantity(),
                offer.getPrice()
        )).collect(Collectors.toList());
    }
}
