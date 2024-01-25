package hu.besp.axonexample.offer.aggregate;

import hu.besp.axonexample.offer.command.CreateOfferCommand;
import hu.besp.axonexample.offer.event.OfferCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class OfferAggregate {

    @AggregateIdentifier
    private String id;

    @CommandHandler
    public OfferAggregate(CreateOfferCommand command) {
        apply(new OfferCreatedEvent(
                command.getId(),
                command.getProduct(),
                command.getUserId(),
                command.getOfferType(),
                command.getQuantity(),
                command.getPrice()
        ));
    }

    @EventSourcingHandler
    void handle(OfferCreatedEvent event) {
        this.id = event.getOfferId();
    }

}
